package scopes;

public interface Symbol {

    public void setName(String name);

    public void setType(Type type);

    public void setScope(Scope scope);

    public String getName();

    public Type getType();

    public Scope getScope();
}
