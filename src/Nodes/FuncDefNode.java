package nodes;

import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

import java.util.List;

public class FuncDefNode extends ASTNode {

    private String id;
    private List<String> parameters;
    private ASTNode body;
    private ASTNode returnExpr;

    public FuncDefNode(String id, List<String> parameters, ASTNode body, ASTNode returnExpr) {
        this.id = id;
        this.parameters = parameters;
        this.body = body;
        this.returnExpr = returnExpr;
    }

    public Tree getChild(int arg0) {
        return arg0 == 0 ? body : returnExpr;
    }

    public int getChildCount() {
        return 2;
    }

    @Override
    public String toStringTree() {
        return "FuncDef: " + id + " " + parameters.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public ASTNode getBody() {
        return body;
    }

    public void setBody(ASTNode body) {
        this.body = body;
    }

    public ASTNode getReturnExpr() {
        return returnExpr;
    }

    public void setReturnExpr(ASTNode returnExpr) {
        this.returnExpr = returnExpr;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
