package nodes;

import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

public class BinaryExprNode extends ExprNode {

    private ASTNode leftNode;
    private ASTNode rightNode;
    private String operator;

    public BinaryExprNode(ASTNode leftNode, ASTNode rightNode, String operator) {
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

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ASTNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(ASTNode leftNode) {
        this.leftNode = leftNode;
    }

    public ASTNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(ASTNode rightNode) {
        this.rightNode = rightNode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
