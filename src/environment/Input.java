package environment;

import visitors.ASTEvalVisitor;

import java.util.List;
import java.util.Scanner;

public class Input extends Function {

    public Input(Environment env) {
        super("input", env, null);
    }

    @Override
    public void call(ASTEvalVisitor interpreter, List<Object> args) {
        Scanner s = new Scanner(System.in);
        System.out.println(args.get(0));

        ret(s.nextLine());
    }
}
