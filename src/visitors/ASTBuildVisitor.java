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

import CBuilder.*;
import CBuilder.literals.*;
import CBuilder.variables.*;

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

    return null;
  }

  @Override
  public Object visit(BinaryExprNode node) {
    return null;
  }

  @Override
  public Object visit(UnaryExprNode node) {
    return null;
  }

  @Override
  public Object visit(BlockNode node) {
    return null;
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
    return null;
  }

  @Override
  public Object visit(ElifStmtNode node) {
    return null;
  }

  @Override
  public Object visit(WhileStmtNode node) {
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
