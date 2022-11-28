package visitors;
import nodes.*;
import scopes.Function;
import scopes.Scope;
import scopes.Symbol;
import scopes.Variable;

public class ASTSymbolVisitor implements ASTVisitor<Object> {

    private Scope scope;

    @Override
    public Object visit(AssignNode node) {

        scope.bind(new Variable(node.getId(), null));
        visit(node.getValueNode());
        node.setScope(scope);

        return null;
    }

    @Override
    public Object visit(BinaryExprNode node) {

        node.setScope(scope);
        visit(node.getLeftNode());
        visit(node.getRightNode());

        return null;
    }

    @Override
    public Object visit(UnaryExprNode node) {

        node.setScope(scope);
        visit(node.getChildNode());

        return null;
    }

    @Override
    public Object visit(BlockNode node) {

        scope = new Scope(scope);

        for(ASTNode inst : node.getInstructions()) visit(inst);

        node.setScope(scope);

        scope = scope.getScope();

        return null;
    }

    @Override
    public Object visit(CallNode node) {

        node.setScope(scope);

        Symbol sym = scope.resolve(node.getId());

        if(sym instanceof Variable) {
            System.out.println("NOT A FUNC OR CLASS");
            return null;
        }
        //TODO: Exceptionhandling

        for(ASTNode arg : node.getArgs()) visit(arg);

        return null;
    }

    @Override
    public Object visit(ClazzDefNode node) {
        return null;
    }

    @Override
    public Object visit(IfStmtNode node) {

        node.setScope(scope);

        visit(node.getIfCondition());
        visit(node.getIfBody());

        for(ASTNode elif : node.getElifs()) visit(elif);

        visit(node.getElseBody());

        return null;
    }

    @Override
    public Object visit(ElifStmtNode node) {

        node.setScope(scope);

        visit(node.getCondition());
        visit(node.getBody());

        return null;
    }

    @Override
    public Object visit(WhileStmtNode node) {

        node.setScope(scope);

        visit(node.getCondition());
        visit(node.getBody());

        return null;
    }

    @Override
    public Object visit(FuncDefNode node) {

        Function fun = new Function(node.getId(), null, scope);
        scope.bind(fun);
        scope = fun;
        node.setScope(fun);

        for(String param : node.getParameters()) scope.bind(new Variable(param, null));

        visit(node.getBody());
        // TODO: returnExpr

        scope = scope.getScope();

        return null;
    }

    @Override
    public Object visit(IDNode node) {

        Symbol sym = scope.resolve(node.getId());
        if(!(sym instanceof Variable)) System.out.println("NOT A VAR: "+node.getId());

        node.setScope(scope);

        return null;
    }

    @Override
    public Object visit(LitNode<?> node) {
        return null;
    }

    @Override
    public Object visit(MemberCallNode node) {
        return null;
    }

    @Override
    public Object visit(ProgNode node) {

        scope = new Scope(null);
        node.setScope(null);

        for(ASTNode stmt : node.getStmts()) visit(stmt);

        return null;
    }

}
