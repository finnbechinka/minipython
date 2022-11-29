package visitors;

import environment.*;
import environment.functions.Input;
import environment.functions.Print;
import nodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASTEvalVisitor implements ASTVisitor<Object> {

    private Environment env;

    @Override
    public Object visit(AssignNode node) {
        Object value = visit(node.getValueNode());

        if(((IDNode)node.getId()).getInstanceId() != null) {
            env.getEnclosingEnvironment().define(((IDNode) node.getId()).getId(), value);
        }
        else if (env.assign(((IDNode) node.getId()).getId(), value) == null) {
            env.define(((IDNode) node.getId()).getId(), value);
        }
        return null;
    }

    @Override
    public Object visit(BinaryExprNode node) {
        Object rightNode = visit(node.getRightNode());
        Object leftNode = visit(node.getLeftNode());

        switch (node.getOperator()) {
            case "+" -> {
                if (leftNode instanceof Integer && rightNode instanceof Integer)
                    return (int) leftNode + (int) rightNode;
                else if (leftNode instanceof String && rightNode instanceof String) {
                    return leftNode.toString() + rightNode;
                } else if (leftNode instanceof String) {
                    return leftNode.toString() + rightNode;
                }
            }
            case "-" -> {
                if (leftNode instanceof Integer && rightNode instanceof Integer)
                    return (int) leftNode - (int) rightNode;
            }
            case "/" -> {
                if (leftNode instanceof Integer && rightNode instanceof Integer)
                    return (int) leftNode / (int) rightNode;
            }
            case "*" -> {
                if (leftNode instanceof Integer && rightNode instanceof Integer)
                    return (int) leftNode * (int) rightNode;
            }
            case "==" -> {
                return leftNode.equals(rightNode);
            }
            case "!=" -> {
                return !leftNode.equals(rightNode);
            }
            case ">=" -> {
                if (rightNode instanceof Integer && leftNode instanceof Integer)
                    return (int) leftNode >= (int) rightNode;
            }
            case ">" -> {
                if (rightNode instanceof Integer && leftNode instanceof Integer)
                    return (int) leftNode > (int) rightNode;
            }
            case "<=" -> {
                if (rightNode instanceof Integer && leftNode instanceof Integer)
                    return (int) leftNode <= (int) rightNode;
            }
            case "<" -> {
                if (rightNode instanceof Integer && leftNode instanceof Integer)
                    return (int) leftNode < (int) rightNode;
            }
            case "and" -> {
                if (rightNode instanceof Boolean && leftNode instanceof Boolean)
                    return (boolean) leftNode && (boolean) rightNode;
            }
            case "or" -> {
                if (rightNode instanceof Boolean && leftNode instanceof Boolean)
                    return (boolean) leftNode || (boolean) rightNode;
            }
            default -> throw new UnsupportedOperationException();
        }
        return null;
    }

    @Override
    public Object visit(UnaryExprNode node) {
        Object val = visit(node.getChildNode());
        if ("not".equals(node.getOperator())) {
            return !(boolean) val;
        }
        return null;
    }

    @Override
    public Object visit(BlockNode node) {
        Environment blockEnv = new Environment(env);
        env = blockEnv;

        for (ASTNode instr : node.getInstructions()) {
            visit(instr);
        }
        env = env.getEnclosingEnvironment();
        return blockEnv;
    }

    @Override
    public Object visit(CallNode node) {
        List<Object> args = new ArrayList<>();
        Callable callObj = null;

        if (((IDNode) node.getId()).getInstanceId() != null) {
            Object instance = env.get(((IDNode) node.getId()).getInstanceId());

            if (instance instanceof Clazz.Instance) {
                callObj = ((Clazz.Instance) instance).getFunction(((IDNode) node.getId()).getId());
                args.add(instance);
            }
        }
        if (callObj == null) callObj = (Callable) env.get(((IDNode) node.getId()).getId());


        for (ASTNode arg : node.getArgs())
            args.add(visit(arg));
        try {
            callObj.call(this, args);
        } catch (Return ret) {
            return ret.getVal();
        }
        return null;
    }

    @Override
    public Object visit(ClazzDefNode node) {
        Map<String, Function> methods = new HashMap<>();

        for (ASTNode method : node.getMethods()) {
            Function f = new Function(((FuncDefNode) method).getId(), env, (FuncDefNode) method);
            methods.put(f.getName(), f);
        }

        Clazz parent = null;
        if(node.getParentId() != null) {
            parent = (Clazz) env.get(node.getParentId());
        }
        Clazz clazz = new Clazz(node.getId(), parent, env, methods);
        env.define(clazz.getName(), clazz);
        return null;
    }

    @Override
    public Object visit(IfStmtNode node) {
        Object resultObj = visit(node.getIfCondition());
        if (resultObj instanceof Boolean) {
            if ((Boolean) resultObj) {
                env = new Environment(env);
                visit(node.getIfBody());
                env = env.getEnclosingEnvironment();
            } else {
                for (ASTNode elif : node.getElifs()) {
                    resultObj = visit(elif);
                    if (resultObj instanceof Boolean) {
                        if ((Boolean) resultObj) {
                            break;
                        }
                    }
                }
                if (resultObj instanceof Boolean) {
                    if (!(Boolean) resultObj) {
                        env = new Environment(env);
                        visit(node.getElseBody());
                        env = env.getEnclosingEnvironment();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Object visit(ElifStmtNode node) {
        Object resultObj = visit(node.getCondition());
        if (resultObj instanceof Boolean) {
            if ((Boolean) resultObj) {
                env = new Environment(env);
                visit(node.getBody());
                env = env.getEnclosingEnvironment();
            }
        }

        return resultObj;
    }

    @Override
    public Object visit(WhileStmtNode node) {
        while ((boolean) visit(node.getCondition())) {
            env = new Environment(env);
            visit(node.getBody());
            env = env.getEnclosingEnvironment();
        }
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
    public Object visit(ProgNode node) {
        this.env = new Environment(null);
        this.env.define("print", new Print(this.env));
        this.env.define("input", new Input(this.env));

        for (ASTNode stmt : node.getStmts())
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
