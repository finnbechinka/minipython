package nodes;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.*;

public abstract class ASTNode implements Tree {

  public abstract <T> T accept(ASTVisitor<T> visitor);

  public abstract void setScope(Scope scope);

  public abstract Scope getScope();

  public Tree getChild(int arg0) {
    return null;
  }

  public int getChildCount() {
    return 0;
  }

  @Override
  public Tree getParent() {
    return null;
  }

  @Override
  public Object getPayload() {
    return this;
  }

  @Override
  public abstract String toStringTree();

  @Override
  public String toString() {
    return toStringTree();
  }
}
