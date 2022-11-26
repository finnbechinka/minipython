package visitors;

import nodes.*;
import scopes.*;

public class ASTSymbolVisitor implements ASTVisitor<Object> {

    private Scope scope;

    @Override
    public Object visit(AssignNode node) {
        scope.bind(new Variable(node.getId(), null, scope));
        visit(node.getValueNode());
        return null;
    }

    @Override
    public Object visit(BinaryExprNode node) {
        visit(node.getLeftNode());
        visit(node.getRightNode());
        return null;
    }

    @Override
    public Object visit(UnaryExprNode node) {
        return null;
    }

    @Override
    public Object visit(BlockNode node) {
        scope = new Scope(scope);
        for(ASTNode instr: node.getInstructions()) visit(instr);
        scope = scope.getEnclosingScope();
        return null;
    }

    @Override
    public Object visit(CallNode node) {
        return null;
    }

    @Override
    public Object visit(ClazzDefNode node) {
        Clazz c = new Clazz(node.getId(), null, scope);
        scope.bind(c);
        scope = c;

        for(ASTNode method: node.getMethods()) visit(method);
        scope = scope.getEnclosingScope();
        return null;
    }

    @Override
    public Object visit(IfStmtNode node) {
        visit(node.getIfCondition());
        visit(node.getIfBody());

        for(ASTNode elif: node.getElifs()) {
            visit(elif);
        }
        visit(node.getElseBody());
        return null;
    }

    @Override
    public Object visit(ElifStmtNode node) {
        visit(node.getCondition());
        visit(node.getBody());
        return null;
    }

    @Override
    public Object visit(WhileStmtNode node) {
        visit(node.getCondition());
        visit(node.getBody());
        return null;
    }

    @Override
    public Object visit(FuncDefNode node) {
        Function func = new Function(node.getId(), null, scope);
        scope.bind(func);
        scope = func;

        for(String param: node.getParameters()) {
            scope.bind(new Variable(param, null, scope));
        }
        visit(node.getBody());
        //visit(node.getReturnExpr()); TODO: tbd

        scope = scope.getEnclosingScope();
        return null;
    }

    @Override
    public Object visit(IDNode node) {
        if(scope.resolve(node.getId()) == null) System.out.println("PANIC");
        return null;
    }

    @Override
    public Object visit(LitNode<?> node) {
        return null;
    }

    @Override
    public Object visit(MemberCallNode node) {
        for(ASTNode arg: node.getArgs()) {
            visit(arg);
        }
        return null;
    }

    @Override
    public Object visit(ProgNode node) {
        scope = new Scope(null);

        for(ASTNode child: node.getStmts()) {
            visit(child);
        }
        System.out.println(scope);
        return null;
    }
}
