package Nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

public class ProgNode extends ASTNode {

    private List<ASTNode> stmts;

    public ProgNode(List<ASTNode> stmts){
        this.stmts = stmts;
    }

    public Tree getChild(int arg0) {
        return stmts.get(arg0);
    }

    public int getChildCount() {
        return stmts.size();
    }

    @Override
    public String toStringTree() {
        return "Prog";
    }
    
}