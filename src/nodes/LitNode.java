package nodes;

import scopes.Scope;
import visitors.ASTVisitor;

public class LitNode<T> extends ASTNode {

    private Scope scope;

    private T value;

    public LitNode(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    @Override
    public String toStringTree() {
        return value.getClass().getSimpleName() + ": " + value.toString();
    }

    @Override
    public <G> G accept(ASTVisitor<G> visitor) {
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
