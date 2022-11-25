package Nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

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
    
}
