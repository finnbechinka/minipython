package nodes;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class AssignNode extends ASTNode {

  private Scope scope;
  private ASTNode id;
  private String type;
  private ASTNode valueNode;

  public AssignNode(ASTNode id, String type, ASTNode valueNode) {
    this.id = id;
    this.type = type;
    this.valueNode = valueNode;
  }

  public Tree getChild(int arg0) {
    return arg0 == 0 ? id : valueNode;
  }

  public int getChildCount() {
    return 2;
  }

  public ASTNode getId() {
    return this.id;
  }

  public String getType() {
    return this.type;
  }

  public ASTNode getValueNode() {
    return this.valueNode;
  }

  @Override
  public String toStringTree() {
    return "Assign " + type;
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
