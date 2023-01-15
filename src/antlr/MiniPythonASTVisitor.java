package antlr;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.antlr.v4.runtime.tree.ParseTree;

import nodes.*;

public class MiniPythonASTVisitor extends MiniPythonBaseVisitor<ASTNode> {

  @Override
  public ASTNode visitLit(MiniPythonParser.LitContext ctx) {
    if (ctx.BOOL() != null)
      return new LitNode<Boolean>(ctx.BOOL().getText().equals("True") ? true : false);
    else if (ctx.INT() != null)
      return new LitNode<Integer>(Integer.parseInt(ctx.INT().getText()));
    else if (ctx.STRING() != null)
      return new LitNode<String>(ctx.STRING().getText().replace("\"", ""));
    return null;
  }

  @Override
  public ASTNode visitType(MiniPythonParser.TypeContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public ASTNode visitIdentifier(MiniPythonParser.IdentifierContext ctx) {
    if (ctx.children.size() > 2)
      return new IDNode(ctx.children.get(0).getText(), ctx.children.get(2).getText(), null);
    else
      return new IDNode(null, ctx.ID(0).getText(), null);
  }

  @Override
  public ASTNode visitATOM(MiniPythonParser.ATOMContext ctx) {
    return visit(ctx.lit());
  }

  @Override
  public ASTNode visitID(MiniPythonParser.IDContext ctx) {
    return visit(ctx.identifier());
  }

  @Override
  public ASTNode visitEQUI(MiniPythonParser.EQUIContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitADD(MiniPythonParser.ADDContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitSUB(MiniPythonParser.SUBContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitLEQUI(MiniPythonParser.LEQUIContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitOR(MiniPythonParser.ORContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitMUL(MiniPythonParser.MULContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitGREATER(MiniPythonParser.GREATERContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitUNEQUI(MiniPythonParser.UNEQUIContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitGEQUI(MiniPythonParser.GEQUIContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitDIV(MiniPythonParser.DIVContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitNOT(MiniPythonParser.NOTContext ctx) {
    return new UnaryExprNode(visit(ctx.expr()), ctx.op.getText());
  }

  @Override
  public ASTNode visitAND(MiniPythonParser.ANDContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitLESS(MiniPythonParser.LESSContext ctx) {
    return new BinaryExprNode(visit(ctx.expr(0)), visit(ctx.expr(1)), ctx.op.getText());
  }

  @Override
  public ASTNode visitExprCall(MiniPythonParser.ExprCallContext ctx) {
    return visit(ctx.call());
  }

  @Override
  public ASTNode visitAssign(MiniPythonParser.AssignContext ctx) {

    IDNode id = (IDNode) visit(ctx.identifier());
    if (ctx.type() != null) {
      switch (ctx.type().getText()) {
        case "string":
          id.setType("str");
          break;
        case "int":
          id.setType("num");
          break;
        case "bool":
          id.setType("bool");
          break;

        default:
          id.setType("");
          break;
      }
    }
    id.setType(ctx.type() != null ? ctx.type().getText() : "");
    return new AssignNode(id, visit(ctx.getChild(ctx.getChildCount() - 2)));
  }

  @Override
  public ASTNode visitArguments(MiniPythonParser.ArgumentsContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public ASTNode visitCall(MiniPythonParser.CallContext ctx) {
    List<ASTNode> args = new ArrayList<>();

    if (ctx.arguments() != null) {
      for (int i = 0; i < ctx.arguments().expr().size(); i++) {
        args.add(visit(ctx.arguments().expr().get(i)));
      }
    }
    return new CallNode(visit(ctx.identifier()), args);
  }

  @Override
  public ASTNode visitWhileStmt(MiniPythonParser.WhileStmtContext ctx) {
    return new WhileStmtNode(visit(ctx.expr()), visit(ctx.block()));
  }

  @Override
  public ASTNode visitIfStmt(MiniPythonParser.IfStmtContext ctx) {
    ListIterator<MiniPythonParser.ElifStmtContext> it = ctx.elifStmt().listIterator();
    List<ASTNode> elifs = new ArrayList<ASTNode>();

    while (it.hasNext()) {
      ASTNode t = visit(it.next());
      if (t != null)
        elifs.add(t);
    }
    ASTNode elseBody = ctx.block().size() > 1 ? visit(ctx.block(1)) : new BlockNode(new ArrayList<>());

    return new IfStmtNode(visit(ctx.expr()), visit(ctx.block(0)), elifs, elseBody);
  }

  @Override
  public ASTNode visitElifStmt(MiniPythonParser.ElifStmtContext ctx) {
    return new ElifStmtNode(visit(ctx.expr()), visit(ctx.block()));
  }

  @Override
  public ASTNode visitStatement(MiniPythonParser.StatementContext ctx) {
    return visit(ctx.getChild(0));
  }

  @Override
  public ASTNode visitBlock(MiniPythonParser.BlockContext ctx) {
    List<ASTNode> stmts = new ArrayList<ASTNode>();

    if (ctx.children == null)
      return new BlockNode(stmts);

    for (ParseTree stmt : ctx.children) {
      ASTNode t = visit(stmt);
      if (t != null)
        stmts.add(t);
    }

    return new BlockNode(stmts);
  }

  @Override
  public ASTNode visitFuncDef(MiniPythonParser.FuncDefContext ctx) {
    List<String> params = new ArrayList<>();
    List<String> types = new ArrayList<>();

    if (ctx.parameters() != null) {
      for (int i = 0; i < ctx.parameters().ID().size(); i++) {
        params.add(ctx.parameters().ID().get(i).toString());

        switch (ctx.parameters().type(i).getText()) {
          case "string":
            types.add("str");
            break;
          case "int":
            types.add("num");
            break;
          case "bool":
            types.add("bool");
            break;
  
          default:
            types.add("");
            break;
        }
      }
    }

    String retType = ctx.type() != null ? ctx.type().getText() : "";

    switch (retType) {
      case "string":
        retType = "str";
        break;
      case "int":
        retType = "num";
        break;
      case "bool":
        retType = "bool";
        break;

      default:
        retType = "";
        break;
    }

    return new FuncDefNode(ctx.ID().getText(), params, types, visit(ctx.block()), retType,
        ctx.return_() != null ? visit(ctx.return_()) : null);
  }

  @Override
  public ASTNode visitClazz(MiniPythonParser.ClazzContext ctx) {
    List<ASTNode> methods = new ArrayList<>();

    if (ctx.methodDef() != null) {
      for (int i = 0; i < ctx.methodDef().size(); i++) {
        methods.add(visit(ctx.methodDef().get(i)));
      }
    }

    String id = ctx.ID(0).getText();
    String parentId = ctx.ID().size() > 1 ? ctx.ID(1).getText() : null;

    return new ClazzDefNode(id, parentId, methods);
  }

  @Override
  public ASTNode visitMethodDef(MiniPythonParser.MethodDefContext ctx) {
    List<String> params = new ArrayList<>();
    params.add("self");

    List<String> types = new ArrayList<>();
    types.add("");

    if (ctx.parameters() != null) {
      for (int i = 0; i < ctx.parameters().ID().size(); i++) {
        params.add(ctx.parameters().ID().get(i).toString());
        switch (ctx.parameters().type(i).getText()) {
          case "string":
            types.add("str");
            break;
          case "int":
            types.add("num");
            break;
          case "bool":
            types.add("bool");
            break;
  
          default:
            types.add("");
            break;
        }
      }
    }

    String retType = ctx.type() != null ? ctx.type().getText() : "";
    
    switch (retType) {
      case "string":
        retType = "str";
        break;
      case "int":
        retType = "num";
        break;
      case "bool":
        retType = "bool";
        break;

      default:
        retType = "";
        break;
    }

    return new FuncDefNode(ctx.ID().getText(), params, types, visit(ctx.block()), retType,
        ctx.return_() != null ? visit(ctx.return_()) : null);
  }

  @Override
  public ASTNode visitParameters(MiniPythonParser.ParametersContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public ASTNode visitReturn(MiniPythonParser.ReturnContext ctx) {
    return visit(ctx.expr());
  }

  @Override
  public ASTNode visitProg(MiniPythonParser.ProgContext ctx) {
    ListIterator<ParseTree> it = ctx.children.listIterator();
    List<ASTNode> statements = new ArrayList<ASTNode>();

    while (it.hasNext()) {
      ASTNode t = visit(it.next());
      if (t != null)
        statements.add(t);
    }
    return new ProgNode(statements);
  }
}
