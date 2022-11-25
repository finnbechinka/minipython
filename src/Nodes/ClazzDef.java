package Nodes;

import java.util.List;

import org.antlr.v4.runtime.tree.Tree;

public class ClazzDef extends ASTNode{

    private String id;
    private String parentId;

    private List<ASTNode> methods;

    public ClazzDef(String id, String parentId, List<ASTNode> methods){
        
        this.id = id;
        this.parentId = parentId;
        this.methods = methods;
    }

    public Tree getChild(int arg0) {
        return methods.get(arg0);
    }

    public int getChildCount() {
        return methods.size();
    }

    @Override
    public String toStringTree() {
        return "Class: " + id + " Extends: " + parentId;
    }
    
}
