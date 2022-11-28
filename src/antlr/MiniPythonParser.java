package antlr;

// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniPythonParser extends Parser {
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
	public static final int
		RULE_lit = 0, RULE_expr = 1, RULE_assign = 2, RULE_args = 3, RULE_call = 4, 
		RULE_memberCall = 5, RULE_whileStmt = 6, RULE_ifStmt = 7, RULE_elifStmt = 8, 
		RULE_inst = 9, RULE_block = 10, RULE_funcDef = 11, RULE_clazz = 12, RULE_methodDef = 13, 
		RULE_parameters = 14, RULE_return = 15, RULE_prog = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"lit", "expr", "assign", "args", "call", "memberCall", "whileStmt", "ifStmt", 
			"elifStmt", "inst", "block", "funcDef", "clazz", "methodDef", "parameters", 
			"return", "prog"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'>='", "'>'", "'<='", 
			"'<'", "'not'", "'and'", "'or'", "'='", "','", "'('", "')'", "'.'", "':'", 
			"'):'", null, null, "'if'", "'elif'", "'else'", "'while'", "'class'", 
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

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniPythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LitContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniPythonParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MiniPythonParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(MiniPythonParser.BOOL, 0); }
		public LitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LitContext lit() throws RecognitionException {
		LitContext _localctx = new LitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 15032385536L) != 0) ) {
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class EQUIContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EQUIContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitEQUI(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ADDContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ADDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitADD(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SUBContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SUBContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitSUB(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LEQUIContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LEQUIContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitLEQUI(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ORContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ORContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitOR(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MULContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MULContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitMUL(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GREATERContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GREATERContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitGREATER(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UNEQUIContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public UNEQUIContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitUNEQUI(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GEQUIContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GEQUIContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitGEQUI(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ATOMContext extends ExprContext {
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public ATOMContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitATOM(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DIVContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DIVContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitDIV(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NOTContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NOTContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitNOT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ANDContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ANDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitAND(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LESSContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LESSContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitLESS(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDContext extends ExprContext {
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public IDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitID(this);
			else return visitor.visitChildren(this);
		}
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
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				_localctx = new NOTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(37);
				((NOTContext)_localctx).op = match(T__10);
				setState(38);
				expr(5);
				}
				break;
			case INT:
			case BOOL:
			case STRING:
				{
				_localctx = new ATOMContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				lit();
				}
				break;
			case ID:
				{
				_localctx = new IDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(79);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new MULContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(43);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(44);
						((MULContext)_localctx).op = match(T__0);
						setState(45);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new DIVContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(46);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(47);
						((DIVContext)_localctx).op = match(T__1);
						setState(48);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new ADDContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(49);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(50);
						((ADDContext)_localctx).op = match(T__2);
						setState(51);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new SUBContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(52);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(53);
						((SUBContext)_localctx).op = match(T__3);
						setState(54);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new EQUIContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(55);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(56);
						((EQUIContext)_localctx).op = match(T__4);
						setState(57);
						expr(12);
						}
						break;
					case 6:
						{
						_localctx = new UNEQUIContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(59);
						((UNEQUIContext)_localctx).op = match(T__5);
						setState(60);
						expr(11);
						}
						break;
					case 7:
						{
						_localctx = new GEQUIContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(62);
						((GEQUIContext)_localctx).op = match(T__6);
						setState(63);
						expr(10);
						}
						break;
					case 8:
						{
						_localctx = new GREATERContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(65);
						((GREATERContext)_localctx).op = match(T__7);
						setState(66);
						expr(9);
						}
						break;
					case 9:
						{
						_localctx = new LEQUIContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(68);
						((LEQUIContext)_localctx).op = match(T__8);
						setState(69);
						expr(8);
						}
						break;
					case 10:
						{
						_localctx = new LESSContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(71);
						((LESSContext)_localctx).op = match(T__9);
						setState(72);
						expr(7);
						}
						break;
					case 11:
						{
						_localctx = new ANDContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(74);
						((ANDContext)_localctx).op = match(T__11);
						setState(75);
						expr(5);
						}
						break;
					case 12:
						{
						_localctx = new ORContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(77);
						((ORContext)_localctx).op = match(T__12);
						setState(78);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(83);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public MemberCallContext memberCall() {
			return getRuleContext(MemberCallContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(ID);
			setState(85);
			match(T__13);
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(86);
				expr(0);
				setState(87);
				match(NL);
				}
				break;
			case 2:
				{
				setState(89);
				memberCall();
				}
				break;
			case 3:
				{
				setState(90);
				call();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			expr(0);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(94);
				match(T__14);
				setState(95);
				expr(0);
				}
				}
				setState(100);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(ID);
			setState(102);
			match(T__15);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 32212256768L) != 0) {
				{
				setState(103);
				args();
				}
			}

			setState(106);
			match(T__16);
			setState(107);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MemberCallContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MiniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniPythonParser.ID, i);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public MemberCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitMemberCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberCallContext memberCall() throws RecognitionException {
		MemberCallContext _localctx = new MemberCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_memberCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(ID);
			setState(110);
			match(T__17);
			setState(111);
			match(ID);
			setState(112);
			match(T__15);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 32212256768L) != 0) {
				{
				setState(113);
				args();
				}
			}

			setState(116);
			match(T__16);
			setState(117);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniPythonParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(WHILE);
			setState(120);
			expr(0);
			setState(121);
			match(T__18);
			setState(122);
			match(NL);
			setState(123);
			block();
			setState(124);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniPythonParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(MiniPythonParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(MiniPythonParser.NL, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public List<ElifStmtContext> elifStmt() {
			return getRuleContexts(ElifStmtContext.class);
		}
		public ElifStmtContext elifStmt(int i) {
			return getRuleContext(ElifStmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniPythonParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(IF);
			setState(127);
			expr(0);
			setState(128);
			match(T__18);
			setState(129);
			match(NL);
			setState(130);
			block();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(131);
				elifStmt();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(137);
				match(ELSE);
				setState(138);
				match(T__18);
				setState(139);
				match(NL);
				setState(140);
				block();
				}
			}

			setState(143);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElifStmtContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(MiniPythonParser.ELIF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElifStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitElifStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElifStmtContext elifStmt() throws RecognitionException {
		ElifStmtContext _localctx = new ElifStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ELIF);
			setState(146);
			expr(0);
			setState(147);
			match(T__18);
			setState(148);
			match(NL);
			setState(149);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public MemberCallContext memberCall() {
			return getRuleContext(MemberCallContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inst);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				call();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				memberCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(MiniPythonParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(MiniPythonParser.NL, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 17259560960L) != 0) {
				{
				setState(160);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF:
				case WHILE:
				case ID:
					{
					setState(158);
					inst();
					}
					break;
				case NL:
					{
					setState(159);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(164);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(MiniPythonParser.DEF, 0); }
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(DEF);
			setState(166);
			match(ID);
			setState(167);
			match(T__15);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(168);
				parameters();
				}
			}

			setState(171);
			match(T__19);
			setState(172);
			block();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RET) {
				{
				setState(173);
				return_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClazzContext extends ParserRuleContext {
		public TerminalNode CLAZZ() { return getToken(MiniPythonParser.CLAZZ, 0); }
		public List<TerminalNode> ID() { return getTokens(MiniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniPythonParser.ID, i);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitClazz(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClazzContext clazz() throws RecognitionException {
		ClazzContext _localctx = new ClazzContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_clazz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(CLAZZ);
			setState(179);
			match(ID);
			setState(180);
			match(T__15);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(181);
				match(ID);
				}
			}

			setState(184);
			match(T__19);
			setState(185);
			match(NL);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(186);
				methodDef();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(MiniPythonParser.DEF, 0); }
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public TerminalNode SELF() { return getToken(MiniPythonParser.SELF, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public MethodDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitMethodDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDefContext methodDef() throws RecognitionException {
		MethodDefContext _localctx = new MethodDefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_methodDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(DEF);
			setState(195);
			match(ID);
			setState(196);
			match(T__15);
			setState(197);
			match(SELF);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(198);
				match(T__14);
				setState(199);
				parameters();
				}
			}

			setState(202);
			match(T__19);
			setState(203);
			block();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RET) {
				{
				setState(204);
				return_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MiniPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniPythonParser.ID, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(ID);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(210);
				match(T__14);
				setState(211);
				match(ID);
				}
				}
				setState(216);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public TerminalNode RET() { return getToken(MiniPythonParser.RET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(MiniPythonParser.NL, 0); }
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(RET);
			setState(218);
			expr(0);
			setState(219);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniPythonParser.EOF, 0); }
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
		public List<TerminalNode> NL() { return getTokens(MiniPythonParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(MiniPythonParser.NL, i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 17662214144L) != 0) {
				{
				setState(225);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DEF:
					{
					setState(221);
					funcDef();
					}
					break;
				case CLAZZ:
					{
					setState(222);
					clazz();
					}
					break;
				case IF:
				case WHILE:
				case ID:
					{
					setState(223);
					inst();
					}
					break;
				case NL:
					{
					setState(224);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
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
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001#\u00e9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001*\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"P\b\u0001\n\u0001\f\u0001S\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\\\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003a\b\u0003\n\u0003\f\u0003"+
		"d\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004i\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005s\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0085\b\u0007\n\u0007\f\u0007\u0088\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u008e\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u009d\b\t\u0001\n\u0001"+
		"\n\u0005\n\u00a1\b\n\n\n\f\n\u00a4\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00aa\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00af\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00b7\b\f\u0001\f\u0001\f\u0001\f\u0005\f\u00bc\b\f"+
		"\n\f\f\f\u00bf\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00c9\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u00ce\b\r"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00d5"+
		"\b\u000e\n\u000e\f\u000e\u00d8\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u00e2\b\u0010\n\u0010\f\u0010\u00e5\t\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0000\u0001\u0002\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0001\u0001\u0000\u001f"+
		"!\u00fd\u0000\"\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000"+
		"\u0004T\u0001\u0000\u0000\u0000\u0006]\u0001\u0000\u0000\u0000\be\u0001"+
		"\u0000\u0000\u0000\nm\u0001\u0000\u0000\u0000\fw\u0001\u0000\u0000\u0000"+
		"\u000e~\u0001\u0000\u0000\u0000\u0010\u0091\u0001\u0000\u0000\u0000\u0012"+
		"\u009c\u0001\u0000\u0000\u0000\u0014\u00a2\u0001\u0000\u0000\u0000\u0016"+
		"\u00a5\u0001\u0000\u0000\u0000\u0018\u00b2\u0001\u0000\u0000\u0000\u001a"+
		"\u00c2\u0001\u0000\u0000\u0000\u001c\u00d1\u0001\u0000\u0000\u0000\u001e"+
		"\u00d9\u0001\u0000\u0000\u0000 \u00e3\u0001\u0000\u0000\u0000\"#\u0007"+
		"\u0000\u0000\u0000#\u0001\u0001\u0000\u0000\u0000$%\u0006\u0001\uffff"+
		"\uffff\u0000%&\u0005\u000b\u0000\u0000&*\u0003\u0002\u0001\u0005\'*\u0003"+
		"\u0000\u0000\u0000(*\u0005\"\u0000\u0000)$\u0001\u0000\u0000\u0000)\'"+
		"\u0001\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*Q\u0001\u0000\u0000"+
		"\u0000+,\n\u000f\u0000\u0000,-\u0005\u0001\u0000\u0000-P\u0003\u0002\u0001"+
		"\u0010./\n\u000e\u0000\u0000/0\u0005\u0002\u0000\u00000P\u0003\u0002\u0001"+
		"\u000f12\n\r\u0000\u000023\u0005\u0003\u0000\u00003P\u0003\u0002\u0001"+
		"\u000e45\n\f\u0000\u000056\u0005\u0004\u0000\u00006P\u0003\u0002\u0001"+
		"\r78\n\u000b\u0000\u000089\u0005\u0005\u0000\u00009P\u0003\u0002\u0001"+
		"\f:;\n\n\u0000\u0000;<\u0005\u0006\u0000\u0000<P\u0003\u0002\u0001\u000b"+
		"=>\n\t\u0000\u0000>?\u0005\u0007\u0000\u0000?P\u0003\u0002\u0001\n@A\n"+
		"\b\u0000\u0000AB\u0005\b\u0000\u0000BP\u0003\u0002\u0001\tCD\n\u0007\u0000"+
		"\u0000DE\u0005\t\u0000\u0000EP\u0003\u0002\u0001\bFG\n\u0006\u0000\u0000"+
		"GH\u0005\n\u0000\u0000HP\u0003\u0002\u0001\u0007IJ\n\u0004\u0000\u0000"+
		"JK\u0005\f\u0000\u0000KP\u0003\u0002\u0001\u0005LM\n\u0003\u0000\u0000"+
		"MN\u0005\r\u0000\u0000NP\u0003\u0002\u0001\u0004O+\u0001\u0000\u0000\u0000"+
		"O.\u0001\u0000\u0000\u0000O1\u0001\u0000\u0000\u0000O4\u0001\u0000\u0000"+
		"\u0000O7\u0001\u0000\u0000\u0000O:\u0001\u0000\u0000\u0000O=\u0001\u0000"+
		"\u0000\u0000O@\u0001\u0000\u0000\u0000OC\u0001\u0000\u0000\u0000OF\u0001"+
		"\u0000\u0000\u0000OI\u0001\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000"+
		"PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000R\u0003\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TU\u0005"+
		"\"\u0000\u0000U[\u0005\u000e\u0000\u0000VW\u0003\u0002\u0001\u0000WX\u0005"+
		"\u0016\u0000\u0000X\\\u0001\u0000\u0000\u0000Y\\\u0003\n\u0005\u0000Z"+
		"\\\u0003\b\u0004\u0000[V\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"[Z\u0001\u0000\u0000\u0000\\\u0005\u0001\u0000\u0000\u0000]b\u0003\u0002"+
		"\u0001\u0000^_\u0005\u000f\u0000\u0000_a\u0003\u0002\u0001\u0000`^\u0001"+
		"\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000c\u0007\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000ef\u0005\"\u0000\u0000fh\u0005\u0010\u0000\u0000gi\u0003\u0006"+
		"\u0003\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jk\u0005\u0011\u0000\u0000kl\u0005\u0016\u0000\u0000"+
		"l\t\u0001\u0000\u0000\u0000mn\u0005\"\u0000\u0000no\u0005\u0012\u0000"+
		"\u0000op\u0005\"\u0000\u0000pr\u0005\u0010\u0000\u0000qs\u0003\u0006\u0003"+
		"\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tu\u0005\u0011\u0000\u0000uv\u0005\u0016\u0000\u0000v\u000b"+
		"\u0001\u0000\u0000\u0000wx\u0005\u001a\u0000\u0000xy\u0003\u0002\u0001"+
		"\u0000yz\u0005\u0013\u0000\u0000z{\u0005\u0016\u0000\u0000{|\u0003\u0014"+
		"\n\u0000|}\u0005#\u0000\u0000}\r\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"\u0017\u0000\u0000\u007f\u0080\u0003\u0002\u0001\u0000\u0080\u0081\u0005"+
		"\u0013\u0000\u0000\u0081\u0082\u0005\u0016\u0000\u0000\u0082\u0086\u0003"+
		"\u0014\n\u0000\u0083\u0085\u0003\u0010\b\u0000\u0084\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u008d\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u0019"+
		"\u0000\u0000\u008a\u008b\u0005\u0013\u0000\u0000\u008b\u008c\u0005\u0016"+
		"\u0000\u0000\u008c\u008e\u0003\u0014\n\u0000\u008d\u0089\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005#\u0000\u0000\u0090\u000f\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005\u0018\u0000\u0000\u0092\u0093\u0003\u0002\u0001\u0000"+
		"\u0093\u0094\u0005\u0013\u0000\u0000\u0094\u0095\u0005\u0016\u0000\u0000"+
		"\u0095\u0096\u0003\u0014\n\u0000\u0096\u0011\u0001\u0000\u0000\u0000\u0097"+
		"\u009d\u0003\u0004\u0002\u0000\u0098\u009d\u0003\b\u0004\u0000\u0099\u009d"+
		"\u0003\n\u0005\u0000\u009a\u009d\u0003\f\u0006\u0000\u009b\u009d\u0003"+
		"\u000e\u0007\u0000\u009c\u0097\u0001\u0000\u0000\u0000\u009c\u0098\u0001"+
		"\u0000\u0000\u0000\u009c\u0099\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u0013\u0001"+
		"\u0000\u0000\u0000\u009e\u00a1\u0003\u0012\t\u0000\u009f\u00a1\u0005\u0016"+
		"\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u009f\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u0015\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u001c"+
		"\u0000\u0000\u00a6\u00a7\u0005\"\u0000\u0000\u00a7\u00a9\u0005\u0010\u0000"+
		"\u0000\u00a8\u00aa\u0003\u001c\u000e\u0000\u00a9\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0005\u0014\u0000\u0000\u00ac\u00ae\u0003\u0014\n\u0000"+
		"\u00ad\u00af\u0003\u001e\u000f\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0005#\u0000\u0000\u00b1\u0017\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0005\u001b\u0000\u0000\u00b3\u00b4\u0005\"\u0000\u0000\u00b4\u00b6"+
		"\u0005\u0010\u0000\u0000\u00b5\u00b7\u0005\"\u0000\u0000\u00b6\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0005\u0014\u0000\u0000\u00b9\u00bd\u0005"+
		"\u0016\u0000\u0000\u00ba\u00bc\u0003\u001a\r\u0000\u00bb\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005#\u0000"+
		"\u0000\u00c1\u0019\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u001c\u0000"+
		"\u0000\u00c3\u00c4\u0005\"\u0000\u0000\u00c4\u00c5\u0005\u0010\u0000\u0000"+
		"\u00c5\u00c8\u0005\u001e\u0000\u0000\u00c6\u00c7\u0005\u000f\u0000\u0000"+
		"\u00c7\u00c9\u0003\u001c\u000e\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u0005\u0014\u0000\u0000\u00cb\u00cd\u0003\u0014\n\u0000\u00cc"+
		"\u00ce\u0003\u001e\u000f\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0005#\u0000\u0000\u00d0\u001b\u0001\u0000\u0000\u0000\u00d1\u00d6"+
		"\u0005\"\u0000\u0000\u00d2\u00d3\u0005\u000f\u0000\u0000\u00d3\u00d5\u0005"+
		"\"\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d7\u001d\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005\u001d\u0000\u0000\u00da\u00db\u0003\u0002"+
		"\u0001\u0000\u00db\u00dc\u0005\u0016\u0000\u0000\u00dc\u001f\u0001\u0000"+
		"\u0000\u0000\u00dd\u00e2\u0003\u0016\u000b\u0000\u00de\u00e2\u0003\u0018"+
		"\f\u0000\u00df\u00e2\u0003\u0012\t\u0000\u00e0\u00e2\u0005\u0016\u0000"+
		"\u0000\u00e1\u00dd\u0001\u0000\u0000\u0000\u00e1\u00de\u0001\u0000\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\u0000\u0000"+
		"\u0001\u00e7!\u0001\u0000\u0000\u0000\u0015)OQ[bhr\u0086\u008d\u009c\u00a0"+
		"\u00a2\u00a9\u00ae\u00b6\u00bd\u00c8\u00cd\u00d6\u00e1\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}