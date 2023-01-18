package scopes;

public class Function extends Scope implements Symbol {

  private String name;
  private Type type;
  private String retType;

  public Function(String name, Type type, Scope scope, String retType) {
    super(scope);
    this.name = name;
    this.type = type;
    this.retType = retType;
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

  public String getRetType() {
    return this.retType;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + ": " + super.toString();
  }
}
