package nodes;
import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class BinaryExprNode extends ASTNode {

    private Scope scope;

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

    public ASTNode getLeftNode(){
        return this.leftNode;
    }

    public ASTNode getRightNode(){
        return this.rightNode;
    }

    public String getOperator(){
        return this.operator;
    }

    @Override
    public String toStringTree() {
        return "Op: " + operator;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor)  {
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
