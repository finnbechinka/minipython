package Nodes;

import org.antlr.v4.runtime.tree.Tree;

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
    
}
