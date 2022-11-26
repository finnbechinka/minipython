package nodes;

import visitors.ASTVisitor;

public class LitNode<T> extends ASTNode {

    private T value;

    public LitNode(T value){
        this.value = value;
    }

    @Override
    public String toStringTree() {
        return value.getClass().getSimpleName() + ": " + value.toString();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
