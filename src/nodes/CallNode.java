package nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class CallNode extends ASTNode {

    private Scope scope;

    private String id;
    private List<ASTNode> args;

    public CallNode(String id, List<ASTNode> args){
        this.id = id;
        this.args = args;
    }

    public Tree getChild(int arg0) {
        return args.get(arg0);
    }

    public int getChildCount() {
        return args.size();
    }

    public String getId(){
        return this.id;
    }

    public List<ASTNode> getArgs(){
        return this.args;
    }

    @Override
    public String toStringTree() {
        return "FuncCall: " + id;
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
