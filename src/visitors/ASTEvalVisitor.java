package visitors;

import environment.*;
import nodes.*;

import java.util.ArrayList;
import java.util.List;

public class ASTEvalVisitor implements ASTVisitor<Object> {

    private Environment env;

    @Override
    public Object visit(AssignNode node) {
        return env.getElements().put(node.getId(), visit(node.getValueNode()));
    }

    @Override
    public Object visit(BinaryExprNode node) {
        Object rightNode = visit(node.getRightNode());
        Object leftNode = visit(node.getLeftNode());

        switch(node.getOperator()) {
            case "+": {
                if(leftNode instanceof Integer && rightNode instanceof Integer)
                    return (int)leftNode + (int)rightNode;
                else if(leftNode instanceof String && rightNode instanceof String) {
                    return leftNode.toString() + rightNode;
                }
                else if(leftNode instanceof String) {
                    return leftNode.toString() + rightNode;
                }
                break;
            }
            case "-": {
                if(leftNode instanceof Integer && rightNode instanceof Integer)
                    return (int)leftNode - (int)rightNode;
                break;
            }
            case "/": {
                if(leftNode instanceof Integer && rightNode instanceof Integer)
                    return (int)leftNode / (int)rightNode;
                break;
            }
            case "*": {
                if(leftNode instanceof Integer && rightNode instanceof Integer)
                    return (int)leftNode * (int)rightNode;
                break;
            }
            case "==": {
                return leftNode.equals(rightNode);
            }
            case "!=": {
                return !leftNode.equals(rightNode);
            }
            case ">=": {
                if(rightNode instanceof Integer && leftNode instanceof Integer)
                    return (int)leftNode >= (int)rightNode;
                break;
            }
            case ">": {
                if(rightNode instanceof Integer && leftNode instanceof Integer)
                    return (int)leftNode > (int)rightNode;
                break;
            }
            case "<=": {
                if(rightNode instanceof Integer && leftNode instanceof Integer)
                    return (int)leftNode <= (int)rightNode;
                break;
            }
            case "<": {
                if(rightNode instanceof Integer && leftNode instanceof Integer)
                    return (int)leftNode < (int)rightNode;
                break;
            }
            case "and": {
                if(rightNode instanceof Boolean && leftNode instanceof Boolean)
                    return (boolean)leftNode && (boolean)rightNode;
                break;
            }
            case "or": {
                if(rightNode instanceof Boolean && leftNode instanceof Boolean)
                    return (boolean)leftNode || (boolean)rightNode;
                break;
            }
            default:
                throw new UnsupportedOperationException();
        }
        return null;
    }

    @Override
    public Object visit(UnaryExprNode node) {
        Object val = visit(node.getChildNode());
        switch(node.getOperator()) {
            case "not": {
                return !(boolean)val;
            }
        }
        return null;
    }

    @Override
    public Object visit(BlockNode node) {
        Environment blockEnv = new Environment(env);
        env = blockEnv;

        for(ASTNode instr: node.getInstructions()) {
            visit(instr);
        }
        env = env.getEnclosingEnvironment();
        return blockEnv;
    }

    @Override
    public Object visit(CallNode node) {
        Object callObj = env.get(node.getId());
        List<Object> args = new ArrayList<>();

        for(ASTNode arg: node.getArgs())
            args.add(visit(arg));

        if(callObj instanceof Callable) {
            try {
                ((Callable) callObj).call(this, args);
            }
            catch(ReturnException e) {
                return e.getVal();
            }
        }
        return null;
    }

    @Override
    public Object visit(ClazzDefNode node) {
        return null;
    }

    @Override
    public Object visit(IfStmtNode node) {
        Object resultObj = visit(node.getIfCondition());
        if(resultObj instanceof Boolean){
            if((Boolean) resultObj){
                env = new Environment(env);
                visit(node.getIfBody());
                env = env.getEnclosingEnvironment();
            }else{
                for(ASTNode elif: node.getElifs()) {
                    resultObj = visit(elif);
                    if(resultObj instanceof Boolean){
                        if((Boolean) resultObj){
                            break;
                        }}
                }
                if(resultObj instanceof Boolean){
                    if(!(Boolean) resultObj){
                        env = new Environment(env);
                        visit(node.getElseBody());
                        env = env.getEnclosingEnvironment();
                    }}
            }
        }

        return null;
    }

    @Override
    public Object visit(ElifStmtNode node) {
        Object resultObj = visit(node.getCondition());
        if(resultObj instanceof Boolean){
            if((Boolean) resultObj){
                env = new Environment(env);
                visit(node.getBody());
                env = env.getEnclosingEnvironment();
            }}

        return resultObj;
    }

    @Override
    public Object visit(WhileStmtNode node) {
        visit(node.getCondition());

        env = new Environment(env);
        visit(node.getBody());
        env = env.getEnclosingEnvironment();

        return null;
    }

    @Override
    public Object visit(FuncDefNode node) {
        Function f = new Function(node.getId(), env, node);
        env.define(f.getName(), f);
        return null;
    }

    @Override
    public Object visit(IDNode node) {
        return env.get(node.getId());
    }

    @Override
    public Object visit(LitNode<?> node) {
        return node.getValue();
    }

    @Override
    public Object visit(MemberCallNode node) {
        return null;
    }

    @Override
    public Object visit(ProgNode node) {
        this.env = new Environment(null);
        this.env.define("print", new Print(this.env));
        this.env.define("input", new Input(this.env));

        for(ASTNode stmt: node.getStmts())
            visit(stmt);
        return null;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }
}
