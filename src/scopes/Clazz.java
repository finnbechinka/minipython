package scopes;

public class Clazz extends Scope implements Symbol, Type {
    
    private String name;
    private Type type;

    public Clazz(String name, Type type, Scope scope) {
       super(scope);
       this.name = name;
       this.type = type;
    }

    @Override
    public void setName(String name) {
        this.name = name; 
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
