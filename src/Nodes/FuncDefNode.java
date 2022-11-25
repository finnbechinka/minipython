package Nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

public class FuncDefNode extends ASTNode{

    private String id;
    private List<String> parameters;
    private ASTNode body;
    private ASTNode returnExpr;

    public FuncDefNode(String id, List<String> parameters, ASTNode body, ASTNode returnExpr){
        this.id = id;
        this. parameters = parameters;
        this.body = body;
        this.returnExpr = returnExpr;
    }

    public Tree getChild(int arg0) {
        return arg0 == 0 ? body : returnExpr;
    }

    public int getChildCount() {
        return 2;
    }
    
    @Override
    public String toStringTree() {
        return "FuncDef: " + id + " " + parameters.toString();
    }
    
}
