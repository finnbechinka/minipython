package nodes;
import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

import scopes.Scope;
import visitors.ASTVisitor;

public class IfStmtNode extends ASTNode {

    private Scope scope;

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

    public ASTNode getIfCondition(){
        return this.ifCondition;
    }

    public ASTNode getIfBody(){
        return this.ifBody;
    }

    public List<ASTNode> getElifs(){
        return this.elifs;
    }

    public ASTNode getElseBody(){
        return this.elseBody;
    }

    @Override
    public String toStringTree() {
        return "IF";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Scope getScope() {
        return this.scope;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
