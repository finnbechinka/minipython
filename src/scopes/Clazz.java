package scopes;

public class Clazz extends Scope implements Symbol, Type {
    
    private String name;
    private Clazz parent;
    private Type type;

    public Clazz(String name, Clazz parent, Type type, Scope scope) {
       super(scope);
       this.name = name;
       this.parent = parent;
       this.type = type;
    }

    public Symbol resolveMember(String name){

        if(symbols.get(name) != null) return symbols.get(name);
        
        try{
            return parent.resolveMember(name);
        }
        catch(Exception e){
           return null; 
        }
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
