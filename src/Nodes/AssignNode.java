package nodes;

import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

public class AssignNode extends InstructionNode {

    private String id;
    private ASTNode valueNode;

    public AssignNode(String id, ASTNode valueNode) {
        this.id = id;
        this.valueNode = valueNode;
    }

    public Tree getChild(int arg0) {
        return valueNode;
    }

    public int getChildCount() {
        return 1;
    }

    @Override
    public String toStringTree() {
        return "Assign: " + id;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ASTNode getValueNode() {
        return valueNode;
    }

    public void setValueNode(ASTNode valueNode) {
        this.valueNode = valueNode;
    }
}
