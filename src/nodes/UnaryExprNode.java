package nodes;
import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class UnaryExprNode extends ExprNode{

    private Scope scope;

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

    public ASTNode getChildNode(){
        return this.childNode;
    }

    public String getOperator(){
        return this.operator;
    }

    @Override
    public String toStringTree() {
        return "Op: " + operator;
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
