package nodes;
import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class AssignNode extends InstructionNode{

    private Scope scope;

    private String id;
    private ASTNode valueNode;

    public AssignNode(String id, ASTNode valueNode){

        this.id = id;
        this.valueNode = valueNode;
    }

    public Tree getChild(int arg0) {
        return valueNode;
    }

    public int getChildCount() {
        return 1;
    }

    public String getId(){
        return this.id;
    }

    public ASTNode getValueNode(){
        return this.valueNode;
    }

    @Override
    public String toStringTree() {
        return "Assign: " + id;
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
