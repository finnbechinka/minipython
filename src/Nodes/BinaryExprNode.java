package Nodes;
import org.antlr.v4.runtime.tree.Tree;

public class BinaryExprNode extends ExprNode {

    private ASTNode leftNode;
    private ASTNode rightNode;
    private String  operator;

    public BinaryExprNode(ASTNode leftNode, ASTNode rightNode, String operator){

        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.operator = operator;
    }

    public Tree getChild(int arg0) {
        return arg0 == 0 ? leftNode : rightNode;
    }

    public int getChildCount() {
        return 2;
    }

    @Override
    public String toStringTree() {
        return "Op: " + operator;
    }
}
