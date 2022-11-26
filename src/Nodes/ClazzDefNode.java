package nodes;

import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

import java.util.List;

public class ClazzDefNode extends ASTNode {

    private String id;
    private String parentId;

    private List<ASTNode> methods;

    public ClazzDefNode(String id, String parentId, List<ASTNode> methods) {
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

    @Override
    public String toStringTree() {
        return "Class: " + id + " Extends: " + parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<ASTNode> getMethods() {
        return methods;
    }

    public void setMethods(List<ASTNode> methods) {
        this.methods = methods;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
