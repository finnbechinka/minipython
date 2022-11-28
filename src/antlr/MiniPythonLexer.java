package antlr;
// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniPythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, WS=21, NL=22, IF=23, ELIF=24, ELSE=25, WHILE=26, 
		CLAZZ=27, DEF=28, RET=29, SELF=30, INT=31, BOOL=32, STRING=33, ID=34, 
		END=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "WS", "NL", "IF", "ELIF", "ELSE", "WHILE", 
			"CLAZZ", "DEF", "RET", "SELF", "INT", "BOOL", "STRING", "ID", "END"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'>='", "'>'", 
			"'<='", "'<'", "'not'", "'and'", "'or'", "','", "'='", "'('", "')'", 
			"':'", "'):'", null, null, "'if'", "'elif'", "'else'", "'while'", "'class'", 
			"'def'", "'return'", "'self'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "WS", "NL", "IF", 
			"ELIF", "ELSE", "WHILE", "CLAZZ", "DEF", "RET", "SELF", "INT", "BOOL", 
			"STRING", "ID", "END"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MiniPythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniPython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000#\u00dc\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0004\u0014{\b\u0014\u000b\u0014\f\u0014|\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0003\u0015\u0082\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0005"+
		"\u001e\u00b1\b\u001e\n\u001e\f\u001e\u00b4\t\u001e\u0001\u001e\u0003\u001e"+
		"\u00b7\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u00c2\b\u001f"+
		"\u0001 \u0001 \u0001 \u0001 \u0005 \u00c8\b \n \f \u00cb\t \u0001 \u0001"+
		" \u0001!\u0001!\u0005!\u00d1\b!\n!\f!\u00d4\t!\u0001\"\u0001\"\u0001\""+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0000\u0000#\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d;\u001e=\u001f? A!C\"E#\u0001\u0000\b\u0002\u0000\t\t  "+
		"\u0001\u000019\u0001\u000009\u0001\u000000\u0002\u0000\"\"\\\\\u0004\u0000"+
		"\n\n\r\r\"\"\\\\\u0003\u0000AZ__az\u0004\u000009AZ__az\u00e3\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000"+
		"5\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001"+
		"\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000"+
		"\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000"+
		"C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0001G\u0001"+
		"\u0000\u0000\u0000\u0003I\u0001\u0000\u0000\u0000\u0005K\u0001\u0000\u0000"+
		"\u0000\u0007M\u0001\u0000\u0000\u0000\tO\u0001\u0000\u0000\u0000\u000b"+
		"Q\u0001\u0000\u0000\u0000\rT\u0001\u0000\u0000\u0000\u000fW\u0001\u0000"+
		"\u0000\u0000\u0011Z\u0001\u0000\u0000\u0000\u0013\\\u0001\u0000\u0000"+
		"\u0000\u0015_\u0001\u0000\u0000\u0000\u0017a\u0001\u0000\u0000\u0000\u0019"+
		"e\u0001\u0000\u0000\u0000\u001bi\u0001\u0000\u0000\u0000\u001dl\u0001"+
		"\u0000\u0000\u0000\u001fn\u0001\u0000\u0000\u0000!p\u0001\u0000\u0000"+
		"\u0000#r\u0001\u0000\u0000\u0000%t\u0001\u0000\u0000\u0000\'v\u0001\u0000"+
		"\u0000\u0000)z\u0001\u0000\u0000\u0000+\u0081\u0001\u0000\u0000\u0000"+
		"-\u0085\u0001\u0000\u0000\u0000/\u0088\u0001\u0000\u0000\u00001\u008d"+
		"\u0001\u0000\u0000\u00003\u0092\u0001\u0000\u0000\u00005\u0098\u0001\u0000"+
		"\u0000\u00007\u009e\u0001\u0000\u0000\u00009\u00a2\u0001\u0000\u0000\u0000"+
		";\u00a9\u0001\u0000\u0000\u0000=\u00b6\u0001\u0000\u0000\u0000?\u00c1"+
		"\u0001\u0000\u0000\u0000A\u00c3\u0001\u0000\u0000\u0000C\u00ce\u0001\u0000"+
		"\u0000\u0000E\u00d5\u0001\u0000\u0000\u0000GH\u0005.\u0000\u0000H\u0002"+
		"\u0001\u0000\u0000\u0000IJ\u0005*\u0000\u0000J\u0004\u0001\u0000\u0000"+
		"\u0000KL\u0005/\u0000\u0000L\u0006\u0001\u0000\u0000\u0000MN\u0005+\u0000"+
		"\u0000N\b\u0001\u0000\u0000\u0000OP\u0005-\u0000\u0000P\n\u0001\u0000"+
		"\u0000\u0000QR\u0005=\u0000\u0000RS\u0005=\u0000\u0000S\f\u0001\u0000"+
		"\u0000\u0000TU\u0005!\u0000\u0000UV\u0005=\u0000\u0000V\u000e\u0001\u0000"+
		"\u0000\u0000WX\u0005>\u0000\u0000XY\u0005=\u0000\u0000Y\u0010\u0001\u0000"+
		"\u0000\u0000Z[\u0005>\u0000\u0000[\u0012\u0001\u0000\u0000\u0000\\]\u0005"+
		"<\u0000\u0000]^\u0005=\u0000\u0000^\u0014\u0001\u0000\u0000\u0000_`\u0005"+
		"<\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ab\u0005n\u0000\u0000bc\u0005"+
		"o\u0000\u0000cd\u0005t\u0000\u0000d\u0018\u0001\u0000\u0000\u0000ef\u0005"+
		"a\u0000\u0000fg\u0005n\u0000\u0000gh\u0005d\u0000\u0000h\u001a\u0001\u0000"+
		"\u0000\u0000ij\u0005o\u0000\u0000jk\u0005r\u0000\u0000k\u001c\u0001\u0000"+
		"\u0000\u0000lm\u0005,\u0000\u0000m\u001e\u0001\u0000\u0000\u0000no\u0005"+
		"=\u0000\u0000o \u0001\u0000\u0000\u0000pq\u0005(\u0000\u0000q\"\u0001"+
		"\u0000\u0000\u0000rs\u0005)\u0000\u0000s$\u0001\u0000\u0000\u0000tu\u0005"+
		":\u0000\u0000u&\u0001\u0000\u0000\u0000vw\u0005)\u0000\u0000wx\u0005:"+
		"\u0000\u0000x(\u0001\u0000\u0000\u0000y{\u0007\u0000\u0000\u0000zy\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0006\u0014"+
		"\u0000\u0000\u007f*\u0001\u0000\u0000\u0000\u0080\u0082\u0005\r\u0000"+
		"\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0005\n\u0000\u0000"+
		"\u0084,\u0001\u0000\u0000\u0000\u0085\u0086\u0005i\u0000\u0000\u0086\u0087"+
		"\u0005f\u0000\u0000\u0087.\u0001\u0000\u0000\u0000\u0088\u0089\u0005e"+
		"\u0000\u0000\u0089\u008a\u0005l\u0000\u0000\u008a\u008b\u0005i\u0000\u0000"+
		"\u008b\u008c\u0005f\u0000\u0000\u008c0\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0005e\u0000\u0000\u008e\u008f\u0005l\u0000\u0000\u008f\u0090\u0005s"+
		"\u0000\u0000\u0090\u0091\u0005e\u0000\u0000\u00912\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0005w\u0000\u0000\u0093\u0094\u0005h\u0000\u0000\u0094\u0095"+
		"\u0005i\u0000\u0000\u0095\u0096\u0005l\u0000\u0000\u0096\u0097\u0005e"+
		"\u0000\u0000\u00974\u0001\u0000\u0000\u0000\u0098\u0099\u0005c\u0000\u0000"+
		"\u0099\u009a\u0005l\u0000\u0000\u009a\u009b\u0005a\u0000\u0000\u009b\u009c"+
		"\u0005s\u0000\u0000\u009c\u009d\u0005s\u0000\u0000\u009d6\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0005d\u0000\u0000\u009f\u00a0\u0005e\u0000\u0000"+
		"\u00a0\u00a1\u0005f\u0000\u0000\u00a18\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0005r\u0000\u0000\u00a3\u00a4\u0005e\u0000\u0000\u00a4\u00a5\u0005t"+
		"\u0000\u0000\u00a5\u00a6\u0005u\u0000\u0000\u00a6\u00a7\u0005r\u0000\u0000"+
		"\u00a7\u00a8\u0005n\u0000\u0000\u00a8:\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0005s\u0000\u0000\u00aa\u00ab\u0005e\u0000\u0000\u00ab\u00ac\u0005l"+
		"\u0000\u0000\u00ac\u00ad\u0005f\u0000\u0000\u00ad<\u0001\u0000\u0000\u0000"+
		"\u00ae\u00b2\u0007\u0001\u0000\u0000\u00af\u00b1\u0007\u0002\u0000\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b7\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b7\u0007\u0003\u0000\u0000\u00b6\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7>\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0005T\u0000\u0000\u00b9\u00ba\u0005r\u0000\u0000\u00ba\u00bb\u0005"+
		"u\u0000\u0000\u00bb\u00c2\u0005e\u0000\u0000\u00bc\u00bd\u0005F\u0000"+
		"\u0000\u00bd\u00be\u0005a\u0000\u0000\u00be\u00bf\u0005l\u0000\u0000\u00bf"+
		"\u00c0\u0005s\u0000\u0000\u00c0\u00c2\u0005e\u0000\u0000\u00c1\u00b8\u0001"+
		"\u0000\u0000\u0000\u00c1\u00bc\u0001\u0000\u0000\u0000\u00c2@\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c9\u0005\"\u0000\u0000\u00c4\u00c5\u0005\\\u0000"+
		"\u0000\u00c5\u00c8\u0007\u0004\u0000\u0000\u00c6\u00c8\b\u0005\u0000\u0000"+
		"\u00c7\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\"\u0000\u0000\u00cd"+
		"B\u0001\u0000\u0000\u0000\u00ce\u00d2\u0007\u0006\u0000\u0000\u00cf\u00d1"+
		"\u0007\u0007\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d3D\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0005#\u0000\u0000\u00d6\u00d7\u0005e\u0000"+
		"\u0000\u00d7\u00d8\u0005n\u0000\u0000\u00d8\u00d9\u0005d\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u00db\u0003+\u0015\u0000\u00dbF\u0001"+
		"\u0000\u0000\u0000\t\u0000|\u0081\u00b2\u00b6\u00c1\u00c7\u00c9\u00d2"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}