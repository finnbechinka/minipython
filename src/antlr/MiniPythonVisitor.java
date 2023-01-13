package antlr;
// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniPythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniPythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#lit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(MiniPythonParser.LitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniPythonParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MiniPythonParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EQUI}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQUI(MiniPythonParser.EQUIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADD}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADD(MiniPythonParser.ADDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SUB}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSUB(MiniPythonParser.SUBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LEQUI}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLEQUI(MiniPythonParser.LEQUIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOR(MiniPythonParser.ORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MUL}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMUL(MiniPythonParser.MULContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GREATER}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGREATER(MiniPythonParser.GREATERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UNEQUI}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUNEQUI(MiniPythonParser.UNEQUIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GEQUI}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGEQUI(MiniPythonParser.GEQUIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOM}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOM(MiniPythonParser.ATOMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DIV}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDIV(MiniPythonParser.DIVContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCall}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCall(MiniPythonParser.ExprCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOT(MiniPythonParser.NOTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAND(MiniPythonParser.ANDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LESS}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLESS(MiniPythonParser.LESSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link MiniPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitID(MiniPythonParser.IDContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MiniPythonParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(MiniPythonParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(MiniPythonParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MiniPythonParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(MiniPythonParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MiniPythonParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MiniPythonParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#elifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifStmt(MiniPythonParser.ElifStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniPythonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniPythonParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MiniPythonParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#methodDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDef(MiniPythonParser.MethodDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#clazz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClazz(MiniPythonParser.ClazzContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MiniPythonParser.ProgContext ctx);
}