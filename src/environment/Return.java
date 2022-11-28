package environment;

public class Return extends RuntimeException {

    private Object val;

    public Return(Object val) {
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
