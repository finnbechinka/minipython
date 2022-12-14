package nodes;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class WhileStmtNode extends ASTNode {

  private Scope scope;
  private ASTNode condition;
  private ASTNode body;

  public WhileStmtNode(ASTNode condition, ASTNode body) {
    this.condition = condition;
    this.body = body;
  }

  public Tree getChild(int arg0) {
    return arg0 == 0 ? condition : body;
  }

  public int getChildCount() {
    return 2;
  }

  public ASTNode getCondition() {
    return this.condition;
  }

  public ASTNode getBody() {
    return this.body;
  }

  @Override
  public String toStringTree() {
    return "WHILE";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  public Scope getScope() {
    return this.scope;
  }

  @Override
  public void setScope(Scope scope) {
    this.scope = scope;
  }
}
