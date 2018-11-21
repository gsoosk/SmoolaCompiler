// Generated from /Users/farzad/Desktop/PLC/Projects/Phase 2/Smoola/Smoola.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmoolaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, CONST_NUM=41, CONST_STR=42, NL=43, ID=44, COMMENT=45, 
		WS=46;
	public static final int
		RULE_program = 0, RULE_mainClass = 1, RULE_classDeclaration = 2, RULE_varDeclaration = 3, 
		RULE_methodDeclaration = 4, RULE_statements = 5, RULE_statement = 6, RULE_statementBlock = 7, 
		RULE_statementCondition = 8, RULE_statementLoop = 9, RULE_statementWrite = 10, 
		RULE_statementAssignment = 11, RULE_expression = 12, RULE_expressionAssignment = 13, 
		RULE_expressionOr = 14, RULE_expressionOrTemp = 15, RULE_expressionAnd = 16, 
		RULE_expressionAndTemp = 17, RULE_expressionEq = 18, RULE_expressionEqTemp = 19, 
		RULE_expressionCmp = 20, RULE_expressionCmpTemp = 21, RULE_expressionAdd = 22, 
		RULE_expressionAddTemp = 23, RULE_expressionMult = 24, RULE_expressionMultTemp = 25, 
		RULE_expressionUnary = 26, RULE_expressionMem = 27, RULE_expressionMemTemp = 28, 
		RULE_expressionMethods = 29, RULE_expressionMethodsTemp = 30, RULE_expressionOther = 31, 
		RULE_type = 32;
	public static final String[] ruleNames = {
		"program", "mainClass", "classDeclaration", "varDeclaration", "methodDeclaration", 
		"statements", "statement", "statementBlock", "statementCondition", "statementLoop", 
		"statementWrite", "statementAssignment", "expression", "expressionAssignment", 
		"expressionOr", "expressionOrTemp", "expressionAnd", "expressionAndTemp", 
		"expressionEq", "expressionEqTemp", "expressionCmp", "expressionCmpTemp", 
		"expressionAdd", "expressionAddTemp", "expressionMult", "expressionMultTemp", 
		"expressionUnary", "expressionMem", "expressionMemTemp", "expressionMethods", 
		"expressionMethodsTemp", "expressionOther", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'def'", "'('", "')'", "':'", "'int'", "'return'", 
		"';'", "'}'", "'extends'", "'var'", "','", "'if'", "'then'", "'else'", 
		"'while'", "'writeln('", "'='", "'||'", "'&&'", "'=='", "'<>'", "'<'", 
		"'>'", "'+'", "'-'", "'*'", "'/'", "'!'", "'['", "']'", "'.'", "'length'", 
		"'new '", "'this'", "'true'", "'false'", "'boolean'", "'string'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "CONST_NUM", "CONST_STR", "NL", "ID", "COMMENT", 
		"WS"
	};
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
	public String getGrammarFileName() { return "Smoola.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    

	public SmoolaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SmoolaParser.EOF, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			mainClass();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(67);
				classDeclaration();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
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

	public static class MainClassContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__0);
			setState(76);
			match(ID);
			setState(77);
			match(T__1);
			setState(78);
			match(T__2);
			setState(79);
			match(ID);
			setState(80);
			match(T__3);
			setState(81);
			match(T__4);
			setState(82);
			match(T__5);
			setState(83);
			match(T__6);
			setState(84);
			match(T__1);
			setState(85);
			statements();
			setState(86);
			match(T__7);
			setState(87);
			expression();
			setState(88);
			match(T__8);
			setState(89);
			match(T__9);
			setState(90);
			match(T__9);
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__0);
			setState(93);
			match(ID);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(94);
				match(T__10);
				setState(95);
				match(ID);
				}
			}

			setState(98);
			match(T__1);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(99);
				varDeclaration();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(105);
				methodDeclaration();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			match(T__9);
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__11);
			setState(114);
			match(ID);
			setState(115);
			match(T__5);
			setState(116);
			type();
			setState(117);
			match(T__8);
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__2);
			setState(120);
			match(ID);
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(121);
				match(T__3);
				setState(122);
				match(T__4);
				}
				break;
			case 2:
				{
				{
				setState(123);
				match(T__3);
				setState(124);
				match(ID);
				setState(125);
				match(T__5);
				setState(126);
				type();
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(127);
					match(T__12);
					setState(128);
					match(ID);
					setState(129);
					match(T__5);
					setState(130);
					type();
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				match(T__4);
				}
				}
				break;
			}
			setState(140);
			match(T__5);
			setState(141);
			type();
			setState(142);
			match(T__1);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(143);
				varDeclaration();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
			statements();
			setState(150);
			match(T__7);
			setState(151);
			expression();
			setState(152);
			match(T__8);
			setState(153);
			match(T__9);
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << CONST_NUM) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				{
				setState(155);
				statement();
				}
				}
				setState(160);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public StatementConditionContext statementCondition() {
			return getRuleContext(StatementConditionContext.class,0);
		}
		public StatementLoopContext statementLoop() {
			return getRuleContext(StatementLoopContext.class,0);
		}
		public StatementWriteContext statementWrite() {
			return getRuleContext(StatementWriteContext.class,0);
		}
		public StatementAssignmentContext statementAssignment() {
			return getRuleContext(StatementAssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				statementBlock();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				statementCondition();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				statementLoop();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(164);
				statementWrite();
				}
				break;
			case T__3:
			case T__26:
			case T__29:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				statementAssignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StatementBlockContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statementBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__1);
			setState(169);
			statements();
			setState(170);
			match(T__9);
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

	public static class StatementConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementCondition; }
	}

	public final StatementConditionContext statementCondition() throws RecognitionException {
		StatementConditionContext _localctx = new StatementConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statementCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__13);
			setState(173);
			match(T__3);
			setState(174);
			expression();
			setState(175);
			match(T__4);
			setState(176);
			match(T__14);
			setState(177);
			statement();
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(178);
				match(T__15);
				setState(179);
				statement();
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

	public static class StatementLoopContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementLoop; }
	}

	public final StatementLoopContext statementLoop() throws RecognitionException {
		StatementLoopContext _localctx = new StatementLoopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statementLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__16);
			setState(183);
			match(T__3);
			setState(184);
			expression();
			setState(185);
			match(T__4);
			setState(186);
			statement();
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

	public static class StatementWriteContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWrite; }
	}

	public final StatementWriteContext statementWrite() throws RecognitionException {
		StatementWriteContext _localctx = new StatementWriteContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statementWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__17);
			setState(189);
			expression();
			setState(190);
			match(T__4);
			setState(191);
			match(T__8);
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

	public static class StatementAssignmentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementAssignment; }
	}

	public final StatementAssignmentContext statementAssignment() throws RecognitionException {
		StatementAssignmentContext _localctx = new StatementAssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statementAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			expression();
			setState(194);
			match(T__8);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			expressionAssignment();
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

	public static class ExpressionAssignmentContext extends ParserRuleContext {
		public ExpressionOrContext expressionOr() {
			return getRuleContext(ExpressionOrContext.class,0);
		}
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAssignment; }
	}

	public final ExpressionAssignmentContext expressionAssignment() throws RecognitionException {
		ExpressionAssignmentContext _localctx = new ExpressionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionAssignment);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				expressionOr();
				setState(199);
				match(T__18);
				setState(200);
				expressionAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				expressionOr();
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

	public static class ExpressionOrContext extends ParserRuleContext {
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOr; }
	}

	public final ExpressionOrContext expressionOr() throws RecognitionException {
		ExpressionOrContext _localctx = new ExpressionOrContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			expressionAnd();
			setState(206);
			expressionOrTemp();
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

	public static class ExpressionOrTempContext extends ParserRuleContext {
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOrTemp; }
	}

	public final ExpressionOrTempContext expressionOrTemp() throws RecognitionException {
		ExpressionOrTempContext _localctx = new ExpressionOrTempContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressionOrTemp);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				match(T__19);
				setState(209);
				expressionAnd();
				setState(210);
				expressionOrTemp();
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionAndContext extends ParserRuleContext {
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAnd; }
	}

	public final ExpressionAndContext expressionAnd() throws RecognitionException {
		ExpressionAndContext _localctx = new ExpressionAndContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressionAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			expressionEq();
			setState(216);
			expressionAndTemp();
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

	public static class ExpressionAndTempContext extends ParserRuleContext {
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAndTemp; }
	}

	public final ExpressionAndTempContext expressionAndTemp() throws RecognitionException {
		ExpressionAndTempContext _localctx = new ExpressionAndTempContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionAndTemp);
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				match(T__20);
				setState(219);
				expressionEq();
				setState(220);
				expressionAndTemp();
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionEqContext extends ParserRuleContext {
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEq; }
	}

	public final ExpressionEqContext expressionEq() throws RecognitionException {
		ExpressionEqContext _localctx = new ExpressionEqContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionEq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			expressionCmp();
			setState(226);
			expressionEqTemp();
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

	public static class ExpressionEqTempContext extends ParserRuleContext {
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEqTemp; }
	}

	public final ExpressionEqTempContext expressionEqTemp() throws RecognitionException {
		ExpressionEqTempContext _localctx = new ExpressionEqTempContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressionEqTemp);
		int _la;
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(229);
				expressionCmp();
				setState(230);
				expressionEqTemp();
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionCmpContext extends ParserRuleContext {
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionCmp; }
	}

	public final ExpressionCmpContext expressionCmp() throws RecognitionException {
		ExpressionCmpContext _localctx = new ExpressionCmpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expressionCmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			expressionAdd();
			setState(236);
			expressionCmpTemp();
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

	public static class ExpressionCmpTempContext extends ParserRuleContext {
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionCmpTemp; }
	}

	public final ExpressionCmpTempContext expressionCmpTemp() throws RecognitionException {
		ExpressionCmpTempContext _localctx = new ExpressionCmpTempContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expressionCmpTemp);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__24) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(239);
				expressionAdd();
				setState(240);
				expressionCmpTemp();
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionAddContext extends ParserRuleContext {
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAdd; }
	}

	public final ExpressionAddContext expressionAdd() throws RecognitionException {
		ExpressionAddContext _localctx = new ExpressionAddContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionAdd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			expressionMult();
			setState(246);
			expressionAddTemp();
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

	public static class ExpressionAddTempContext extends ParserRuleContext {
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAddTemp; }
	}

	public final ExpressionAddTempContext expressionAddTemp() throws RecognitionException {
		ExpressionAddTempContext _localctx = new ExpressionAddTempContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expressionAddTemp);
		int _la;
		try {
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(249);
				expressionMult();
				setState(250);
				expressionAddTemp();
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionMultContext extends ParserRuleContext {
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMult; }
	}

	public final ExpressionMultContext expressionMult() throws RecognitionException {
		ExpressionMultContext _localctx = new ExpressionMultContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressionMult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			expressionUnary();
			setState(256);
			expressionMultTemp();
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

	public static class ExpressionMultTempContext extends ParserRuleContext {
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMultTemp; }
	}

	public final ExpressionMultTempContext expressionMultTemp() throws RecognitionException {
		ExpressionMultTempContext _localctx = new ExpressionMultTempContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expressionMultTemp);
		int _la;
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(259);
				expressionUnary();
				setState(260);
				expressionMultTemp();
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionUnaryContext extends ParserRuleContext {
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMemContext expressionMem() {
			return getRuleContext(ExpressionMemContext.class,0);
		}
		public ExpressionUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionUnary; }
	}

	public final ExpressionUnaryContext expressionUnary() throws RecognitionException {
		ExpressionUnaryContext _localctx = new ExpressionUnaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionUnary);
		int _la;
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__29) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(266);
				expressionUnary();
				}
				break;
			case T__3:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				expressionMem();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionMemContext extends ParserRuleContext {
		public ExpressionMethodsContext expressionMethods() {
			return getRuleContext(ExpressionMethodsContext.class,0);
		}
		public ExpressionMemTempContext expressionMemTemp() {
			return getRuleContext(ExpressionMemTempContext.class,0);
		}
		public ExpressionMemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMem; }
	}

	public final ExpressionMemContext expressionMem() throws RecognitionException {
		ExpressionMemContext _localctx = new ExpressionMemContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressionMem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			expressionMethods();
			setState(271);
			expressionMemTemp();
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

	public static class ExpressionMemTempContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionMemTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMemTemp; }
	}

	public final ExpressionMemTempContext expressionMemTemp() throws RecognitionException {
		ExpressionMemTempContext _localctx = new ExpressionMemTempContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expressionMemTemp);
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				match(T__30);
				setState(274);
				expression();
				setState(275);
				match(T__31);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionMethodsContext extends ParserRuleContext {
		public ExpressionOtherContext expressionOther() {
			return getRuleContext(ExpressionOtherContext.class,0);
		}
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public ExpressionMethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMethods; }
	}

	public final ExpressionMethodsContext expressionMethods() throws RecognitionException {
		ExpressionMethodsContext _localctx = new ExpressionMethodsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expressionMethods);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			expressionOther();
			setState(281);
			expressionMethodsTemp();
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

	public static class ExpressionMethodsTempContext extends ParserRuleContext {
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMethodsTemp; }
	}

	public final ExpressionMethodsTempContext expressionMethodsTemp() throws RecognitionException {
		ExpressionMethodsTempContext _localctx = new ExpressionMethodsTempContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expressionMethodsTemp);
		int _la;
		try {
			setState(304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				match(T__32);
				setState(300);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(284);
					match(ID);
					setState(285);
					match(T__3);
					setState(286);
					match(T__4);
					}
					break;
				case 2:
					{
					setState(287);
					match(ID);
					setState(288);
					match(T__3);
					{
					setState(289);
					expression();
					setState(294);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__12) {
						{
						{
						setState(290);
						match(T__12);
						setState(291);
						expression();
						}
						}
						setState(296);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(297);
					match(T__4);
					}
					break;
				case 3:
					{
					setState(299);
					match(T__33);
					}
					break;
				}
				setState(302);
				expressionMethodsTemp();
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionOtherContext extends ParserRuleContext {
		public TerminalNode CONST_NUM() { return getToken(SmoolaParser.CONST_NUM, 0); }
		public TerminalNode CONST_STR() { return getToken(SmoolaParser.CONST_STR, 0); }
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionOtherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOther; }
	}

	public final ExpressionOtherContext expressionOther() throws RecognitionException {
		ExpressionOtherContext _localctx = new ExpressionOtherContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expressionOther);
		try {
			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				match(CONST_NUM);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(CONST_STR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(308);
				match(T__34);
				setState(309);
				match(T__6);
				setState(310);
				match(T__30);
				setState(311);
				match(CONST_NUM);
				setState(312);
				match(T__31);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(313);
				match(T__34);
				setState(314);
				match(ID);
				setState(315);
				match(T__3);
				setState(316);
				match(T__4);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(317);
				match(T__35);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(318);
				match(T__36);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(319);
				match(T__37);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(320);
				match(ID);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(321);
				match(ID);
				setState(322);
				match(T__30);
				setState(323);
				expression();
				setState(324);
				match(T__31);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(326);
				match(T__3);
				setState(327);
				expression();
				setState(328);
				match(T__4);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_type);
		try {
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				match(T__38);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				match(T__39);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(335);
				match(T__6);
				setState(336);
				match(T__30);
				setState(337);
				match(T__31);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(338);
				match(ID);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u0158\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\7\2G\n\2\f\2\16\2J\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4"+
		"c\n\4\3\4\3\4\7\4g\n\4\f\4\16\4j\13\4\3\4\7\4m\n\4\f\4\16\4p\13\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6\u0086\n\6\f\6\16\6\u0089\13\6\3\6\3\6\5\6\u008d\n\6\3\6\3\6"+
		"\3\6\3\6\7\6\u0093\n\6\f\6\16\6\u0096\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\7\7\u009f\n\7\f\7\16\7\u00a2\13\7\3\b\3\b\3\b\3\b\3\b\5\b\u00a9\n\b\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b7\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\5\17\u00ce\n\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u00d8\n\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u00e2"+
		"\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\5\25\u00ec\n\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u00f6\n\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0100\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\5\33\u010a\n\33\3\34\3\34\3\34\5\34\u010f\n\34\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\5\36\u0119\n\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \7 \u0127\n \f \16 \u012a\13 \3 \3 \3 \5 \u012f\n \3 \3 \5 \u0133"+
		"\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\5!\u014d\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0156\n\"\3\"\2\2#"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\7"+
		"\3\2\30\31\3\2\32\33\3\2\34\35\3\2\36\37\4\2\35\35  \2\u015d\2D\3\2\2"+
		"\2\4M\3\2\2\2\6^\3\2\2\2\bs\3\2\2\2\ny\3\2\2\2\f\u00a0\3\2\2\2\16\u00a8"+
		"\3\2\2\2\20\u00aa\3\2\2\2\22\u00ae\3\2\2\2\24\u00b8\3\2\2\2\26\u00be\3"+
		"\2\2\2\30\u00c3\3\2\2\2\32\u00c6\3\2\2\2\34\u00cd\3\2\2\2\36\u00cf\3\2"+
		"\2\2 \u00d7\3\2\2\2\"\u00d9\3\2\2\2$\u00e1\3\2\2\2&\u00e3\3\2\2\2(\u00eb"+
		"\3\2\2\2*\u00ed\3\2\2\2,\u00f5\3\2\2\2.\u00f7\3\2\2\2\60\u00ff\3\2\2\2"+
		"\62\u0101\3\2\2\2\64\u0109\3\2\2\2\66\u010e\3\2\2\28\u0110\3\2\2\2:\u0118"+
		"\3\2\2\2<\u011a\3\2\2\2>\u0132\3\2\2\2@\u014c\3\2\2\2B\u0155\3\2\2\2D"+
		"H\5\4\3\2EG\5\6\4\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2"+
		"JH\3\2\2\2KL\7\2\2\3L\3\3\2\2\2MN\7\3\2\2NO\7.\2\2OP\7\4\2\2PQ\7\5\2\2"+
		"QR\7.\2\2RS\7\6\2\2ST\7\7\2\2TU\7\b\2\2UV\7\t\2\2VW\7\4\2\2WX\5\f\7\2"+
		"XY\7\n\2\2YZ\5\32\16\2Z[\7\13\2\2[\\\7\f\2\2\\]\7\f\2\2]\5\3\2\2\2^_\7"+
		"\3\2\2_b\7.\2\2`a\7\r\2\2ac\7.\2\2b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2dh\7\4"+
		"\2\2eg\5\b\5\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2in\3\2\2\2jh\3\2"+
		"\2\2km\5\n\6\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2"+
		"\2\2qr\7\f\2\2r\7\3\2\2\2st\7\16\2\2tu\7.\2\2uv\7\b\2\2vw\5B\"\2wx\7\13"+
		"\2\2x\t\3\2\2\2yz\7\5\2\2z\u008c\7.\2\2{|\7\6\2\2|\u008d\7\7\2\2}~\7\6"+
		"\2\2~\177\7.\2\2\177\u0080\7\b\2\2\u0080\u0087\5B\"\2\u0081\u0082\7\17"+
		"\2\2\u0082\u0083\7.\2\2\u0083\u0084\7\b\2\2\u0084\u0086\5B\"\2\u0085\u0081"+
		"\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\7\2\2\u008b\u008d\3\2"+
		"\2\2\u008c{\3\2\2\2\u008c}\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\b"+
		"\2\2\u008f\u0090\5B\"\2\u0090\u0094\7\4\2\2\u0091\u0093\5\b\5\2\u0092"+
		"\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\5\f\7\2\u0098"+
		"\u0099\7\n\2\2\u0099\u009a\5\32\16\2\u009a\u009b\7\13\2\2\u009b\u009c"+
		"\7\f\2\2\u009c\13\3\2\2\2\u009d\u009f\5\16\b\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\r\3\2\2\2"+
		"\u00a2\u00a0\3\2\2\2\u00a3\u00a9\5\20\t\2\u00a4\u00a9\5\22\n\2\u00a5\u00a9"+
		"\5\24\13\2\u00a6\u00a9\5\26\f\2\u00a7\u00a9\5\30\r\2\u00a8\u00a3\3\2\2"+
		"\2\u00a8\u00a4\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7"+
		"\3\2\2\2\u00a9\17\3\2\2\2\u00aa\u00ab\7\4\2\2\u00ab\u00ac\5\f\7\2\u00ac"+
		"\u00ad\7\f\2\2\u00ad\21\3\2\2\2\u00ae\u00af\7\20\2\2\u00af\u00b0\7\6\2"+
		"\2\u00b0\u00b1\5\32\16\2\u00b1\u00b2\7\7\2\2\u00b2\u00b3\7\21\2\2\u00b3"+
		"\u00b6\5\16\b\2\u00b4\u00b5\7\22\2\2\u00b5\u00b7\5\16\b\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\23\3\2\2\2\u00b8\u00b9\7\23\2\2\u00b9"+
		"\u00ba\7\6\2\2\u00ba\u00bb\5\32\16\2\u00bb\u00bc\7\7\2\2\u00bc\u00bd\5"+
		"\16\b\2\u00bd\25\3\2\2\2\u00be\u00bf\7\24\2\2\u00bf\u00c0\5\32\16\2\u00c0"+
		"\u00c1\7\7\2\2\u00c1\u00c2\7\13\2\2\u00c2\27\3\2\2\2\u00c3\u00c4\5\32"+
		"\16\2\u00c4\u00c5\7\13\2\2\u00c5\31\3\2\2\2\u00c6\u00c7\5\34\17\2\u00c7"+
		"\33\3\2\2\2\u00c8\u00c9\5\36\20\2\u00c9\u00ca\7\25\2\2\u00ca\u00cb\5\34"+
		"\17\2\u00cb\u00ce\3\2\2\2\u00cc\u00ce\5\36\20\2\u00cd\u00c8\3\2\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\35\3\2\2\2\u00cf\u00d0\5\"\22\2\u00d0\u00d1\5 \21"+
		"\2\u00d1\37\3\2\2\2\u00d2\u00d3\7\26\2\2\u00d3\u00d4\5\"\22\2\u00d4\u00d5"+
		"\5 \21\2\u00d5\u00d8\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8!\3\2\2\2\u00d9\u00da\5&\24\2\u00da\u00db\5$\23\2"+
		"\u00db#\3\2\2\2\u00dc\u00dd\7\27\2\2\u00dd\u00de\5&\24\2\u00de\u00df\5"+
		"$\23\2\u00df\u00e2\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e1"+
		"\u00e0\3\2\2\2\u00e2%\3\2\2\2\u00e3\u00e4\5*\26\2\u00e4\u00e5\5(\25\2"+
		"\u00e5\'\3\2\2\2\u00e6\u00e7\t\2\2\2\u00e7\u00e8\5*\26\2\u00e8\u00e9\5"+
		"(\25\2\u00e9\u00ec\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e6\3\2\2\2\u00eb"+
		"\u00ea\3\2\2\2\u00ec)\3\2\2\2\u00ed\u00ee\5.\30\2\u00ee\u00ef\5,\27\2"+
		"\u00ef+\3\2\2\2\u00f0\u00f1\t\3\2\2\u00f1\u00f2\5.\30\2\u00f2\u00f3\5"+
		",\27\2\u00f3\u00f6\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f0\3\2\2\2\u00f5"+
		"\u00f4\3\2\2\2\u00f6-\3\2\2\2\u00f7\u00f8\5\62\32\2\u00f8\u00f9\5\60\31"+
		"\2\u00f9/\3\2\2\2\u00fa\u00fb\t\4\2\2\u00fb\u00fc\5\62\32\2\u00fc\u00fd"+
		"\5\60\31\2\u00fd\u0100\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fa\3\2\2\2"+
		"\u00ff\u00fe\3\2\2\2\u0100\61\3\2\2\2\u0101\u0102\5\66\34\2\u0102\u0103"+
		"\5\64\33\2\u0103\63\3\2\2\2\u0104\u0105\t\5\2\2\u0105\u0106\5\66\34\2"+
		"\u0106\u0107\5\64\33\2\u0107\u010a\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0104"+
		"\3\2\2\2\u0109\u0108\3\2\2\2\u010a\65\3\2\2\2\u010b\u010c\t\6\2\2\u010c"+
		"\u010f\5\66\34\2\u010d\u010f\58\35\2\u010e\u010b\3\2\2\2\u010e\u010d\3"+
		"\2\2\2\u010f\67\3\2\2\2\u0110\u0111\5<\37\2\u0111\u0112\5:\36\2\u0112"+
		"9\3\2\2\2\u0113\u0114\7!\2\2\u0114\u0115\5\32\16\2\u0115\u0116\7\"\2\2"+
		"\u0116\u0119\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0113\3\2\2\2\u0118\u0117"+
		"\3\2\2\2\u0119;\3\2\2\2\u011a\u011b\5@!\2\u011b\u011c\5> \2\u011c=\3\2"+
		"\2\2\u011d\u012e\7#\2\2\u011e\u011f\7.\2\2\u011f\u0120\7\6\2\2\u0120\u012f"+
		"\7\7\2\2\u0121\u0122\7.\2\2\u0122\u0123\7\6\2\2\u0123\u0128\5\32\16\2"+
		"\u0124\u0125\7\17\2\2\u0125\u0127\5\32\16\2\u0126\u0124\3\2\2\2\u0127"+
		"\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\3\2"+
		"\2\2\u012a\u0128\3\2\2\2\u012b\u012c\7\7\2\2\u012c\u012f\3\2\2\2\u012d"+
		"\u012f\7$\2\2\u012e\u011e\3\2\2\2\u012e\u0121\3\2\2\2\u012e\u012d\3\2"+
		"\2\2\u012f\u0130\3\2\2\2\u0130\u0133\5> \2\u0131\u0133\3\2\2\2\u0132\u011d"+
		"\3\2\2\2\u0132\u0131\3\2\2\2\u0133?\3\2\2\2\u0134\u014d\7+\2\2\u0135\u014d"+
		"\7,\2\2\u0136\u0137\7%\2\2\u0137\u0138\7\t\2\2\u0138\u0139\7!\2\2\u0139"+
		"\u013a\7+\2\2\u013a\u014d\7\"\2\2\u013b\u013c\7%\2\2\u013c\u013d\7.\2"+
		"\2\u013d\u013e\7\6\2\2\u013e\u014d\7\7\2\2\u013f\u014d\7&\2\2\u0140\u014d"+
		"\7\'\2\2\u0141\u014d\7(\2\2\u0142\u014d\7.\2\2\u0143\u0144\7.\2\2\u0144"+
		"\u0145\7!\2\2\u0145\u0146\5\32\16\2\u0146\u0147\7\"\2\2\u0147\u014d\3"+
		"\2\2\2\u0148\u0149\7\6\2\2\u0149\u014a\5\32\16\2\u014a\u014b\7\7\2\2\u014b"+
		"\u014d\3\2\2\2\u014c\u0134\3\2\2\2\u014c\u0135\3\2\2\2\u014c\u0136\3\2"+
		"\2\2\u014c\u013b\3\2\2\2\u014c\u013f\3\2\2\2\u014c\u0140\3\2\2\2\u014c"+
		"\u0141\3\2\2\2\u014c\u0142\3\2\2\2\u014c\u0143\3\2\2\2\u014c\u0148\3\2"+
		"\2\2\u014dA\3\2\2\2\u014e\u0156\7\t\2\2\u014f\u0156\7)\2\2\u0150\u0156"+
		"\7*\2\2\u0151\u0152\7\t\2\2\u0152\u0153\7!\2\2\u0153\u0156\7\"\2\2\u0154"+
		"\u0156\7.\2\2\u0155\u014e\3\2\2\2\u0155\u014f\3\2\2\2\u0155\u0150\3\2"+
		"\2\2\u0155\u0151\3\2\2\2\u0155\u0154\3\2\2\2\u0156C\3\2\2\2\32Hbhn\u0087"+
		"\u008c\u0094\u00a0\u00a8\u00b6\u00cd\u00d7\u00e1\u00eb\u00f5\u00ff\u0109"+
		"\u010e\u0118\u0128\u012e\u0132\u014c\u0155";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}