package visitors;
import nodes.*;

public interface ASTVisitor<T> {
    
    T visit(AssignNode node);
    T visit(BinaryExprNode node);
    T visit(UnaryExprNode node);
    T visit(BlockNode node);
    T visit(CallNode node);
    T visit(ClazzDefNode node);
    T visit(IfStmtNode node);
    T visit(ElifStmtNode node);
    T visit(WhileStmtNode node);
    T visit(FuncDefNode node);
    T visit(IDNode node);
    T visit(LitNode<?> node);
    T visit(ProgNode node);

    default T visit(ASTNode node){
        
        if      (node instanceof AssignNode)       return visit((AssignNode) node);
        else if (node instanceof BinaryExprNode)   return visit((BinaryExprNode) node);
        else if (node instanceof UnaryExprNode)    return visit((UnaryExprNode) node);
        else if (node instanceof BlockNode)        return visit((BlockNode) node);
        else if (node instanceof CallNode)         return visit((CallNode) node);
        else if (node instanceof ClazzDefNode)     return visit((ClazzDefNode) node);
        else if (node instanceof IfStmtNode)       return visit((IfStmtNode) node);
        else if (node instanceof ElifStmtNode)     return visit((ElifStmtNode) node);
        else if (node instanceof WhileStmtNode)    return visit((WhileStmtNode) node);
        else if (node instanceof FuncDefNode)      return visit((FuncDefNode) node);
        else if (node instanceof IDNode)           return visit((IDNode) node);
        else if (node instanceof LitNode<?>)       return visit((LitNode<?>) node);
        else if (node instanceof ProgNode)         return visit((ProgNode) node);
        else return null;
    }
}
