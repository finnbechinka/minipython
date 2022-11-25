package Nodes;

public class IDNode extends ASTNode{

    private String id;

    public IDNode(String id){
        this.id = id;
    }

    @Override
    public String toStringTree() {
        return "ID: " + id;
    }
    
}
