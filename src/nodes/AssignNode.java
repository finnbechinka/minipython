package nodes;
import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class AssignNode extends ASTNode{

    private Scope scope;

    private ASTNode id;
    private ASTNode valueNode;

    public AssignNode(ASTNode id, ASTNode valueNode){

        this.id = id;
        this.valueNode = valueNode;
    }

    public Tree getChild(int arg0) {
        return arg0 == 0 ? id : valueNode;
    }

    public int getChildCount() {
        return 2;
    }

    public ASTNode getId(){
        return this.id;
    }

    public ASTNode getValueNode(){
        return this.valueNode;
    }

    @Override
    public String toStringTree() {
        return "Assign";
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
