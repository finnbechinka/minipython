package environment;

import visitors.ASTEvalVisitor;

import java.util.List;

public abstract class Callable {

    public abstract void call(ASTEvalVisitor state, List<Object> args);

    public abstract void ret(Object val);
}
