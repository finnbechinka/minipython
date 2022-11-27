package nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

public class CallNode extends ASTNode {

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

    @Override
    public String toStringTree() {
        return "FuncCall: " + id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ASTNode> getArgs() {
        return args;
    }

    public void setArgs(List<ASTNode> args) {
        this.args = args;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
