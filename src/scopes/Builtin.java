package scopes;

public class Builtin implements Type,Symbol{

    private String name;
    private Type type;
    private Scope scope;

    public Builtin(String name, Type type, Scope scope) {
       this.name = name;
       this.type = type;
       this.scope = scope;
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
    public void setScope(Scope scope) {
        this.scope = scope;
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
    public Scope getScope() {
        return this.scope;
    }
    
}
