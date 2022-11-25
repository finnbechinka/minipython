package Nodes;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

public class BlockNode extends ASTNode {

    private List<ASTNode> instructions;
    
    public BlockNode(List<ASTNode> instructions){
        this.instructions = instructions;
    }

    public Tree getChild(int arg0) {
        return instructions.get(arg0);
    }

    public int getChildCount() {
        return instructions.size();
    }

    @Override
    public String toStringTree() {
        return "Block";
    }
    
}
