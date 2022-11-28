package nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class ClazzDefNode extends ASTNode{

    private Scope scope;

    private String id;
    private String parentId;

    private List<ASTNode> methods;

    public ClazzDefNode(String id, String parentId, List<ASTNode> methods){
        
        this.id = id;
        this.parentId = parentId;
        this.methods = methods;
    }

    public Tree getChild(int arg0) {
        return methods.get(arg0);
    }

    public int getChildCount() {
        return methods.size();
    }

    public String getId(){
        return this.id;
    }

    public String getParentId(){
        return this.parentId;
    }

    public List<ASTNode> getMethods(){
        return this.methods;
    }

    @Override
    public String toStringTree() {
        return "Class: " + id + " Extends: " + parentId;
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
