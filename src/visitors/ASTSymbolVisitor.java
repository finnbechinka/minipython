package visitors;

import java.net.IDN;

import nodes.*;
import scopes.Builtin;
import scopes.Clazz;
import scopes.Function;
import scopes.Scope;
import scopes.Symbol;
import scopes.Variable;
import java.util.List;

public class ASTSymbolVisitor implements ASTVisitor<Object> {

  private Scope scope;

  @Override
  public Object visit(AssignNode node) {
    IDNode idnode = (IDNode) node.getId();
    Object obj = visit(node.getValueNode());

    if (idnode.getInstanceId() != null) {

      Symbol sym = scope.resolve(((IDNode) node.getId()).getInstanceId());

      if (sym == null) {
        System.out.println("Instance doesnt exist!");
        return null;
      }
      Clazz instance = (Clazz) sym.getType();
      instance.bind(new Variable(idnode.getId(), null));

    } else {
      if (idnode.getType() != "" && !idnode.getType().equals(obj instanceof Clazz ? ((Clazz) obj).getName() : obj))
        PANIC(String.format("The type %s does not match with %s", idnode.getType(),
            obj instanceof Clazz ? ((Clazz) obj).getName() : obj));
    }
    scope.bind(new Variable(idnode.getId(), obj instanceof Clazz ? (Clazz) obj : null));
    node.setScope(scope);
    return null;
  }

  @Override
  public Object visit(BinaryExprNode node) {
    node.setScope(scope);
    visit(node.getLeftNode());
    visit(node.getRightNode());

    return null;
  }

  @Override
  public Object visit(UnaryExprNode node) {
    node.setScope(scope);
    visit(node.getChildNode());

    return null;
  }

  @Override
  public Object visit(BlockNode node) {
    scope = new Scope(scope);

    for (ASTNode inst : node.getInstructions())
      visit(inst);

    node.setScope(scope);
    scope = scope.getScope();

    return null;
  }

  @Override
  public Object visit(CallNode node) {
    node.setScope(scope);

    Symbol symbol = null;

    if (((IDNode) node.getId()).getInstanceId() != null) {
      symbol = scope.resolve(((IDNode) node.getId()).getInstanceId());
      if (symbol == null)
        return PANIC(((IDNode) node.getId()).getInstanceId());

      Clazz instance = (Clazz) ((Variable) symbol).getType();
      if (instance == null)
        return PANIC("1");

      symbol = instance.resolveMember(((IDNode) node.getId()).getId());
      if (symbol == null)
        return PANIC("2");
    } else {
      symbol = scope.resolve(((IDNode) node.getId()).getId());

      if (symbol == null)
        return PANIC("3");
    }

    for (ASTNode arg : node.getArgs())
      visit(arg);

    if (symbol instanceof Clazz)
      return symbol;
    else if (symbol instanceof Function)
      return ((Function) symbol).getRetType();
    else
      return null;
  }

  @Override
  public Object visit(ClazzDefNode node) {
    Clazz parent = null;

    if (node.getParentId() != null)
      parent = (Clazz) scope.resolve(node.getParentId());

    Clazz c = new Clazz(node.getId(), parent, null, scope);
    scope.bind(c);
    node.setScope(c);

    scope = c;
    scope.bind(new Function("super", null, scope, node.getParentId()));

    for (ASTNode method : node.getMethods())
      visit(method);

    scope = scope.getScope();

    return null;
  }

  @Override
  public Object visit(IfStmtNode node) {
    node.setScope(scope);

    visit(node.getIfCondition());
    visit(node.getIfBody());

    for (ASTNode elif : node.getElifs())
      visit(elif);

    visit(node.getElseBody());

    return null;
  }

  @Override
  public Object visit(ElifStmtNode node) {
    node.setScope(scope);

    visit(node.getCondition());
    visit(node.getBody());

    return null;
  }

  @Override
  public Object visit(WhileStmtNode node) {
    node.setScope(scope);

    visit(node.getCondition());
    visit(node.getBody());

    return null;
  }

  @Override
  public Object visit(FuncDefNode node) {
    Function fun = new Function(node.getId(), null, scope, node.getReturnType());
    scope.bind(fun);
    scope = fun;
    node.setScope(fun);

    List<String> params = node.getParameters();

    for (int i = 0; i < params.size(); i++) {
      if (params.get(i).equals("self")) {
        scope.bind(new Variable(params.get(i), (Clazz) scope.getScope()));
      } else {
        if (!node.getParameterTypes().get(i).equals("")) {
          Symbol type = scope.resolve(node.getParameterTypes().get(i));
          if (type == null)
            System.out.printf("Type doesnt exist!");
        }
        scope.bind(new Variable(params.get(i), null));
      }
    }
    if (fun.getRetType() != "" && scope.resolve(fun.getRetType()) == null) {
      System.out.println("PANIC: RET TYPE DOES NOT EXIST " + fun.getRetType());
    }

    visit(node.getBody());

    if (node.getReturnExpr() != null) {
      scope = node.getBody().getScope();
      visit(node.getReturnExpr());
      scope = scope.getScope();
    }
    scope = scope.getScope();

    return null;
  }

  @Override
  public Object visit(IDNode node) {
    Symbol sym = scope.resolve(node.getId());

    if (node.getInstanceId() == null && !(sym instanceof Variable)) {
      System.out.println("NOT A VAR:" + node.getId());
    }

    node.setScope(scope);

    return node.getType();
  }

  @Override
  public Object visit(LitNode<?> node) {
    switch (node.getValue().getClass().getSimpleName()) {
      case "String":
        return "str";
      case "Integer":
        return "num";
      case "Boolean":
        return "bool";
      default:
        return null;
    }
  }

  @Override
  public Object visit(ProgNode node) {
    scope = new Scope(null);
    node.setScope(scope);
    scope.bind(new Builtin("print", null));
    scope.bind(new Builtin("input", null));
    scope.bind(new Builtin("str", null));
    scope.bind(new Builtin("num", null));
    scope.bind(new Builtin("bool", null));

    for (ASTNode stmt : node.getStmts()) {
      visit(stmt);
    }
    return null;
  }

  private Object PANIC(String msg) {
    System.err.println("PANIC: " + msg);
    return null;
  }
}
