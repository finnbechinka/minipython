// Generated from c:\Users\finn-\Documents\code\minipython\src\miniPython.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miniPythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, IF=21, ELIF=22, ELSE=23, WHILE=24, CLAZZ=25, 
		DEF=26, RET=27, SELF=28, WS=29, NL=30, INT=31, BOOL=32, STRING=33, ID=34, 
		END=35;
	public static final int
		RULE_lit = 0, RULE_expr = 1, RULE_assign = 2, RULE_block = 3, RULE_funcCall = 4, 
		RULE_methodCall = 5, RULE_obj = 6, RULE_whileStmt = 7, RULE_ifStmt = 8, 
		RULE_inst = 9, RULE_funcDef = 10, RULE_clazz = 11, RULE_methodDef = 12, 
		RULE_prog = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"lit", "expr", "assign", "block", "funcCall", "methodCall", "obj", "whileStmt", 
			"ifStmt", "inst", "funcDef", "clazz", "methodDef", "prog"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'>='", "'>'", "'<='", 
			"'<'", "'or'", "'and'", "'not'", "'='", "'('", "','", "')'", "'.'", "':'", 
			"'):'", "'if'", "'elif'", "'else'", "'while'", "'class'", "'def'", "'return'", 
			"'self'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "IF", "ELIF", "ELSE", 
			"WHILE", "CLAZZ", "DEF", "RET", "SELF", "WS", "NL", "INT", "BOOL", "STRING", 
			"ID", "END"
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

	@Override
	public String getGrammarFileName() { return "miniPython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public miniPythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class LitContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(miniPythonParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(miniPythonParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(miniPythonParser.STRING, 0); }
		public LitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit; }
	}

	public final LitContext lit() throws RecognitionException {
		LitContext _localctx = new LitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EQUIContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EQUIContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ADDContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ADDContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class SUBContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SUBContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LEQUIContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LEQUIContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ORContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ORContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class MULContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MULContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class GREATERContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GREATERContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class UNEQUIContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public UNEQUIContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class GEQUIContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GEQUIContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ATOMContext extends ExprContext {
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public ATOMContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class DIVContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DIVContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class NOTContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NOTContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ANDContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ANDContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LESSContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LESSContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class IDContext extends ExprContext {
		public TerminalNode ID() { return getToken(miniPythonParser.ID, 0); }
		public IDContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				{
				_localctx = new NOTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(31);
				match(T__12);
				setState(32);
				expr(3);
				}
				break;
			case ID:
				{
				_localctx = new IDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(ID);
				}
				break;
			case INT:
			case BOOL:
			case STRING:
				{
				_localctx = new ATOMContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(73);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new MULContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(37);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(38);
						match(T__0);
						setState(39);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new DIVContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(40);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(41);
						match(T__1);
						setState(42);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new ADDContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(43);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(44);
						match(T__2);
						setState(45);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new SUBContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(46);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(47);
						match(T__3);
						setState(48);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new EQUIContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(49);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(50);
						match(T__4);
						setState(51);
						expr(12);
						}
						break;
					case 6:
						{
						_localctx = new UNEQUIContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(52);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(53);
						match(T__5);
						setState(54);
						expr(11);
						}
						break;
					case 7:
						{
						_localctx = new GEQUIContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(55);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(56);
						match(T__6);
						setState(57);
						expr(10);
						}
						break;
					case 8:
						{
						_localctx = new GREATERContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(59);
						match(T__7);
						setState(60);
						expr(9);
						}
						break;
					case 9:
						{
						_localctx = new LEQUIContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(62);
						match(T__8);
						setState(63);
						expr(8);
						}
						break;
					case 10:
						{
						_localctx = new LESSContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(65);
						match(T__9);
						setState(66);
						expr(7);
						}
						break;
					case 11:
						{
						_localctx = new ORContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(68);
						match(T__10);
						setState(69);
						expr(6);
						}
						break;
					case 12:
						{
						_localctx = new ANDContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(71);
						match(T__11);
						setState(72);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(miniPythonParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(miniPythonParser.NL, 0); }
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assign);
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(ID);
				setState(79);
				match(T__13);
				setState(80);
				expr(0);
				setState(81);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(ID);
				setState(84);
				match(T__13);
				setState(85);
				methodCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				match(ID);
				setState(87);
				match(T__13);
				setState(88);
				funcCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				match(ID);
				setState(90);
				match(T__13);
				setState(91);
				obj();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(94);
				inst();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(miniPythonParser.ID, 0); }
		public TerminalNode NL() { return getToken(miniPythonParser.NL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(ID);
			setState(101);
			match(T__14);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				setState(102);
				expr(0);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(103);
					match(T__15);
					setState(104);
					expr(0);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(112);
			match(T__16);
			setState(113);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(miniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(miniPythonParser.ID, i);
		}
		public TerminalNode NL() { return getToken(miniPythonParser.NL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(ID);
			setState(116);
			match(T__17);
			setState(117);
			match(ID);
			setState(118);
			match(T__14);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				setState(119);
				expr(0);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(120);
					match(T__15);
					setState(121);
					expr(0);
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(129);
			match(T__16);
			setState(130);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(miniPythonParser.ID, 0); }
		public TerminalNode NL() { return getToken(miniPythonParser.NL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_obj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(ID);
			setState(133);
			match(T__14);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				setState(134);
				expr(0);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(135);
					match(T__15);
					setState(136);
					expr(0);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144);
			match(T__16);
			setState(145);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(miniPythonParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(miniPythonParser.NL, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(miniPythonParser.END, 0); }
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(WHILE);
			setState(148);
			expr(0);
			setState(149);
			match(T__18);
			setState(150);
			match(NL);
			setState(151);
			block();
			setState(152);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(miniPythonParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(miniPythonParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(miniPythonParser.NL, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode END() { return getToken(miniPythonParser.END, 0); }
		public List<TerminalNode> ELIF() { return getTokens(miniPythonParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(miniPythonParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(miniPythonParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(IF);
			setState(155);
			expr(0);
			setState(156);
			match(T__18);
			setState(157);
			match(NL);
			setState(158);
			block();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(159);
				match(ELIF);
				setState(160);
				expr(0);
				setState(161);
				match(T__18);
				setState(162);
				match(NL);
				setState(163);
				block();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(170);
				match(ELSE);
				setState(171);
				match(T__18);
				setState(172);
				match(NL);
				setState(173);
				block();
				}
			}

			setState(176);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inst);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				funcCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				methodCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				ifStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(miniPythonParser.DEF, 0); }
		public List<TerminalNode> ID() { return getTokens(miniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(miniPythonParser.ID, i);
		}
		public List<TerminalNode> NL() { return getTokens(miniPythonParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(miniPythonParser.NL, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(miniPythonParser.END, 0); }
		public TerminalNode RET() { return getToken(miniPythonParser.RET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(DEF);
			setState(186);
			match(ID);
			setState(187);
			match(T__14);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(188);
				match(ID);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(189);
					match(T__15);
					setState(190);
					match(ID);
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(198);
			match(T__19);
			setState(199);
			match(NL);
			setState(200);
			block();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RET) {
				{
				setState(201);
				match(RET);
				setState(202);
				expr(0);
				setState(203);
				match(NL);
				}
			}

			setState(207);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClazzContext extends ParserRuleContext {
		public TerminalNode CLAZZ() { return getToken(miniPythonParser.CLAZZ, 0); }
		public List<TerminalNode> ID() { return getTokens(miniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(miniPythonParser.ID, i);
		}
		public TerminalNode NL() { return getToken(miniPythonParser.NL, 0); }
		public TerminalNode END() { return getToken(miniPythonParser.END, 0); }
		public List<MethodDefContext> methodDef() {
			return getRuleContexts(MethodDefContext.class);
		}
		public MethodDefContext methodDef(int i) {
			return getRuleContext(MethodDefContext.class,i);
		}
		public ClazzContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clazz; }
	}

	public final ClazzContext clazz() throws RecognitionException {
		ClazzContext _localctx = new ClazzContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_clazz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(CLAZZ);
			setState(210);
			match(ID);
			setState(211);
			match(T__14);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(212);
				match(ID);
				}
			}

			setState(215);
			match(T__19);
			setState(216);
			match(NL);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(217);
				methodDef();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(miniPythonParser.DEF, 0); }
		public List<TerminalNode> ID() { return getTokens(miniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(miniPythonParser.ID, i);
		}
		public TerminalNode SELF() { return getToken(miniPythonParser.SELF, 0); }
		public List<TerminalNode> NL() { return getTokens(miniPythonParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(miniPythonParser.NL, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(miniPythonParser.END, 0); }
		public TerminalNode RET() { return getToken(miniPythonParser.RET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MethodDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDef; }
	}

	public final MethodDefContext methodDef() throws RecognitionException {
		MethodDefContext _localctx = new MethodDefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_methodDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(DEF);
			setState(226);
			match(ID);
			setState(227);
			match(T__14);
			setState(228);
			match(SELF);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(229);
				match(T__15);
				setState(230);
				match(ID);
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(236);
			match(T__19);
			setState(237);
			match(NL);
			setState(238);
			block();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RET) {
				{
				setState(239);
				match(RET);
				setState(240);
				expr(0);
				setState(241);
				match(NL);
				}
			}

			setState(245);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(miniPythonParser.EOF, 0); }
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ClazzContext> clazz() {
			return getRuleContexts(ClazzContext.class);
		}
		public ClazzContext clazz(int i) {
			return getRuleContext(ClazzContext.class,i);
		}
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(miniPythonParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(miniPythonParser.NL, i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << CLAZZ) | (1L << DEF) | (1L << NL) | (1L << ID))) != 0)) {
				{
				setState(251);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DEF:
					{
					setState(247);
					funcDef();
					}
					break;
				case CLAZZ:
					{
					setState(248);
					clazz();
					}
					break;
				case IF:
				case WHILE:
				case ID:
					{
					setState(249);
					inst();
					}
					break;
				case NL:
					{
					setState(250);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u0105\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5"+
		"\3&\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3L\n\3\f\3\16\3O\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4_\n\4\3\5\7\5b\n\5\f\5\16\5e\13\5\3\6\3\6\3"+
		"\6\3\6\3\6\7\6l\n\6\f\6\16\6o\13\6\5\6q\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\7\7}\n\7\f\7\16\7\u0080\13\7\5\7\u0082\n\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\7\b\u008c\n\b\f\b\16\b\u008f\13\b\5\b\u0091\n\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\u00a8\n\n\f\n\16\n\u00ab\13\n\3\n\3\n\3\n\3\n\5\n\u00b1"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u00ba\n\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u00c2\n\f\f\f\16\f\u00c5\13\f\5\f\u00c7\n\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00d0\n\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00d8\n\r\3\r"+
		"\3\r\3\r\7\r\u00dd\n\r\f\r\16\r\u00e0\13\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u00ea\n\16\f\16\16\16\u00ed\13\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00f6\n\16\3\16\3\16\3\17\3\17\3\17\3\17\7\17\u00fe"+
		"\n\17\f\17\16\17\u0101\13\17\3\17\3\17\3\17\2\3\4\20\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\2\3\3\2!#\2\u011f\2\36\3\2\2\2\4%\3\2\2\2\6^\3\2\2"+
		"\2\bc\3\2\2\2\nf\3\2\2\2\fu\3\2\2\2\16\u0086\3\2\2\2\20\u0095\3\2\2\2"+
		"\22\u009c\3\2\2\2\24\u00b9\3\2\2\2\26\u00bb\3\2\2\2\30\u00d3\3\2\2\2\32"+
		"\u00e3\3\2\2\2\34\u00ff\3\2\2\2\36\37\t\2\2\2\37\3\3\2\2\2 !\b\3\1\2!"+
		"\"\7\17\2\2\"&\5\4\3\5#&\7$\2\2$&\5\2\2\2% \3\2\2\2%#\3\2\2\2%$\3\2\2"+
		"\2&M\3\2\2\2\'(\f\21\2\2()\7\3\2\2)L\5\4\3\22*+\f\20\2\2+,\7\4\2\2,L\5"+
		"\4\3\21-.\f\17\2\2./\7\5\2\2/L\5\4\3\20\60\61\f\16\2\2\61\62\7\6\2\2\62"+
		"L\5\4\3\17\63\64\f\r\2\2\64\65\7\7\2\2\65L\5\4\3\16\66\67\f\f\2\2\678"+
		"\7\b\2\28L\5\4\3\r9:\f\13\2\2:;\7\t\2\2;L\5\4\3\f<=\f\n\2\2=>\7\n\2\2"+
		">L\5\4\3\13?@\f\t\2\2@A\7\13\2\2AL\5\4\3\nBC\f\b\2\2CD\7\f\2\2DL\5\4\3"+
		"\tEF\f\7\2\2FG\7\r\2\2GL\5\4\3\bHI\f\6\2\2IJ\7\16\2\2JL\5\4\3\7K\'\3\2"+
		"\2\2K*\3\2\2\2K-\3\2\2\2K\60\3\2\2\2K\63\3\2\2\2K\66\3\2\2\2K9\3\2\2\2"+
		"K<\3\2\2\2K?\3\2\2\2KB\3\2\2\2KE\3\2\2\2KH\3\2\2\2LO\3\2\2\2MK\3\2\2\2"+
		"MN\3\2\2\2N\5\3\2\2\2OM\3\2\2\2PQ\7$\2\2QR\7\20\2\2RS\5\4\3\2ST\7 \2\2"+
		"T_\3\2\2\2UV\7$\2\2VW\7\20\2\2W_\5\f\7\2XY\7$\2\2YZ\7\20\2\2Z_\5\n\6\2"+
		"[\\\7$\2\2\\]\7\20\2\2]_\5\16\b\2^P\3\2\2\2^U\3\2\2\2^X\3\2\2\2^[\3\2"+
		"\2\2_\7\3\2\2\2`b\5\24\13\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\t"+
		"\3\2\2\2ec\3\2\2\2fg\7$\2\2gp\7\21\2\2hm\5\4\3\2ij\7\22\2\2jl\5\4\3\2"+
		"ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2ph\3\2\2\2"+
		"pq\3\2\2\2qr\3\2\2\2rs\7\23\2\2st\7 \2\2t\13\3\2\2\2uv\7$\2\2vw\7\24\2"+
		"\2wx\7$\2\2x\u0081\7\21\2\2y~\5\4\3\2z{\7\22\2\2{}\5\4\3\2|z\3\2\2\2}"+
		"\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2"+
		"\u0081y\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7"+
		"\23\2\2\u0084\u0085\7 \2\2\u0085\r\3\2\2\2\u0086\u0087\7$\2\2\u0087\u0090"+
		"\7\21\2\2\u0088\u008d\5\4\3\2\u0089\u008a\7\22\2\2\u008a\u008c\5\4\3\2"+
		"\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0088\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\23\2\2\u0093\u0094\7"+
		" \2\2\u0094\17\3\2\2\2\u0095\u0096\7\32\2\2\u0096\u0097\5\4\3\2\u0097"+
		"\u0098\7\25\2\2\u0098\u0099\7 \2\2\u0099\u009a\5\b\5\2\u009a\u009b\7%"+
		"\2\2\u009b\21\3\2\2\2\u009c\u009d\7\27\2\2\u009d\u009e\5\4\3\2\u009e\u009f"+
		"\7\25\2\2\u009f\u00a0\7 \2\2\u00a0\u00a9\5\b\5\2\u00a1\u00a2\7\30\2\2"+
		"\u00a2\u00a3\5\4\3\2\u00a3\u00a4\7\25\2\2\u00a4\u00a5\7 \2\2\u00a5\u00a6"+
		"\5\b\5\2\u00a6\u00a8\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00b0\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ac\u00ad\7\31\2\2\u00ad\u00ae\7\25\2\2\u00ae\u00af\7 \2\2\u00af"+
		"\u00b1\5\b\5\2\u00b0\u00ac\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b3\7%\2\2\u00b3\23\3\2\2\2\u00b4\u00ba\5\6\4\2\u00b5\u00ba"+
		"\5\n\6\2\u00b6\u00ba\5\f\7\2\u00b7\u00ba\5\20\t\2\u00b8\u00ba\5\22\n\2"+
		"\u00b9\u00b4\3\2\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7"+
		"\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\25\3\2\2\2\u00bb\u00bc\7\34\2\2\u00bc"+
		"\u00bd\7$\2\2\u00bd\u00c6\7\21\2\2\u00be\u00c3\7$\2\2\u00bf\u00c0\7\22"+
		"\2\2\u00c0\u00c2\7$\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2"+
		"\2\2\u00c6\u00be\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c9\7\26\2\2\u00c9\u00ca\7 \2\2\u00ca\u00cf\5\b\5\2\u00cb\u00cc\7\35"+
		"\2\2\u00cc\u00cd\5\4\3\2\u00cd\u00ce\7 \2\2\u00ce\u00d0\3\2\2\2\u00cf"+
		"\u00cb\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7%"+
		"\2\2\u00d2\27\3\2\2\2\u00d3\u00d4\7\33\2\2\u00d4\u00d5\7$\2\2\u00d5\u00d7"+
		"\7\21\2\2\u00d6\u00d8\7$\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00da\7\26\2\2\u00da\u00de\7 \2\2\u00db\u00dd\5\32"+
		"\16\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7%"+
		"\2\2\u00e2\31\3\2\2\2\u00e3\u00e4\7\34\2\2\u00e4\u00e5\7$\2\2\u00e5\u00e6"+
		"\7\21\2\2\u00e6\u00eb\7\36\2\2\u00e7\u00e8\7\22\2\2\u00e8\u00ea\7$\2\2"+
		"\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7\26\2\2"+
		"\u00ef\u00f0\7 \2\2\u00f0\u00f5\5\b\5\2\u00f1\u00f2\7\35\2\2\u00f2\u00f3"+
		"\5\4\3\2\u00f3\u00f4\7 \2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\7%\2\2\u00f8\33\3\2\2\2"+
		"\u00f9\u00fe\5\26\f\2\u00fa\u00fe\5\30\r\2\u00fb\u00fe\5\24\13\2\u00fc"+
		"\u00fe\7 \2\2\u00fd\u00f9\3\2\2\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\7\2"+
		"\2\3\u0103\35\3\2\2\2\31%KM^cmp~\u0081\u008d\u0090\u00a9\u00b0\u00b9\u00c3"+
		"\u00c6\u00cf\u00d7\u00de\u00eb\u00f5\u00fd\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}