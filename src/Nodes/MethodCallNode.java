package Nodes;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

public class MethodCallNode extends ASTNode {

    private String instanceID;
    private String methodID;

    private List<ASTNode> args;

    public MethodCallNode(String instanceID, String methodID, List<ASTNode> args){
        this.instanceID = instanceID;
        this.methodID = methodID;
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
        return "MethodCall: " + instanceID + "." + methodID;
    }
    
}
