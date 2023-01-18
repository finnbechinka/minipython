package environment;

public class Variable {

    private String name;
    private Environment env;

    public Variable(String name, Environment env) {
        this.name = name;
        this.env = env;
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
