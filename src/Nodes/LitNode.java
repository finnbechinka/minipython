package Nodes;

public class LitNode<T> extends ASTNode {

    private T value;

    public LitNode(T value){
        this.value = value;
    }

    @Override
    public String toStringTree() {
        return value.getClass().getSimpleName() + ": " + value.toString();
    }
    
}
