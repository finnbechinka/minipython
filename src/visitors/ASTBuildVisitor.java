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

import CBuilder.*;
import CBuilder.literals.*;
import CBuilder.variables.*;
import CBuilder.conditions.*;
import CBuilder.objects.*;
import CBuilder.keywords.*;
import CBuilder.conditions.conditionalStatement.*;

public class ASTBuildVisitor implements ASTVisitor<Object> {
  private final Path output_folder;
  private ProgramBuilder builder;

  public ASTBuildVisitor(Path folder) {
    this.output_folder = folder;
    this.builder = new ProgramBuilder();
  }

  @Override
  public Object visit(AssignNode node) {
    Reference ref = (Reference) visit(node.getId());
    Expression value = (Expression) visit(node.getValueNode());

    Assignment ass = new Assignment(ref, value);

    if (ass != null) {
      builder.addStatement(ass);
    }

    return ass;
  }

  @Override
  public Object visit(BinaryExprNode node) {
    Object rightNode = visit(node.getRightNode());
    Object leftNode = visit(node.getLeftNode());
    System.out.println(rightNode);
    System.out.println(leftNode);

    switch (node.getOperator()) {
      case "+" -> {
        if (leftNode instanceof Reference && rightNode instanceof IntLiteral) {
          AttributeReference attRef = new AttributeReference("__add__", (Reference) leftNode);
          Call add = new Call(attRef, List.of(new Expression[] { (Expression) rightNode }));
          return add;
        } else if (leftNode instanceof Integer && rightNode instanceof Integer)
          return (int) leftNode + (int) rightNode;
        else if (leftNode instanceof String && rightNode instanceof String) {
          return leftNode.toString() + rightNode;
        } else if (leftNode instanceof String) {
          return leftNode.toString() + rightNode;
        }
      }
      case "-" -> {
        if (leftNode instanceof Integer && rightNode instanceof Integer)
          return (int) leftNode - (int) rightNode;
      }
      case "/" -> {
        if (leftNode instanceof Integer && rightNode instanceof Integer)
          return (int) leftNode / (int) rightNode;
      }
      case "*" -> {
        if (leftNode instanceof Integer && rightNode instanceof Integer)
          return (int) leftNode * (int) rightNode;
      }
      case "==" -> {
        return leftNode.equals(rightNode);
      }
      case "!=" -> {
        return !leftNode.equals(rightNode);
      }
      case ">=" -> {
        if (rightNode instanceof Integer && leftNode instanceof Integer)
          return (int) leftNode >= (int) rightNode;
      }
      case ">" -> {
        if (rightNode instanceof Integer && leftNode instanceof Integer)
          return (int) leftNode > (int) rightNode;
      }
      case "<=" -> {
        if (rightNode instanceof Integer && leftNode instanceof Integer)
          return (int) leftNode <= (int) rightNode;
      }
      case "<" -> {
        if (rightNode instanceof Integer && leftNode instanceof Integer)
          return (int) leftNode < (int) rightNode;
      }
      case "and" -> {
        if (rightNode instanceof Boolean && leftNode instanceof Boolean)
          return (boolean) leftNode && (boolean) rightNode;
      }
      case "or" -> {
        if (rightNode instanceof Boolean && leftNode instanceof Boolean)
          return (boolean) leftNode || (boolean) rightNode;
      }
      default -> throw new UnsupportedOperationException();
    }
    return null;
  }

  @Override
  public Object visit(UnaryExprNode node) {
    Object val = visit(node.getChildNode());
    if ("not".equals(node.getOperator())) {
      return !(boolean) val;
    }
    return null;
  }

  @Override
  public Object visit(BlockNode node) {
    List<Statement> stmts = new ArrayList<Statement>();
    for (ASTNode instr : node.getInstructions()) {
      if (instr instanceof AssignNode) {
        AssignNode assignment = (AssignNode) instr;
        IDNode idn = (IDNode) assignment.getId();
        VariableDeclaration var = new VariableDeclaration(idn.getId());
        builder.addVariable(var);
      }
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

    if (idn.getId().contains("print")) {
      Reference printRef = new Reference("print");
      List<Expression> params = new ArrayList<Expression>();
      for (Object arg : args) {
        params.add((Expression) arg);
      }
      Call printCall = new Call(printRef, params);
      builder.addStatement(printCall);
    }
    return null;
  }

  @Override
  public Object visit(ClazzDefNode node) {
    return null;
  }

  @Override
  public Object visit(IfStmtNode node) {
    Expression ifCondition = new BoolLiteral((Boolean) visit(node.getIfCondition()));
    List<Statement> ifBody = (List<Statement>) visit(node.getIfBody());
    IfStatement ifStatement = new IfStatement(ifCondition, ifBody);

    List<ElifStatement> elifs = new ArrayList<ElifStatement>();
    for (ASTNode e : node.getElifs()) {
      ElifStmtNode elif = (ElifStmtNode) e;
      Expression elifCondition = new BoolLiteral((Boolean) visit(elif.getCondition()));
      List<Statement> elifBody = (List<Statement>) visit(elif.getBody());
      ElifStatement elifStatement = new ElifStatement(elifCondition, elifBody);
      elifs.add(elifStatement);
    }

    List<Statement> elseBody = (List<Statement>) visit(node.getElseBody());
    ElseStatement elseStatement = new ElseStatement(elseBody);

    Statement conditional = new IfThenElseStatement(ifStatement, Optional.of(elifs), Optional.of(elseStatement));
    builder.addStatement(conditional);
    return null;
  }

  @Override
  public Object visit(ElifStmtNode node) {
    return null;
  }

  @Override
  public Object visit(WhileStmtNode node) {
    Boolean con = (boolean) visit(node.getCondition());
    List<Statement> body = (List<Statement>) visit(node.getBody());
    Statement whileStatement = new WhileStatement(new BoolLiteral(con), body);
    builder.addStatement(whileStatement);
    return null;
  }

  @Override
  public Object visit(FuncDefNode node) {

    return null;
  }

  @Override
  public Object visit(IDNode node) {
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
    for (ASTNode stmt : node.getStmts()) {
      if (stmt instanceof AssignNode) {
        AssignNode assignment = (AssignNode) stmt;
        IDNode idn = (IDNode) assignment.getId();
        VariableDeclaration var = new VariableDeclaration(idn.getId());
        builder.addVariable(var);
      }
      visit(stmt);
    }
    builder.writeProgram(output_folder);
    return null;
  }
}
