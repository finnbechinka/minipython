package environment;

import nodes.FuncDefNode;
import visitors.ASTEvalVisitor;

import java.util.List;

public class Function extends Callable {

    private String name;
    private Environment env;
    private FuncDefNode def;

    public Function(String name, Environment env, FuncDefNode def) {
        this.env = env;
        this.name = name;
        this.def = def;
    }

    @Override
    public void call(ASTEvalVisitor interpreter, List<Object> args) {
        Environment prev = interpreter.getEnv();

        interpreter.setEnv(new Environment(prev));
        for (int x = 0; x < args.size(); x++) {
            interpreter.getEnv().define(def.getParameters().get(x), args.get(x));
        }
        Environment retEnv = (Environment) interpreter.visit(def.getBody());

        interpreter.setEnv(retEnv);
        Object retVal = interpreter.visit(def.getReturnExpr());
        interpreter.setEnv(prev);

        throw new Return(retVal);
    }

    public Function bind(Clazz.Instance i) {
        Environment env = this.getEnv();

        env.define("self", i);
        return new Function(def.getId(), env, def);
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

    public FuncDefNode getDef() {
        return def;
    }

    public void setDef(FuncDefNode def) {
        this.def = def;
    }
}
