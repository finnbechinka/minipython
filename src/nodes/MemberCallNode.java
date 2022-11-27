package nodes;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

public class MemberCallNode extends ASTNode {

    private String instanceID;
    private String methodID;

    private List<ASTNode> args;

    public MemberCallNode(String instanceID, String methodID, List<ASTNode> args){
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

    public String getInstanceID() {
        return instanceID;
    }

    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    public String getMethodID() {
        return methodID;
    }

    public void setMethodID(String methodID) {
        this.methodID = methodID;
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
