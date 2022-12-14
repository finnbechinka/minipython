package visitors;

import nodes.*;

public class ASTStringVisitor implements ASTVisitor<String> {

  @Override
  public String visit(AssignNode node) {
    return "";
  }

  @Override
  public String visit(BinaryExprNode node) {
    return "";
  }

  @Override
  public String visit(UnaryExprNode node) {
    return "";
  }

  @Override
  public String visit(BlockNode node) {
    String s = "\n";

    s += node.toStringTree() + ": " + node.getScope();
    for (ASTNode inst : node.getInstructions())
      s += visit(inst);

    return s;
  }

  @Override
  public String visit(CallNode node) {
    return "";
  }

  @Override
  public String visit(ClazzDefNode node) {
    String s = "\n";

    s += node.toStringTree() + ": " + node.getScope();

    for (ASTNode inst : node.getMethods())
      s += visit(inst);

    return s;
  }

  @Override
  public String visit(IfStmtNode node) {
    String s = "\n";

    s += node.toStringTree() + ": " + node.getScope();
    s += visit(node.getIfBody());

    for (ASTNode elif : node.getElifs())
      s += visit(elif);

    s += visit(node.getElseBody());

    return s;
  }

  @Override
  public String visit(ElifStmtNode node) {
    String s = "\n";

    s += node.toStringTree() + ": " + node.getScope();
    s += visit(node.getBody());

    return s;
  }

  @Override
  public String visit(WhileStmtNode node) {
    String s = "\n";

    s += node.toStringTree() + ": " + node.getScope();
    s += visit(node.getCondition());
    s += visit(node.getBody());

    return s;
  }

  @Override
  public String visit(FuncDefNode node) {
    String s = "\n";

    s += node.toStringTree() + ": " + node.getScope();

    s += visit(node.getBody());

    return s;
  }

  @Override
  public String visit(IDNode node) {

    return "";
  }

  @Override
  public String visit(LitNode<?> node) {

    return "";
  }

  @Override
  public String visit(ProgNode node) {
    String s = node.toStringTree() + ": " + node.getScope();
    for (ASTNode stmt : node.getStmts())
      s += visit(stmt);

    return s;
  }

}
