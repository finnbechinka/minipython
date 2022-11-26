package nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;
import visitors.ASTVisitor;

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

    public List<ASTNode> getStmts() {
        return stmts;
    }

    public void setStmts(List<ASTNode> stmts) {
        this.stmts = stmts;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}