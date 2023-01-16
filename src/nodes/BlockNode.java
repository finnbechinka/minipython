package nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class BlockNode extends ASTNode {

  private Scope scope;

  private List<ASTNode> instructions;

  public BlockNode(List<ASTNode> instructions) {
    this.instructions = instructions;
  }

  public Tree getChild(int arg0) {
    return instructions.get(arg0);
  }

  public int getChildCount() {
    return instructions.size();
  }

  public List<ASTNode> getInstructions() {
    return this.instructions;
  }

  @Override
  public String toStringTree() {
    return "Block";
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
