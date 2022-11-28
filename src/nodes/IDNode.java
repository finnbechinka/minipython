package nodes;

import scopes.Scope;
import visitors.ASTVisitor;

public class IDNode extends ASTNode{

    private Scope scope;

    private String id;

    public IDNode(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toStringTree() {
        return "ID: " + id;
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
