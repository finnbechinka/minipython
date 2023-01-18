package nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class FuncDefNode extends ASTNode {

  private Scope scope;

  private String id;
  private List<String> parameters;
  private List<String> parameterTypes;
  private ASTNode body;
  private String returnType;
  private ASTNode returnExpr;

  public FuncDefNode(String id, List<String> parameters, List<String> parameterTypes, ASTNode body, String returnType, ASTNode returnExpr) {
    this.id = id;
    this.parameters = parameters;
    this.parameterTypes = parameterTypes;
    this.body = body;
    this.returnType = returnType;
    this.returnExpr = returnExpr;
  }

  public Tree getChild(int arg0) {
    return arg0 == 0 ? body : returnExpr;
  }

  public int getChildCount() {
    return returnExpr == null ? 1 : 2;
  }

  public String getId() {
    return this.id;
  }

  public List<String> getParameters() {
    return this.parameters;
  }

  public List<String> getParameterTypes() {
    return this.parameterTypes;
  }

  public ASTNode getBody() {
    return this.body;
  }

  public String getReturnType(){
    return this.returnType;
  }

  public ASTNode getReturnExpr() {
    return this.returnExpr;
  }

  @Override
  public String toStringTree() {
    StringBuilder s = new StringBuilder();
    
    s.append(String.format("FuncDef: %s:%s  Parameters: [", id, returnType));
    for(int i=0; i < parameters.size(); i++) {
      s.append(String.format("%s:%s,", parameters.get(i), parameterTypes.get(i)));
    }
    s.setCharAt(s.length()-1, ']');

    return s.toString();
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
