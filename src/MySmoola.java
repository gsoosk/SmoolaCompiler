import main.ast.VisitorImpl;
import main.ast.node.Program;
import org.antlr.v4.runtime.*;
import java.io.IOException;

// Visit https://stackoverflow.com/questions/26451636/how-do-i-use-antlr-generated-parser-and-lexer
public class MySmoola {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);
        SmoolaLexer lexer = new SmoolaLexer(reader);   // SmoolaLexer in your project
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SmoolaParser parser = new SmoolaParser(tokens);   // SmoolaParser in your project
        Program p = parser.program().p; // program is the name of the start rule

        VisitorImpl v = new VisitorImpl();
        p.accept(v);
    }
}
