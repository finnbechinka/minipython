package visitors;

import environment.*;
import environment.functions.Input;
import environment.functions.Print;
import nodes.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.plaf.nimbus.State;

import CBuilder.*;
import CBuilder.literals.*;
import CBuilder.variables.*;
import CBuilder.conditions.*;
import CBuilder.objects.*;
import CBuilder.objects.functions.Argument;
import CBuilder.objects.functions.Function;
import CBuilder.keywords.*;
import CBuilder.keywords.bool.AndKeyword;
import CBuilder.keywords.bool.NotKeyword;
import CBuilder.keywords.bool.OrKeyword;
import CBuilder.conditions.conditionalStatement.*;

class NoSuperException extends Exception {
  public NoSuperException(String message) {
    super(message);
  }
}

public class ASTBuildVisitor implements ASTVisitor<Object> {
  private final Path output_folder;
  private ProgramBuilder builder;

  public ASTBuildVisitor(Path folder) {
    this.output_folder = folder;
    this.builder = new ProgramBuilder();
  }

  @Override
  public Object visit(AssignNode node) {
    Object ref = (Object) visit(node.getId());
    Expression value = (Expression) visit(node.getValueNode());

    if (ref instanceof AttributeReference) {
      return new AttributeAssignment((AttributeReference) ref, value);
    }

    return new Assignment((Reference) ref, value);
  }

  @Override
  public Object visit(BinaryExprNode node) {
    Object rightNode = visit(node.getRightNode());
    Object leftNode = visit(node.getLeftNode());

    switch (node.getOperator()) {
      case "+" -> {
        AttributeReference attRef = new AttributeReference("__add__", (Expression) leftNode);
        Call add = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return add;
      }
      case "-" -> {
        AttributeReference attRef = new AttributeReference("__sub__", (Expression) leftNode);
        Call sub = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return sub;
      }
      case "/" -> {
        AttributeReference attRef = new AttributeReference("__div__", (Expression) leftNode);
        Call div = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return div;
      }
      case "*" -> {
        AttributeReference attRef = new AttributeReference("__mul__", (Expression) leftNode);
        Call mul = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return mul;
      }
      case "==" -> {
        AttributeReference attRef = new AttributeReference("__eq__", (Expression) leftNode);
        Call eq = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return eq;
      }
      case "!=" -> {
        AttributeReference attRef = new AttributeReference("__ne__", (Expression) leftNode);
        Call ne = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return ne;
      }
      case ">=" -> {
        AttributeReference attRef = new AttributeReference("__ge__", (Expression) leftNode);
        Call ge = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return ge;
      }
      case ">" -> {
        AttributeReference attRef = new AttributeReference("__gt__", (Expression) leftNode);
        Call gt = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return gt;
      }
      case "<=" -> {
        AttributeReference attRef = new AttributeReference("__le__", (Expression) leftNode);
        Call le = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return le;
      }
      case "<" -> {
        AttributeReference attRef = new AttributeReference("__lt__", (Expression) leftNode);
        Call lt = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
        return lt;
      }
      case "and" -> {
        Expression and = new AndKeyword((Expression) leftNode, (Expression) rightNode);
        return and;
      }
      case "or" -> {
        Expression or = new OrKeyword((Expression) leftNode, (Expression) rightNode);
        return or;
      }
      default -> throw new UnsupportedOperationException();
    }
  }

  @Override
  public Object visit(UnaryExprNode node) {
    Expression e = (Expression) visit(node.getChildNode());
    if ("not".equals(node.getOperator())) {
      Expression not = new NotKeyword(e);
      return not;
    }
    return null;
  }

  @Override
  public Object visit(BlockNode node) {
    List<Statement> stmts = new ArrayList<Statement>();
    for (ASTNode instr : node.getInstructions()) {
      // if (instr instanceof AssignNode) {
      // AssignNode assignment = (AssignNode) instr;
      // IDNode idn = (IDNode) assignment.getId();
      // VariableDeclaration var = new VariableDeclaration(idn.getId());
      // builder.addVariable(var);
      // }
      stmts.add((Statement) visit(instr));
    }
    return stmts;
  }

  @Override
  public Object visit(CallNode node) {
    IDNode idn = (IDNode) node.getId();
    List<Object> args = new ArrayList<>();
    for (ASTNode arg : node.getArgs()) {
      args.add(visit(arg));
    }

    List<Expression> params = new ArrayList<Expression>();
    for (Object arg : args) {
      params.add((Expression) arg);
    }

    if (idn.getId().equals("super")) {
      return new SuperCall(params);
    }

    String instance = ((IDNode) node.getId()).getInstanceId();
    if (instance != null) {
      return new Call(new AttributeReference(idn.getId(), new Reference((String) instance)), params);
    }
    Reference ref = new Reference(idn.getId());
    Call call = new Call(ref, params);
    return call;
  }

  @Override
  public Object visit(ClazzDefNode node) {
    List<Function> methods = new ArrayList<>();
    Boolean hasInit = false;
    Function firstMethod = (Function) visit(node.getMethods().get(0));
    if (!firstMethod.getName().equals("__init__")) {
      Statement simpleSuperCall = new SuperCall(List.of());
      List<Statement> initBody = List.of(new Statement[] { simpleSuperCall });
      List<Argument> initParamList = List.of(new Argument[] { new Argument("self", 0) });
      methods.add(new Function("__init__", initBody, initParamList, List.of()));
    } else {
      hasInit = true;
      ASTNode firstStatement = ((BlockNode) ((FuncDefNode) node.getMethods().get(0)).getBody()).getInstructions()
          .get(0);
      if (!(firstStatement instanceof CallNode)) {

        Statement simpleSuperCall = new SuperCall(List.of());
        List<Statement> body = (List<Statement>) visit(((FuncDefNode) node.getMethods().get(0)).getBody());
        body.add(0, simpleSuperCall);
        List<Argument> params = new ArrayList<Argument>();
        List<VariableDeclaration> vars = new ArrayList<VariableDeclaration>();

        for (int i = 0; i < ((FuncDefNode) node.getMethods().get(0)).getParameters().size(); i++) {
          params.add(new Argument(((FuncDefNode) node.getMethods().get(0)).getParameters().get(i), i));
        }

        BlockNode block = (BlockNode) ((FuncDefNode) node.getMethods().get(0)).getBody();
        for (ASTNode instr : block.getInstructions()) {
          if (instr instanceof AssignNode) {
            AssignNode assignment = (AssignNode) instr;
            IDNode idn = (IDNode) assignment.getId();
            vars.add(new VariableDeclaration(idn.getId()));
          }
        }

        methods.add(new Function("__init__", body, params, vars));
      } else {

        CallNode call = (CallNode) firstStatement;
        if (((IDNode) call.getId()).getId().equals("super")) {

          methods.add((Function) visit(node.getMethods().get(0)));
        }
      }
    }

    for (ASTNode m : node.getMethods()) {
      if (hasInit && node.getMethods().indexOf(m) == 0) {
        continue;
      }
      Function method = (Function) visit(m);
      methods.add(method);
    }
    Reference superClass = new Reference("__MPyType_Object");

    if (node.getParentId() != null) {
      superClass = new Reference(node.getParentId());
    }

    return new MPyClass(node.getId(), superClass, methods, Map.of());
  }

  @Override
  public Object visit(IfStmtNode node) {
    Expression ifCondition = (Expression) visit(node.getIfCondition());
    BlockNode ifBlock = (BlockNode) node.getIfBody();
    declareVariables(ifBlock.getInstructions());

    List<Statement> ifBody = (List<Statement>) visit(node.getIfBody());
    IfStatement ifStatement = new IfStatement(ifCondition, ifBody);

    List<ElifStatement> elifs = new ArrayList<ElifStatement>();
    for (ASTNode e : node.getElifs()) {
      ElifStmtNode elif = (ElifStmtNode) e;
      Expression elifCondition = (Expression) visit(elif.getCondition());
      BlockNode elifBlock = (BlockNode) elif.getBody();
      declareVariables(elifBlock.getInstructions());
      List<Statement> elifBody = (List<Statement>) visit(elif.getBody());
      ElifStatement elifStatement = new ElifStatement(elifCondition, elifBody);
      elifs.add(elifStatement);
    }

    BlockNode elseBlock = (BlockNode) node.getElseBody();
    declareVariables(elseBlock.getInstructions());
    List<Statement> elseBody = (List<Statement>) visit(node.getElseBody());
    ElseStatement elseStatement = new ElseStatement(elseBody);

    IfThenElseStatement conditional = new IfThenElseStatement(ifStatement, Optional.of(elifs),
        Optional.of(elseStatement));
    // builder.addStatement(conditional);
    return conditional;
  }

  @Override
  public Object visit(ElifStmtNode node) {
    return null;
  }

  @Override
  public Object visit(WhileStmtNode node) {
    Expression con = (Expression) visit(node.getCondition());
    BlockNode whileBlock = (BlockNode) node.getBody();
    declareVariables(whileBlock.getInstructions());
    List<Statement> body = (List<Statement>) visit(node.getBody());
    WhileStatement whileStatement = new WhileStatement(con, body);
    // builder.addStatement(whileStatement);
    return whileStatement;
  }

  @Override
  public Object visit(FuncDefNode node) {
    List<Statement> body = (List<Statement>) visit(node.getBody());
    List<Argument> params = new ArrayList<Argument>();
    List<VariableDeclaration> vars = new ArrayList<VariableDeclaration>();

    for (int i = 0; i < node.getParameters().size(); i++) {
      params.add(new Argument(node.getParameters().get(i), i));
    }

    BlockNode block = (BlockNode) node.getBody();
    for (ASTNode instr : block.getInstructions()) {
      if (instr instanceof AssignNode) {
        AssignNode assignment = (AssignNode) instr;
        IDNode idn = (IDNode) assignment.getId();
        vars.add(new VariableDeclaration(idn.getId()));
      }
    }

    return new Function(node.getId(), body, params, vars);
  }

  @Override
  public Object visit(IDNode node) {
    if (node.getInstanceId() != null) {
      return new AttributeReference(node.getId(), new Reference(node.getInstanceId()));
    }
    return new Reference(node.getId());
  }

  @Override
  public Object visit(LitNode<?> node) {
    if (node.getValue() instanceof Integer) {
      return new IntLiteral((Integer) node.getValue());
    }
    if (node.getValue() instanceof String) {
      return new StringLiteral((String) node.getValue());
    }
    if (node.getValue() instanceof Boolean) {
      return new BoolLiteral((Boolean) node.getValue());
    }
    return null;
  }

  @Override
  public Object visit(ProgNode node) {
    declareVariables(node.getStmts());
    for (ASTNode stmt : node.getStmts()) {

      Object e = (Object) visit(stmt);
      if (e instanceof MPyClass) {
        builder.addClass((MPyClass) e);
      } else if (e instanceof Function) {
        builder.addFunction((Function) e);
      } else if (e instanceof Statement) {
        builder.addStatement((Statement) e);
      }
    }
    builder.writeProgram(output_folder);
    return null;
  }

  private void declareVariables(List<ASTNode> statements) {
    for (ASTNode stmt : statements) {
      if (stmt instanceof AssignNode) {
        AssignNode assignment = (AssignNode) stmt;
        IDNode idn = (IDNode) assignment.getId();
        VariableDeclaration var = new VariableDeclaration(idn.getId());
        builder.addVariable(var);
      }
    }
  }
}
