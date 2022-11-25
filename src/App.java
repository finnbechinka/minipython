import java.util.Collections;
import Nodes.*;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        MiniPythonLexer lexer = new MiniPythonLexer(CharStreams.fromStream(System.in));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);

        ParseTree tree = parser.prog();    // Start-Regel

        ASTNodeVisitor eval = new ASTNodeVisitor();
        ASTNode ast = tree.accept(eval);
        
        TreeViewer viewer = new TreeViewer(Collections.emptyList(), ast);
        viewer.open();
    }
}
