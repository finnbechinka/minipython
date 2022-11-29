package environment.functions;

import environment.Environment;
import environment.Function;
import visitors.ASTEvalVisitor;

import java.util.List;

public class Print extends Function {

    public Print(Environment env) {
        super("print", env, null);
    }

    @Override
    public void call(ASTEvalVisitor interpreter, List<Object> args) {
        for (Object arg : args) {
            System.out.print(arg instanceof Boolean ? ((boolean) arg ? "True": "False") : arg);
        }
        System.out.print("\n");
    }
}
