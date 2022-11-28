package environment;

public class ReturnException extends RuntimeException {

    private Object val;

    public ReturnException(Object val) {
        super("RETURN");
        this.val = val;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }
}
