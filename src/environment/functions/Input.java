package environment.functions;

import environment.Environment;
import environment.Function;
import environment.Return;
import visitors.ASTEvalVisitor;

import java.util.List;
import java.util.Scanner;

public class Input extends Function {

    public Input(Environment env) {
        super("input", env, null);
    }

    @Override
    public void call(ASTEvalVisitor interpreter, List<Object> args) {
        System.out.println(args.get(0));
        Scanner s = new Scanner(System.in);
        String result = s.nextLine();
        s.close();

        throw new Return(result);
    }
}
