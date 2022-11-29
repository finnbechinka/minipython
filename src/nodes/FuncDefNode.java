package nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class FuncDefNode extends ASTNode{

    private Scope scope;

    private String id;
    private List<String> parameters;
    private ASTNode body;
    private ASTNode returnExpr;

    public FuncDefNode(String id, List<String> parameters, ASTNode body, ASTNode returnExpr){
        this.id = id;
        this. parameters = parameters;
        this.body = body;
        this.returnExpr = returnExpr;
    }

    public Tree getChild(int arg0) {
        return arg0 == 0 ? body : returnExpr;
    }

    public int getChildCount() {
        return returnExpr == null ? 1 : 2;
    }

    public String getId(){
        return this.id;
    }

    public List<String> getParameters(){
        return this.parameters;
    }

    public ASTNode getBody(){
        return this.body;
    }

    public ASTNode getReturnExpr(){
        return this.returnExpr;
    }

    @Override
    public String toStringTree() {
        return "FuncDef: " + id + " " + parameters.toString();
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
