package scopes;

public interface Symbol {

    void setName(String name);

    void setType(Type type);

    String getName();

    Type getType();
}
