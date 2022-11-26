package nodes;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

public class IfStmtNode extends InstructionNode {

    private ASTNode ifCondition;
    private ASTNode ifBody;
    private List<ASTNode> elifs;
    private ASTNode elseBody;

    public IfStmtNode(ASTNode ifCondition, ASTNode ifBody, List<ASTNode> elifs, ASTNode elseBody){
        this.ifCondition = ifCondition;
        this.ifBody = ifBody;
        this.elifs = elifs;
        this.elseBody = elseBody;
    }

    public Tree getChild(int arg0) {
        
        if(arg0 == 0) return ifCondition;
        else if(arg0 == 1) return ifBody;
        else if(arg0 == 2) return elseBody;
        else return elifs.get(arg0-3);
    }

    public int getChildCount() {
        return elifs.size()+3;
    }

    @Override
    public String toStringTree() {
        return "IF";
    }

    public ASTNode getIfCondition() {
        return ifCondition;
    }

    public void setIfCondition(ASTNode ifCondition) {
        this.ifCondition = ifCondition;
    }

    public ASTNode getIfBody() {
        return ifBody;
    }

    public void setIfBody(ASTNode ifBody) {
        this.ifBody = ifBody;
    }

    public List<ASTNode> getElifs() {
        return elifs;
    }

    public void setElifs(List<ASTNode> elifs) {
        this.elifs = elifs;
    }

    public ASTNode getElseBody() {
        return elseBody;
    }

    public void setElseBody(ASTNode elseBody) {
        this.elseBody = elseBody;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
