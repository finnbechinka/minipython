package visitors;

import nodes.ASTNode;
import nodes.AssignNode;
import nodes.BinaryExprNode;
import nodes.BlockNode;
import nodes.CallNode;
import nodes.ClazzDefNode;
import nodes.ElifStmtNode;
import nodes.FuncDefNode;
import nodes.IDNode;
import nodes.IfStmtNode;
import nodes.LitNode;
import nodes.MemberCallNode;
import nodes.ProgNode;
import nodes.UnaryExprNode;
import nodes.WhileStmtNode;

public class ASTStringVisitor implements ASTVisitor<String>{

    @Override
    public String visit(AssignNode node) {
        return "";
    }

    @Override
    public String visit(BinaryExprNode node) {
        return "";
    }

    @Override
    public String visit(UnaryExprNode node) {
        
        return "";
    }

    @Override
    public String visit(BlockNode node) {
        String s = "\n";

        s += node.toStringTree() +": "+ node.getScope();
        
        for(ASTNode inst : node.getInstructions()) s += visit(inst);

        return s;
    }

    @Override
    public String visit(CallNode node) {
        
        return "";
    }

    @Override
    public String visit(ClazzDefNode node) {
        
        return "";
    }

    @Override
    public String visit(IfStmtNode node) {
        String s = "\n";

        s += node.toStringTree() +": "+ node.getScope();
        s += visit(node.getIfBody());

        for(ASTNode elif : node.getElifs()) s += visit(elif);

        s +=visit(node.getElseBody());

        return s;
    }

    @Override
    public String visit(ElifStmtNode node) {
        String s = "\n";

        s += node.toStringTree() +": "+ node.getScope();
        s += visit(node.getBody());

        return s;
    }

    @Override
    public String visit(WhileStmtNode node) {
        String s = "\n";

        s += node.toStringTree() +": "+ node.getScope();
        s += visit(node.getCondition());
        s +=visit(node.getBody());

        return s;
    }

    @Override
    public String visit(FuncDefNode node) {
        String s = "\n";

        s += node.toStringTree() +": "+ node.getScope();

        s+=visit(node.getBody());

        return s;
    }

    @Override
    public String visit(IDNode node) {
        
        return "";
    }

    @Override
    public String visit(LitNode<?> node) {
        
        return "";
    }

    @Override
    public String visit(MemberCallNode node) {
        
        return "";
    }

    @Override
    public String visit(ProgNode node) {
        String s = node.toStringTree() + ": " + node.getStmts().get(0).getScope().toString();
        for(ASTNode stmt : node.getStmts()) s += visit(stmt);

        return s;
    }
    
}
