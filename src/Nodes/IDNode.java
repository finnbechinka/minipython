package nodes;

import visitors.ASTVisitor;

public class IDNode extends ASTNode{

    private String id;

    public IDNode(String id){
        this.id = id;
    }

    @Override
    public String toStringTree() {
        return "ID: " + id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
