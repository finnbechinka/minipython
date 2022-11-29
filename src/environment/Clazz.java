package environment;

import nodes.ASTNode;
import nodes.AssignNode;
import nodes.BlockNode;
import nodes.IDNode;
import visitors.ASTEvalVisitor;

import java.util.List;
import java.util.Map;

public class Clazz extends Callable {

    private String name;
    private Clazz parent;
    private Environment env;

    private final Map<String, Function> functions;

    public Clazz(String name, Clazz parent, Environment env, Map<String, Function> functions) {
        this.name = name;
        this.parent = parent;
        this.env = env;
        this.functions = functions;
    }

    public Function findFunction(String id) {
        if(functions.get(id) != null) return functions.get(id);
        else if(parent != null) return parent.findFunction(id);
        else return null;
    }

    @Override
    public void call(ASTEvalVisitor state, List<Object> args) {
        Instance i = new Instance(this);

        Function init = findFunction("init");
        if(init != null) {
            for(ASTNode node : ((BlockNode)init.getDef().getBody()).getInstructions()) {
                if(node instanceof AssignNode) {
                    String id = ((IDNode)((AssignNode) node).getId()).getId();
                    Object ob = state.visit(((AssignNode) node).getValueNode());
                    this.env.define(id, ob);
                }
                else {
                    state.visit(node);
                }
            }
        }

        throw new Return(i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

    public Clazz getParent() {
        return parent;
    }

    public void setParent(Clazz parent) {
        this.parent = parent;
    }

    public Map<String, Function> getFunctions() {
        return functions;
    }

    public class Instance {
        private final Clazz clazz;

        public Instance(Clazz clazz) {
            this.clazz = clazz;
        }

        public Function getFunction(String name) {
            Function func = this.clazz.findFunction(name);

            if (func != null) return func.bind(this);
            else
                throw new RuntimeException("PANIC");
        }

        public String toString() {
            return this.clazz.getName();
        }

        public Clazz getClazz() {
            return clazz;
        }
    }
}
