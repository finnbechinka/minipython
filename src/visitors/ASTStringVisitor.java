package visitors;

import nodes.*;

public class ASTStringVisitor implements ASTVisitor<String> {

    @Override
    public String visit(AssignNode node) {
        return node.toString() + "\n" + visit(node.getValueNode());
    }

    @Override
    public String visit(BinaryExprNode node) {
        return node.toString() + "\n" + visit(node.getLeftNode()) + "\n" + visit(node.getRightNode());
    }

    @Override
    public String visit(UnaryExprNode node) {
        return node.toString() + "\n" + visit(node.getChildNode());
    }

    @Override
    public String visit(BlockNode node) {
        StringBuilder str = new StringBuilder(node.toString());

        for(ASTNode instr: node.getInstructions()) {
            str.append("\n").append(visit(instr));
        }
        return str.toString();
    }

    @Override
    public String visit(CallNode node) {
        StringBuilder str = new StringBuilder(node.toString());

        for(ASTNode arg: node.getArgs()) {
            str.append("\n").append(visit(arg));
        }
        return str.toString();
    }

    @Override
    public String visit(ClazzDefNode node) {
        StringBuilder str = new StringBuilder(node.toString());

        for(ASTNode method: node.getMethods()) {
            str.append("\n").append(visit(method));
        }
        return str.toString();
    }

    @Override
    public String visit(IfStmtNode node) {
        StringBuilder str = new StringBuilder(node.toString());
        str.append("\n").append(visit(node.getIfCondition()));
        str.append("\n").append(visit(node.getIfBody()));

        for(ASTNode elif: node.getElifs()) {
            str.append("\n").append(visit(elif));
        }
        str.append("\nELSE\n").append(visit(node.getElseBody()));

        return str.toString();
    }

    @Override
    public String visit(ElifStmtNode node) {
        return node.toString() + "\n" + visit(node.getCondition()) + "\n" + visit(node.getBody());
    }

    @Override
    public String visit(WhileStmtNode node) {
        return node.toString() + "\n" + visit(node.getCondition()) + "\n" + visit(node.getBody());
    }

    @Override
    public String visit(FuncDefNode node) {
        return node.toString()
                + "\n" + visit(node.getBody())
                + "\n" + visit(node.getReturnExpr());
    }

    @Override
    public String visit(IDNode node) {
        return node.toString();
    }

    @Override
    public String visit(LitNode<?> node) {
        return node.toString();
    }

    @Override
    public String visit(MemberCallNode node) {
        StringBuilder str = new StringBuilder(node.toString());

        for(ASTNode arg: node.getArgs())
            str.append("\n").append(visit(arg));
        return str.toString();
    }

    @Override
    public String visit(ProgNode node) {
        StringBuilder str = new StringBuilder(node.toString());
        for(ASTNode childNode: node.getStmts()) str.append("\n\t").append(visit(childNode));

        return str.toString();
    }
}
