package environment;

import visitors.ASTEvalVisitor;

import java.util.List;
import java.util.Map;

public class Clazz extends Callable {

    private String name;
    private Environment env;
    private final Map<String, Function> methods;

    public Clazz(String name, Environment env, Map<String, Function> methods) {
        this.name = name;
        this.env = env;
        this.methods = methods;
    }

    public Function findMethod(String id) {
        return methods.get(id);
    }

    @Override
    public void call(ASTEvalVisitor state, List<Object> args) {
        throw new Return(new Instance(this));
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

    public class Instance {
        private final Clazz clazz;

        public Instance(Clazz clazz) {
            this.clazz = clazz;
        }

        public Function get(String name) {
            Function func = this.clazz.findMethod(name);

            if (func != null) return func.bind(this);
            else throw new RuntimeException("PANIC");
        }

        public String toString() {
            return this.clazz.getName();
        }
    }
}
