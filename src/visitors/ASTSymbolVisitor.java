package visitors;
import nodes.*;
import scopes.Builtin;
import scopes.Clazz;
import scopes.Function;
import scopes.Scope;
import scopes.Symbol;
import scopes.Variable;

public class ASTSymbolVisitor implements ASTVisitor<Object> {

    private Scope scope;

    @Override
    public Object visit(AssignNode node) {

        if(((IDNode)node.getId()).getInstanceId() != null){

            Symbol sym = scope.resolve(((IDNode)node.getId()).getInstanceId());

            if(sym == null){
                System.out.println("Instance doesnt exist!");
                return null;
            }

            Clazz instance = (Clazz)((Variable) sym).getType();
            instance.bind(new Variable(((IDNode)node.getId()).getId() , null));

        }
        else {
            Object s = visit(node.getValueNode());

            scope.bind(new Variable(((IDNode)node.getId()).getId(), s instanceof Clazz ? (Clazz)s : null));
            node.setScope(scope);
        }


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

        if(((IDNode)node.getId()).getInstanceId() != null){

            Symbol sym = scope.resolve(((IDNode)node.getId()).getInstanceId());

            if(sym == null){
                System.out.println("Instance doesnt exist!");
                return null;
            }

            Clazz instance = (Clazz) ((Variable) sym).getType();
            if(instance == null){
                System.out.println("PANIC");
                return null;
            }
            sym = instance.resolveMember(((IDNode)node.getId()).getId());

            if(sym == null){
                System.out.println("Member doesnt exist!");
                return null;
            }

            for(ASTNode arg : node.getArgs()) visit(arg);
        }
        else{
            Symbol sym = scope.resolve(((IDNode)node.getId()).getId());

            if(sym == null) {
                System.out.println("DOSENT EXIST!");
                return null;
            }
            else if(sym instanceof Variable) {
                System.out.println("NOT A FUNC OR CLASS");
                return null;
            }
            //TODO: Exceptionhandling

            for(ASTNode arg : node.getArgs()) visit(arg);

            if(sym instanceof Clazz) return sym;
        }

        return null;
    }

    @Override
    public Object visit(ClazzDefNode node) {

        Clazz parent = null;

        if(node.getParentId() != null)
            parent = (Clazz) scope.resolve(node.getParentId());

        Clazz c = new Clazz(node.getId(), parent,  null, scope);
        scope.bind(c);
        node.setScope(c);

        scope = c;

        for(ASTNode method : node.getMethods()) visit(method);

        scope = scope.getScope();

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

        for(String param : node.getParameters()){
            if(param.equals("self")) scope.bind(new Variable(param, (Clazz)scope.getScope()));
            else scope.bind(new Variable(param, null));
        }
        visit(node.getBody());

        if(node.getReturnExpr() != null) {
            scope = node.getBody().getScope();
            visit(node.getReturnExpr());
            scope = scope.getScope();
        }
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
    public Object visit(ProgNode node) {

        scope = new Scope(null);
        node.setScope(scope);
        scope.bind(new Builtin("print", null));
        scope.bind(new Builtin("input", null));

        for(ASTNode stmt : node.getStmts()) visit(stmt);

        return null;
    }

}
