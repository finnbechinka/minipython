package nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class ProgNode extends ASTNode {

  private Scope scope;
  private List<ASTNode> stmts;

  public ProgNode(List<ASTNode> stmts) {
    this.stmts = stmts;
  }

  public Tree getChild(int arg0) {
    return stmts.get(arg0);
  }

  public int getChildCount() {
    return stmts.size();
  }

  public List<ASTNode> getStmts() {
    return this.stmts;
  }

  @Override
  public String toStringTree() {
    return "Prog";
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