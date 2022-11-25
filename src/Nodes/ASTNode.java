package Nodes;
import org.antlr.v4.runtime.tree.Tree;

public abstract class ASTNode implements Tree {

    public Tree getChild(int arg0) {
        return null;
    }

    public int getChildCount() {
        return 0;
    }

    @Override
    public Tree getParent() {
        return null;
    }

    @Override
    public Object getPayload() {
        return this;
    }

    @Override
    public abstract String toStringTree();

    @Override
    public String toString(){
        return toStringTree();
    }

    
}
