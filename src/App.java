import antlr.MiniPythonASTVisitor;
import antlr.MiniPythonLexer;
import antlr.MiniPythonParser;
import nodes.ASTNode;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.ASTEvalVisitor;
import visitors.ASTStringVisitor;
import visitors.ASTSymbolVisitor;
import visitors.ASTBuildVisitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        MiniPythonLexer lexer = null;
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            lexer = new MiniPythonLexer(CharStreams.fromString(everything));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            lexer = new MiniPythonLexer(CharStreams.fromStream(System.in));
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);

        ParseTree tree = parser.prog();

        MiniPythonASTVisitor astVisitor = new MiniPythonASTVisitor();
        ASTStringVisitor str = new ASTStringVisitor();
        ASTSymbolVisitor symbol = new ASTSymbolVisitor();
        ASTEvalVisitor eval = new ASTEvalVisitor();
        ASTBuildVisitor build = new ASTBuildVisitor(Path.of("bin/input"));
        if (args.length > 0) {
            build = new ASTBuildVisitor(Path.of("bin/" + Path.of(args[0]).getFileName().toString()));
        }

        ASTNode ast = tree.accept(astVisitor);
        // ast.accept(symbol);
        // ast.accept(eval);
        ast.accept(build);

        // System.out.println("============================");
        // System.out.println(ast.accept(str));

        TreeViewer viewer = new TreeViewer(Collections.emptyList(), ast);
        // viewer.open();
    }
}
