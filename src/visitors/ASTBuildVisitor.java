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
    Object value = visit(node.getValueNode());

    Reference var = new Reference(node.getId().toString());
    Assignment ass = null;
    if (value instanceof Integer) {
      ass = new Assignment(var, new IntLiteral((int) value));
    }
    if (value instanceof String) {
      ass = new Assignment(var, new StringLiteral((String) value));
    }
    if (value instanceof Boolean) {
      ass = new Assignment(var, new BoolLiteral((Boolean) value));
    }

    if (ass != null) {
      builder.addStatement(ass);
    }

    return ass;
  }

  @Override
  public Object visit(BinaryExprNode node) {
    Object rightNode = visit(node.getRightNode());
    Object leftNode = visit(node.getLeftNode());

    switch (node.getOperator()) {
      case "+" -> {
        if (leftNode instanceof Integer && rightNode instanceof Integer)
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
      stmts.add((Statement) visit(instr));
    }
    return stmts;
  }

  @Override
  public Object visit(CallNode node) {
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
    return node.getId();
  }

  @Override
  public Object visit(LitNode<?> node) {
    return node.getValue();
  }

  @Override
  public Object visit(ProgNode node) {
    for (ASTNode stmt : node.getStmts()) {
      visit(stmt);
    }
    builder.writeProgram(output_folder);
    return null;
  }
}
