package Nodes;
import org.antlr.v4.runtime.tree.Tree;

public class AssignNode extends InstructionNode{

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

    @Override
    public String toStringTree() {
        return "Assign: " + id;
    }
    
}
