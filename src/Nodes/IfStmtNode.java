package Nodes;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

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
    
}
