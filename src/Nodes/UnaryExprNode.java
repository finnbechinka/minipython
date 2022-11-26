package nodes;
import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

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

    public ASTNode getChildNode() {
        return childNode;
    }

    public void setChildNode(ASTNode childNode) {
        this.childNode = childNode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
