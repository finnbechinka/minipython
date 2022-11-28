package environment;

import visitors.ASTEvalVisitor;

import java.util.List;

public class Clazz extends Callable {

    private String name;
    private Environment env;

    public Clazz(String name, Environment env) {
        this.name = name;
        this.env = env;
    }

    @Override
    public void call(ASTEvalVisitor state, List<Object> args) {

    }

    @Override
    public void ret(Object val) {

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
}
