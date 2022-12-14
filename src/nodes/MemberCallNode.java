package nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class MemberCallNode extends ASTNode {

  private Scope scope;
  private String instanceID;
  private String methodID;

  private List<ASTNode> args;

  public MemberCallNode(String instanceID, String methodID, List<ASTNode> args) {
    this.instanceID = instanceID;
    this.methodID = methodID;
    this.args = args;
  }

  public Tree getChild(int arg0) {
    return args.get(arg0);
  }

  public int getChildCount() {
    return args.size();
  }

  public String getInstanceId() {
    return this.instanceID;
  }

  public String getMethodId() {
    return this.methodID;
  }

  public List<ASTNode> getArgs() {
    return this.args;
  }

  @Override
  public String toStringTree() {
    return "MethodCall: " + instanceID + "." + methodID;
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
