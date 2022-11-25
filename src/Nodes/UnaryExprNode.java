package Nodes;
import org.antlr.v4.runtime.tree.Tree;

public class UnaryExprNode extends ExprNode{

    private ASTNode childNode;
    private String operator;

    public UnaryExprNode(ASTNode childNode, String operator){
        this.childNode = childNode;
        this.operator = operator;
    }

    public Tree getChild(int arg0) {
        return childNode;
    }

    public int getChildCount() {
        return 1;
    }

    @Override
    public String toStringTree() {
        return "Op: " + operator;
    }
    
}
