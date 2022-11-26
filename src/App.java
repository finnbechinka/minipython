import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Collections;
import Nodes.*;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class App {
    public static void main(String[] args) throws Exception {
        MiniPythonLexer lexer = null;
        try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
        
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            lexer = new MiniPythonLexer(CharStreams.fromString(everything));
        }catch(Exception e){
            lexer = new MiniPythonLexer(CharStreams.fromStream(System.in));
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);

        ParseTree tree = parser.prog();    // Start-Regel

        ASTNodeVisitor eval = new ASTNodeVisitor();
        ASTNode ast = tree.accept(eval);
        
        TreeViewer viewer = new TreeViewer(Collections.emptyList(), ast);
        viewer.open();
    }
}
