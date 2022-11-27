package nodes;

import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

public class WhileStmtNode extends InstructionNode {

    private ASTNode condition;
    private ASTNode body;

    public WhileStmtNode(ASTNode condition, ASTNode body){
        this.condition = condition;
        this.body = body;
    }

    public Tree getChild(int arg0) {
        return arg0 == 0 ? condition : body;
    }

    public int getChildCount() {
        return 2;
    }

    @Override
    public String toStringTree() {
        return "WHILE";
    }

    public ASTNode getCondition() {
        return condition;
    }

    public void setCondition(ASTNode condition) {
        this.condition = condition;
    }

    public ASTNode getBody() {
        return body;
    }

    public void setBody(ASTNode body) {
        this.body = body;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
