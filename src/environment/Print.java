package environment;

import visitors.ASTEvalVisitor;

import java.util.List;

public class Print extends Function {

    public Print(Environment env) {
        super("print", env, null);
    }

    @Override
    public void call(ASTEvalVisitor interpreter, List<Object> args) {
        for(int i = 0; i < args.size(); i++){
            System.out.print(args.get(i));
        }
        System.out.print("\n");
    }
}
