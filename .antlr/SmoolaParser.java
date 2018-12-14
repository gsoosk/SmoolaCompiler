// Generated from /Users/thesoli/Desktop/Courses/Fall97/PL/Projects/Phase3/Smoola/Smoola.g4 by ANTLR 4.7.1

import main.Tools.AstMaker;
import main.ast.node.*;
import main.ast.*;
import main.ast.node.expression.*;
import main.ast.node.expression.Value.*;
import main.ast.node.statement.*;
import main.ast.node.declaration.*;
import main.ast.Type.*;
import main.ast.Type.ArrayType.*;
import main.ast.Type.PrimitiveType.*;
import main.ast.Type.UserDefinedType.*;
import main.ast.node.expression.BinaryExpression.BinaryOperator;
import main.ast.node.expression.UnaryExpression.UnaryOperator;

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
		public MainClassContext main;
		public ClassDeclarationContext classDec;
		public TerminalNode EOF() { return getToken(SmoolaParser.EOF, 0); }
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
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
			((ProgramContext)_localctx).main = mainClass();

			            Program program = new Program();
			            program.setMainClass(((ProgramContext)_localctx).main.synMainClass);
			        
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(68);
				((ProgramContext)_localctx).classDec = classDeclaration();
				program.addClass(((ProgramContext)_localctx).classDec.synClassDeclaration);
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(EOF);

			            Visitor visitor = new VisitorImpl();
			            visitor.visit(program);
			        
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
		public ClassDeclaration synMainClass;
		public Token mainClassName;
		public Token mainMethodName;
		public StatementsContext allStatements;
		public ExpressionContext mainVal;
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
			setState(79);
			match(T__0);
			setState(80);
			((MainClassContext)_localctx).mainClassName = match(ID);
			setState(81);
			match(T__1);
			setState(82);
			match(T__2);
			setState(83);
			((MainClassContext)_localctx).mainMethodName = match(ID);
			setState(84);
			match(T__3);
			setState(85);
			match(T__4);
			setState(86);
			match(T__5);
			setState(87);
			match(T__6);
			setState(88);
			match(T__1);
			setState(89);
			((MainClassContext)_localctx).allStatements = statements();
			setState(90);
			match(T__7);
			setState(91);
			((MainClassContext)_localctx).mainVal = expression();
			setState(92);
			match(T__8);
			setState(93);
			match(T__9);
			setState(94);
			match(T__9);

			            ((MainClassContext)_localctx).synMainClass =  AstMaker.mainClass((((MainClassContext)_localctx).mainClassName!=null?((MainClassContext)_localctx).mainClassName.getText():null), (((MainClassContext)_localctx).mainMethodName!=null?((MainClassContext)_localctx).mainMethodName.getText():null), ((MainClassContext)_localctx).mainVal.synExpression, ((MainClassContext)_localctx).allStatements.synStatements);
			            _localctx.synMainClass.setLineNumber(((MainClassContext)_localctx).mainClassName.getLine());
			        
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
		public ClassDeclaration synClassDeclaration;
		public Token name;
		public Token parentName;
		public VarDeclarationContext varDec;
		public MethodDeclarationContext methodDec;
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
			setState(97);
			match(T__0);
			setState(98);
			((ClassDeclarationContext)_localctx).name = match(ID);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(99);
				match(T__10);
				setState(100);
				((ClassDeclarationContext)_localctx).parentName = match(ID);
				}
			}


			           ((ClassDeclarationContext)_localctx).synClassDeclaration =  AstMaker.classDeclaration((((ClassDeclarationContext)_localctx).name!=null?((ClassDeclarationContext)_localctx).name.getText():null), (((ClassDeclarationContext)_localctx).parentName!=null?((ClassDeclarationContext)_localctx).parentName.getText():null));
			           _localctx.synClassDeclaration.setLineNumber(((ClassDeclarationContext)_localctx).name.getLine());
			        
			setState(104);
			match(T__1);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(105);
				((ClassDeclarationContext)_localctx).varDec = varDeclaration();
				_localctx.synClassDeclaration.addVarDeclaration(((ClassDeclarationContext)_localctx).varDec.synVarDec);
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(113);
				((ClassDeclarationContext)_localctx).methodDec = methodDeclaration();
				_localctx.synClassDeclaration.addMethodDeclaration(((ClassDeclarationContext)_localctx).methodDec.synMethodDeclaration);
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
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
		public VarDeclaration synVarDec;
		public Token var;
		public Token varName;
		public TypeContext varType;
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
			setState(123);
			((VarDeclarationContext)_localctx).var = match(T__11);
			setState(124);
			((VarDeclarationContext)_localctx).varName = match(ID);
			setState(125);
			match(T__5);
			setState(126);
			((VarDeclarationContext)_localctx).varType = type();
			setState(127);
			match(T__8);

			            ((VarDeclarationContext)_localctx).synVarDec =  AstMaker.varDeclaration(new Identifier((((VarDeclarationContext)_localctx).varName!=null?((VarDeclarationContext)_localctx).varName.getText():null)), ((VarDeclarationContext)_localctx).varType.synType);
			            _localctx.synVarDec.setLineNumber(((VarDeclarationContext)_localctx).var.getLine());
			        
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
		public MethodDeclaration synMethodDeclaration;
		public Token methodName;
		public Token arg1Id;
		public TypeContext arg1Type;
		public Token argId;
		public TypeContext argType;
		public TypeContext returnType;
		public VarDeclarationContext newVar;
		public StatementsContext allStatements;
		public ExpressionContext returnVal;
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
			setState(130);
			match(T__2);
			setState(131);
			((MethodDeclarationContext)_localctx).methodName = match(ID);


			            ((MethodDeclarationContext)_localctx).synMethodDeclaration =  new MethodDeclaration(new Identifier((((MethodDeclarationContext)_localctx).methodName!=null?((MethodDeclarationContext)_localctx).methodName.getText():null)));
			            _localctx.synMethodDeclaration.setLineNumber(((MethodDeclarationContext)_localctx).methodName.getLine());
			        
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(133);
				match(T__3);
				setState(134);
				match(T__4);
				}
				break;
			case 2:
				{
				{
				setState(135);
				match(T__3);
				setState(136);
				((MethodDeclarationContext)_localctx).arg1Id = match(ID);
				setState(137);
				match(T__5);
				setState(138);
				((MethodDeclarationContext)_localctx).arg1Type = type();

				            VarDeclaration newVarDeclaration = new VarDeclaration(new Identifier((((MethodDeclarationContext)_localctx).arg1Id!=null?((MethodDeclarationContext)_localctx).arg1Id.getText():null)), ((MethodDeclarationContext)_localctx).arg1Type.synType);
				            newVarDeclaration.setLineNumber(((MethodDeclarationContext)_localctx).arg1Id.getLine());
				            _localctx.synMethodDeclaration.addArg(newVarDeclaration);
				        
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(140);
					match(T__12);
					setState(141);
					((MethodDeclarationContext)_localctx).argId = match(ID);
					setState(142);
					match(T__5);
					setState(143);
					((MethodDeclarationContext)_localctx).argType = type();

					            VarDeclaration newVarDeclaration1 = new VarDeclaration(new Identifier((((MethodDeclarationContext)_localctx).argId!=null?((MethodDeclarationContext)_localctx).argId.getText():null)), ((MethodDeclarationContext)_localctx).argType.synType);
					            newVarDeclaration1.setLineNumber(((MethodDeclarationContext)_localctx).argId.getLine());
					            _localctx.synMethodDeclaration.addArg(newVarDeclaration1);
					        
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
				match(T__4);
				}
				}
				break;
			}
			setState(155);
			match(T__5);
			setState(156);
			((MethodDeclarationContext)_localctx).returnType = type();

			            _localctx.synMethodDeclaration.setReturnType(((MethodDeclarationContext)_localctx).returnType.synType);
			        
			setState(158);
			match(T__1);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(159);
				((MethodDeclarationContext)_localctx).newVar = varDeclaration();

				            _localctx.synMethodDeclaration.addLocalVar(((MethodDeclarationContext)_localctx).newVar.synVarDec);
				        
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			((MethodDeclarationContext)_localctx).allStatements = statements();

			            _localctx.synMethodDeclaration.setBody(((MethodDeclarationContext)_localctx).allStatements.synStatements);
			        
			setState(169);
			match(T__7);
			setState(170);
			((MethodDeclarationContext)_localctx).returnVal = expression();

			            _localctx.synMethodDeclaration.setReturnValue(((MethodDeclarationContext)_localctx).returnVal.synExpression);
			        
			setState(172);
			match(T__8);
			setState(173);
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
		public ArrayList<Statement> synStatements;
		public StatementContext newStatement;
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

			            ((StatementsContext)_localctx).synStatements =  new ArrayList<>(); ;
			        
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << CONST_NUM) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				{
				setState(176);
				((StatementsContext)_localctx).newStatement = statement();


				            _localctx.synStatements.add(((StatementsContext)_localctx).newStatement.synStatement);
				        
				}
				}
				setState(183);
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
		public Statement synStatement;
		public StatementBlockContext stmB;
		public StatementConditionContext stmC;
		public StatementLoopContext stmL;
		public StatementWriteContext stmW;
		public StatementAssignmentContext stmA;
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
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				((StatementContext)_localctx).stmB = statementBlock();
				((StatementContext)_localctx).synStatement =  ((StatementContext)_localctx).stmB.synStatementBlock;
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				((StatementContext)_localctx).stmC = statementCondition();
				((StatementContext)_localctx).synStatement =  ((StatementContext)_localctx).stmC.synStatementCondition;
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				((StatementContext)_localctx).stmL = statementLoop();
				((StatementContext)_localctx).synStatement =  ((StatementContext)_localctx).stmL.synStatementLoop;
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				((StatementContext)_localctx).stmW = statementWrite();
				((StatementContext)_localctx).synStatement =  ((StatementContext)_localctx).stmW.synStatementWrite;
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
				setState(196);
				((StatementContext)_localctx).stmA = statementAssignment();
				((StatementContext)_localctx).synStatement =  ((StatementContext)_localctx).stmA.synStatementAssign;
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
		public Statement synStatementBlock;
		public StatementsContext allStatements;
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

			        Block block = new Block();
			    
			setState(202);
			match(T__1);
			setState(203);
			((StatementBlockContext)_localctx).allStatements = statements();

			        block.setBody(((StatementBlockContext)_localctx).allStatements.synStatements);
			        ((StatementBlockContext)_localctx).synStatementBlock =  block;
			    
			setState(205);
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
		public Statement synStatementCondition;
		public ExpressionContext conditionExp;
		public StatementContext consequenceBody;
		public StatementContext altBody;
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
			setState(207);
			match(T__13);
			setState(208);
			match(T__3);
			setState(209);
			((StatementConditionContext)_localctx).conditionExp = expression();
			setState(210);
			match(T__4);
			setState(211);
			match(T__14);
			setState(212);
			((StatementConditionContext)_localctx).consequenceBody = statement();

			            Conditional conditional = new Conditional(((StatementConditionContext)_localctx).conditionExp.synExpression, ((StatementConditionContext)_localctx).consequenceBody.synStatement);
			            ((StatementConditionContext)_localctx).synStatementCondition =  conditional;
			         
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(214);
				match(T__15);
				setState(215);
				((StatementConditionContext)_localctx).altBody = statement();

				            conditional.setAlternativeBody(((StatementConditionContext)_localctx).altBody.synStatement);
				            ((StatementConditionContext)_localctx).synStatementCondition =  conditional;
				         
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
		public Statement synStatementLoop;
		public ExpressionContext loopCondition;
		public StatementContext loopBody;
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
			setState(220);
			match(T__16);
			setState(221);
			match(T__3);
			setState(222);
			((StatementLoopContext)_localctx).loopCondition = expression();
			setState(223);
			match(T__4);
			setState(224);
			((StatementLoopContext)_localctx).loopBody = statement();

			            ((StatementLoopContext)_localctx).synStatementLoop =  new While(((StatementLoopContext)_localctx).loopCondition.synExpression, ((StatementLoopContext)_localctx).loopBody.synStatement);
			        
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
		public Statement synStatementWrite;
		public ExpressionContext arg;
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
			setState(227);
			match(T__17);
			setState(228);
			((StatementWriteContext)_localctx).arg = expression();
			setState(229);
			match(T__4);
			setState(230);
			match(T__8);

			            ((StatementWriteContext)_localctx).synStatementWrite =  new Write(((StatementWriteContext)_localctx).arg.synExpression);
			        
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
		public Statement synStatementAssign;
		public ExpressionContext expr;
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
			setState(233);
			((StatementAssignmentContext)_localctx).expr = expression();
			setState(234);
			match(T__8);

			            if(((StatementAssignmentContext)_localctx).expr.BinaryOp != null)
			            {
			                ((StatementAssignmentContext)_localctx).synStatementAssign =  new Assign(((BinaryExpression)((StatementAssignmentContext)_localctx).expr.synExpression).getLeft(), ((BinaryExpression)((StatementAssignmentContext)_localctx).expr.synExpression).getRight());
			            }
			            else
			            {
			                ((StatementAssignmentContext)_localctx).synStatementAssign =  new Statement();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression synExpression;
		public String BinaryOp;
		public ExpressionAssignmentContext expr;
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
			setState(237);
			((ExpressionContext)_localctx).expr = expressionAssignment();


			            ((ExpressionContext)_localctx).synExpression =  ((ExpressionContext)_localctx).expr.synExpression;
			            ((ExpressionContext)_localctx).BinaryOp =  ((ExpressionContext)_localctx).expr.BinaryOp;

			        
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
		public Expression synExpression;
		public String BinaryOp;
		public ExpressionOrContext lExpr;
		public Token val;
		public ExpressionAssignmentContext rExpr;
		public ExpressionOrContext expr;
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
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				((ExpressionAssignmentContext)_localctx).lExpr = expressionOr();
				setState(241);
				((ExpressionAssignmentContext)_localctx).val = match(T__18);
				setState(242);
				((ExpressionAssignmentContext)_localctx).rExpr = expressionAssignment();

				            ((ExpressionAssignmentContext)_localctx).BinaryOp =  "=";
				            ((ExpressionAssignmentContext)_localctx).synExpression =  new BinaryExpression(((ExpressionAssignmentContext)_localctx).lExpr.synExpression, ((ExpressionAssignmentContext)_localctx).rExpr.synExpression, BinaryOperator.assign);
				            _localctx.synExpression.setLineNumber(((ExpressionAssignmentContext)_localctx).val.getLine());

				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				((ExpressionAssignmentContext)_localctx).expr = expressionOr();

				            ((ExpressionAssignmentContext)_localctx).BinaryOp =  null;
				            ((ExpressionAssignmentContext)_localctx).synExpression =  ((ExpressionAssignmentContext)_localctx).expr.synExpression;
				        
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
		public Expression synExpression;
		public ExpressionAndContext lExpr;
		public ExpressionOrTempContext rExpr;
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
			setState(250);
			((ExpressionOrContext)_localctx).lExpr = expressionAnd();
			setState(251);
			((ExpressionOrContext)_localctx).rExpr = expressionOrTemp(((ExpressionOrContext)_localctx).lExpr.synExpression);

			           ((ExpressionOrContext)_localctx).synExpression =  ((ExpressionOrContext)_localctx).rExpr.synExpression;
			        
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
		public Expression inhExpression;
		public Expression synExpression;
		public Token val;
		public ExpressionAndContext lExpr;
		public ExpressionOrTempContext rExpr;
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionOrTempContext(ParserRuleContext parent, int invokingState, Expression inhExpression) {
			super(parent, invokingState);
			this.inhExpression = inhExpression;
		}
		@Override public int getRuleIndex() { return RULE_expressionOrTemp; }
	}

	public final ExpressionOrTempContext expressionOrTemp(Expression inhExpression) throws RecognitionException {
		ExpressionOrTempContext _localctx = new ExpressionOrTempContext(_ctx, getState(), inhExpression);
		enterRule(_localctx, 30, RULE_expressionOrTemp);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				((ExpressionOrTempContext)_localctx).val = match(T__19);
				setState(255);
				((ExpressionOrTempContext)_localctx).lExpr = expressionAnd();


				               Expression expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionOrTempContext)_localctx).lExpr.synExpression , BinaryOperator.or);
				               _localctx.synExpression.setLineNumber(((ExpressionOrTempContext)_localctx).val.getLine());
				        
				setState(257);
				((ExpressionOrTempContext)_localctx).rExpr = expressionOrTemp(expr);

				            ((ExpressionOrTempContext)_localctx).synExpression =  ((ExpressionOrTempContext)_localctx).rExpr.synExpression;
				        
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{

				            ((ExpressionOrTempContext)_localctx).synExpression =  _localctx.inhExpression;
				        
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
		public Expression synExpression;
		public ExpressionEqContext lExpr;
		public ExpressionAndTempContext rExpr;
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
			setState(263);
			((ExpressionAndContext)_localctx).lExpr = expressionEq();
			setState(264);
			((ExpressionAndContext)_localctx).rExpr = expressionAndTemp(((ExpressionAndContext)_localctx).lExpr.synExpression);

			           ((ExpressionAndContext)_localctx).synExpression =  ((ExpressionAndContext)_localctx).rExpr.synExpression;
			        
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
		public Expression inhExpression;
		public Expression synExpression;
		public Token val;
		public ExpressionEqContext lExpr;
		public ExpressionAndTempContext rExpr;
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionAndTempContext(ParserRuleContext parent, int invokingState, Expression inhExpression) {
			super(parent, invokingState);
			this.inhExpression = inhExpression;
		}
		@Override public int getRuleIndex() { return RULE_expressionAndTemp; }
	}

	public final ExpressionAndTempContext expressionAndTemp(Expression inhExpression) throws RecognitionException {
		ExpressionAndTempContext _localctx = new ExpressionAndTempContext(_ctx, getState(), inhExpression);
		enterRule(_localctx, 34, RULE_expressionAndTemp);
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				((ExpressionAndTempContext)_localctx).val = match(T__20);
				setState(268);
				((ExpressionAndTempContext)_localctx).lExpr = expressionEq();


				               Expression expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionAndTempContext)_localctx).lExpr.synExpression, BinaryOperator.and);
				               expr.setLineNumber(((ExpressionAndTempContext)_localctx).val.getLine());
				        
				setState(270);
				((ExpressionAndTempContext)_localctx).rExpr = expressionAndTemp(expr);


				            ((ExpressionAndTempContext)_localctx).synExpression =  ((ExpressionAndTempContext)_localctx).rExpr.synExpression;
				        
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

				            ((ExpressionAndTempContext)_localctx).synExpression =  _localctx.inhExpression;
				        
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
		public Expression synExpression;
		public ExpressionCmpContext lExpr;
		public ExpressionEqTempContext rExpr;
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
			setState(276);
			((ExpressionEqContext)_localctx).lExpr = expressionCmp();
			setState(277);
			((ExpressionEqContext)_localctx).rExpr = expressionEqTemp(((ExpressionEqContext)_localctx).lExpr.synExpression);

			           ((ExpressionEqContext)_localctx).synExpression =  ((ExpressionEqContext)_localctx).rExpr.synExpression;
			        
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
		public Expression inhExpression;
		public Expression synExpression;
		public Token binaryOp;
		public ExpressionCmpContext lExpr;
		public ExpressionEqTempContext rExpr;
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionEqTempContext(ParserRuleContext parent, int invokingState, Expression inhExpression) {
			super(parent, invokingState);
			this.inhExpression = inhExpression;
		}
		@Override public int getRuleIndex() { return RULE_expressionEqTemp; }
	}

	public final ExpressionEqTempContext expressionEqTemp(Expression inhExpression) throws RecognitionException {
		ExpressionEqTempContext _localctx = new ExpressionEqTempContext(_ctx, getState(), inhExpression);
		enterRule(_localctx, 38, RULE_expressionEqTemp);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				((ExpressionEqTempContext)_localctx).binaryOp = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
					((ExpressionEqTempContext)_localctx).binaryOp = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(281);
				((ExpressionEqTempContext)_localctx).lExpr = expressionCmp();

				            Expression expr;
				             if((((ExpressionEqTempContext)_localctx).binaryOp!=null?((ExpressionEqTempContext)_localctx).binaryOp.getText():null).equals("=="))
				                expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionEqTempContext)_localctx).lExpr.synExpression, BinaryOperator.eq);
				            else
				                expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionEqTempContext)_localctx).lExpr.synExpression, BinaryOperator.neq);
				            expr.setLineNumber(((ExpressionEqTempContext)_localctx).binaryOp.getLine());
				        
				setState(283);
				((ExpressionEqTempContext)_localctx).rExpr = expressionEqTemp(expr);

				            ((ExpressionEqTempContext)_localctx).synExpression =  ((ExpressionEqTempContext)_localctx).rExpr.synExpression;
				        
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

				            ((ExpressionEqTempContext)_localctx).synExpression =  _localctx.inhExpression;
				        
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
		public Expression synExpression;
		public ExpressionAddContext lExpr;
		public ExpressionCmpTempContext rExpr;
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
			setState(289);
			((ExpressionCmpContext)_localctx).lExpr = expressionAdd();
			setState(290);
			((ExpressionCmpContext)_localctx).rExpr = expressionCmpTemp(((ExpressionCmpContext)_localctx).lExpr.synExpression);

			           ((ExpressionCmpContext)_localctx).synExpression =  ((ExpressionCmpContext)_localctx).rExpr.synExpression;
			        
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
		public Expression inhExpression;
		public Expression synExpression;
		public Token binaryOp;
		public ExpressionAddContext lExpr;
		public ExpressionCmpTempContext rExpr;
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionCmpTempContext(ParserRuleContext parent, int invokingState, Expression inhExpression) {
			super(parent, invokingState);
			this.inhExpression = inhExpression;
		}
		@Override public int getRuleIndex() { return RULE_expressionCmpTemp; }
	}

	public final ExpressionCmpTempContext expressionCmpTemp(Expression inhExpression) throws RecognitionException {
		ExpressionCmpTempContext _localctx = new ExpressionCmpTempContext(_ctx, getState(), inhExpression);
		enterRule(_localctx, 42, RULE_expressionCmpTemp);
		int _la;
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				((ExpressionCmpTempContext)_localctx).binaryOp = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__24) ) {
					((ExpressionCmpTempContext)_localctx).binaryOp = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(294);
				((ExpressionCmpTempContext)_localctx).lExpr = expressionAdd();

				            Expression expr;
				            if((((ExpressionCmpTempContext)_localctx).binaryOp!=null?((ExpressionCmpTempContext)_localctx).binaryOp.getText():null).equals("<"))
				                expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionCmpTempContext)_localctx).lExpr.synExpression, BinaryOperator.lt);
				            else
				                expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionCmpTempContext)_localctx).lExpr.synExpression, BinaryOperator.gt);
				            expr.setLineNumber(((ExpressionCmpTempContext)_localctx).binaryOp.getLine());
				        
				setState(296);
				((ExpressionCmpTempContext)_localctx).rExpr = expressionCmpTemp(expr);

				            ((ExpressionCmpTempContext)_localctx).synExpression =  ((ExpressionCmpTempContext)_localctx).rExpr.synExpression;

				        
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

				            ((ExpressionCmpTempContext)_localctx).synExpression =  _localctx.inhExpression;
				        
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
		public Expression synExpression;
		public ExpressionMultContext lExpr;
		public ExpressionAddTempContext rExpr;
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
			setState(302);
			((ExpressionAddContext)_localctx).lExpr = expressionMult();
			setState(303);
			((ExpressionAddContext)_localctx).rExpr = expressionAddTemp(((ExpressionAddContext)_localctx).lExpr.synExpression);

			            ((ExpressionAddContext)_localctx).synExpression =  ((ExpressionAddContext)_localctx).rExpr.synExpression;
			        
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
		public Expression inhExpression;
		public Expression synExpression;
		public Token binaryOp;
		public ExpressionMultContext lExpr;
		public ExpressionAddTempContext rExpr;
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionAddTempContext(ParserRuleContext parent, int invokingState, Expression inhExpression) {
			super(parent, invokingState);
			this.inhExpression = inhExpression;
		}
		@Override public int getRuleIndex() { return RULE_expressionAddTemp; }
	}

	public final ExpressionAddTempContext expressionAddTemp(Expression inhExpression) throws RecognitionException {
		ExpressionAddTempContext _localctx = new ExpressionAddTempContext(_ctx, getState(), inhExpression);
		enterRule(_localctx, 46, RULE_expressionAddTemp);
		int _la;
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				((ExpressionAddTempContext)_localctx).binaryOp = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
					((ExpressionAddTempContext)_localctx).binaryOp = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(307);
				((ExpressionAddTempContext)_localctx).lExpr = expressionMult();

				            Expression expr;
				            if((((ExpressionAddTempContext)_localctx).binaryOp!=null?((ExpressionAddTempContext)_localctx).binaryOp.getText():null).equals("+"))
				                expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionAddTempContext)_localctx).lExpr.synExpression, BinaryOperator.add);
				            else
				                expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionAddTempContext)_localctx).lExpr.synExpression, BinaryOperator.sub);
				            expr.setLineNumber(((ExpressionAddTempContext)_localctx).binaryOp.getLine());
				        
				setState(309);
				((ExpressionAddTempContext)_localctx).rExpr = expressionAddTemp(expr);

				            ((ExpressionAddTempContext)_localctx).synExpression =  ((ExpressionAddTempContext)_localctx).rExpr.synExpression;

				        
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

				            ((ExpressionAddTempContext)_localctx).synExpression =  _localctx.inhExpression;
				        
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
		public Expression synExpression;
		public ExpressionUnaryContext lExpr;
		public ExpressionMultTempContext rExpr;
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
			setState(315);
			((ExpressionMultContext)_localctx).lExpr = expressionUnary();
			setState(316);
			((ExpressionMultContext)_localctx).rExpr = expressionMultTemp(((ExpressionMultContext)_localctx).lExpr.synExpression);

			            ((ExpressionMultContext)_localctx).synExpression =  ((ExpressionMultContext)_localctx).rExpr.synExpression;
			        
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
		public Expression inhExpression;
		public Expression synExpression;
		public Token binaryOp;
		public ExpressionUnaryContext lExpr;
		public ExpressionMultTempContext rExpr;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionMultTempContext(ParserRuleContext parent, int invokingState, Expression inhExpression) {
			super(parent, invokingState);
			this.inhExpression = inhExpression;
		}
		@Override public int getRuleIndex() { return RULE_expressionMultTemp; }
	}

	public final ExpressionMultTempContext expressionMultTemp(Expression inhExpression) throws RecognitionException {
		ExpressionMultTempContext _localctx = new ExpressionMultTempContext(_ctx, getState(), inhExpression);
		enterRule(_localctx, 50, RULE_expressionMultTemp);
		int _la;
		try {
			setState(326);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				((ExpressionMultTempContext)_localctx).binaryOp = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
					((ExpressionMultTempContext)_localctx).binaryOp = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(320);
				((ExpressionMultTempContext)_localctx).lExpr = expressionUnary();

				            Expression expr;
				            if((((ExpressionMultTempContext)_localctx).binaryOp!=null?((ExpressionMultTempContext)_localctx).binaryOp.getText():null).equals("*"))
				                expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionMultTempContext)_localctx).lExpr.synExpression, BinaryOperator.mult);
				            else
				                 expr = new BinaryExpression(_localctx.inhExpression, ((ExpressionMultTempContext)_localctx).lExpr.synExpression, BinaryOperator.div);
				            expr.setLineNumber(((ExpressionMultTempContext)_localctx).binaryOp.getLine());
				        
				setState(322);
				((ExpressionMultTempContext)_localctx).rExpr = expressionMultTemp(expr);

				            ((ExpressionMultTempContext)_localctx).synExpression =  ((ExpressionMultTempContext)_localctx).rExpr.synExpression;
				        
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

				            ((ExpressionMultTempContext)_localctx).synExpression =  _localctx.inhExpression;
				        
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
		public Expression synExpression;
		public Token val;
		public ExpressionUnaryContext uExpr1;
		public ExpressionUnaryContext uExpr2;
		public ExpressionMemContext expr;
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
		try {
			setState(339);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				((ExpressionUnaryContext)_localctx).val = match(T__29);
				setState(329);
				((ExpressionUnaryContext)_localctx).uExpr1 = expressionUnary();

				            ((ExpressionUnaryContext)_localctx).synExpression =  new UnaryExpression(UnaryOperator.not, ((ExpressionUnaryContext)_localctx).uExpr1.synExpression);
				            _localctx.synExpression.setLineNumber(((ExpressionUnaryContext)_localctx).val.getLine());
				        
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				((ExpressionUnaryContext)_localctx).val = match(T__26);
				setState(333);
				((ExpressionUnaryContext)_localctx).uExpr2 = expressionUnary();

				            ((ExpressionUnaryContext)_localctx).synExpression =  new UnaryExpression(UnaryOperator.minus, ((ExpressionUnaryContext)_localctx).uExpr2.synExpression);
				            _localctx.synExpression.setLineNumber(((ExpressionUnaryContext)_localctx).val.getLine());
				        
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
				enterOuterAlt(_localctx, 3);
				{
				setState(336);
				((ExpressionUnaryContext)_localctx).expr = expressionMem();

				            ((ExpressionUnaryContext)_localctx).synExpression =  ((ExpressionUnaryContext)_localctx).expr.synExpression;
				        
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
		public Expression synExpression;
		public ExpressionMethodsContext instance;
		public ExpressionMemTempContext index;
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
			setState(341);
			((ExpressionMemContext)_localctx).instance = expressionMethods();
			setState(342);
			((ExpressionMemContext)_localctx).index = expressionMemTemp();

			            if(((ExpressionMemContext)_localctx).index.synExpression != null)
			            {
			                ((ExpressionMemContext)_localctx).synExpression =  new ArrayCall(((ExpressionMemContext)_localctx).instance.synExpression, ((ExpressionMemContext)_localctx).index.synExpression);
			            }
			            else
			                ((ExpressionMemContext)_localctx).synExpression =  ((ExpressionMemContext)_localctx).instance.synExpression;
			        
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
		public Expression synExpression;
		public ExpressionContext index;
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
			setState(351);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				match(T__30);
				setState(346);
				((ExpressionMemTempContext)_localctx).index = expression();
				setState(347);
				match(T__31);

				            ((ExpressionMemTempContext)_localctx).synExpression =  ((ExpressionMemTempContext)_localctx).index.synExpression;
				        
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

				            ((ExpressionMemTempContext)_localctx).synExpression =  null;
				        
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
		public Expression synExpression;
		public ExpressionOtherContext inhInstance;
		public ExpressionMethodsTempContext method;
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
			setState(353);
			((ExpressionMethodsContext)_localctx).inhInstance = expressionOther();
			setState(354);
			((ExpressionMethodsContext)_localctx).method = expressionMethodsTemp(((ExpressionMethodsContext)_localctx).inhInstance.synExpression);

			            if(((ExpressionMethodsContext)_localctx).method.synExpression != null)
			                ((ExpressionMethodsContext)_localctx).synExpression =  ((ExpressionMethodsContext)_localctx).method.synExpression;
			            else
			                ((ExpressionMethodsContext)_localctx).synExpression =  ((ExpressionMethodsContext)_localctx).inhInstance.synExpression;
			        
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
		public Expression inhExpression;
		public Expression synExpression;
		public Token methodName;
		public ExpressionContext arg1;
		public ExpressionContext arg;
		public ExpressionMethodsTempContext expr;
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
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState, Expression inhExpression) {
			super(parent, invokingState);
			this.inhExpression = inhExpression;
		}
		@Override public int getRuleIndex() { return RULE_expressionMethodsTemp; }
	}

	public final ExpressionMethodsTempContext expressionMethodsTemp(Expression inhExpression) throws RecognitionException {
		ExpressionMethodsTempContext _localctx = new ExpressionMethodsTempContext(_ctx, getState(), inhExpression);
		enterRule(_localctx, 60, RULE_expressionMethodsTemp);
		int _la;
		try {
			setState(387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				match(T__32);

				            Expression method = null;
				        
				setState(380);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(359);
					((ExpressionMethodsTempContext)_localctx).methodName = match(ID);
					setState(360);
					match(T__3);
					setState(361);
					match(T__4);

					            method = new MethodCall(_localctx.inhExpression, new Identifier((((ExpressionMethodsTempContext)_localctx).methodName!=null?((ExpressionMethodsTempContext)_localctx).methodName.getText():null)));
					            method.setLineNumber(((ExpressionMethodsTempContext)_localctx).methodName.getLine());
					        
					}
					break;
				case 2:
					{
					setState(363);
					((ExpressionMethodsTempContext)_localctx).methodName = match(ID);
					setState(364);
					match(T__3);
					{
					setState(365);
					((ExpressionMethodsTempContext)_localctx).arg1 = expression();

					            method = new MethodCall(_localctx.inhExpression, new Identifier((((ExpressionMethodsTempContext)_localctx).methodName!=null?((ExpressionMethodsTempContext)_localctx).methodName.getText():null)));
					            ((MethodCall)method).addArg(((ExpressionMethodsTempContext)_localctx).arg1.synExpression);
					            method.setLineNumber(((ExpressionMethodsTempContext)_localctx).methodName.getLine());
					        
					setState(373);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__12) {
						{
						{
						setState(367);
						match(T__12);
						setState(368);
						((ExpressionMethodsTempContext)_localctx).arg = expression();
						((MethodCall)method).addArg(((ExpressionMethodsTempContext)_localctx).arg.synExpression);
						}
						}
						setState(375);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(376);
					match(T__4);
					}
					break;
				case 3:
					{
					setState(378);
					match(T__33);

					            method = new Length(_localctx.inhExpression);
					        
					}
					break;
				}

				            if(method == null) {
				                method = _localctx.inhExpression;
				            }
				        
				setState(383);
				((ExpressionMethodsTempContext)_localctx).expr = expressionMethodsTemp(method);

				            if(((ExpressionMethodsTempContext)_localctx).expr.synExpression != null)
				                ((ExpressionMethodsTempContext)_localctx).synExpression =  ((ExpressionMethodsTempContext)_localctx).expr.synExpression;
				            else
				                ((ExpressionMethodsTempContext)_localctx).synExpression =  method;
				        
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

				            ((ExpressionMethodsTempContext)_localctx).synExpression =  null;
				        
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
		public Expression synExpression;
		public Token val;
		public Token className;
		public ExpressionContext ex;
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
			setState(423);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				((ExpressionOtherContext)_localctx).val = match(CONST_NUM);
				((ExpressionOtherContext)_localctx).synExpression =  new IntValue((((ExpressionOtherContext)_localctx).val!=null?Integer.valueOf(((ExpressionOtherContext)_localctx).val.getText()):0), new IntType()); _localctx.synExpression.setLineNumber(((ExpressionOtherContext)_localctx).val.getLine());
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				((ExpressionOtherContext)_localctx).val = match(CONST_STR);
				((ExpressionOtherContext)_localctx).synExpression =  new StringValue((((ExpressionOtherContext)_localctx).val!=null?((ExpressionOtherContext)_localctx).val.getText():null), new StringType()); _localctx.synExpression.setLineNumber(((ExpressionOtherContext)_localctx).val.getLine());
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				match(T__34);
				setState(394);
				match(T__6);
				setState(395);
				match(T__30);
				setState(396);
				((ExpressionOtherContext)_localctx).val = match(CONST_NUM);
				setState(397);
				match(T__31);
				NewArray arr = new NewArray(); arr.setExpression(new IntValue((((ExpressionOtherContext)_localctx).val!=null?Integer.valueOf(((ExpressionOtherContext)_localctx).val.getText()):0), new IntType())); arr.setLineNumber(((ExpressionOtherContext)_localctx).val.getLine()); ((ExpressionOtherContext)_localctx).synExpression =  arr;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(399);
				match(T__34);
				setState(400);
				((ExpressionOtherContext)_localctx).className = match(ID);
				setState(401);
				match(T__3);
				setState(402);
				match(T__4);
				((ExpressionOtherContext)_localctx).synExpression =  new NewClass(new Identifier((((ExpressionOtherContext)_localctx).className!=null?((ExpressionOtherContext)_localctx).className.getText():null))); _localctx.synExpression.setLineNumber(((ExpressionOtherContext)_localctx).className.getLine());
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(404);
				match(T__35);
				((ExpressionOtherContext)_localctx).synExpression =  new This();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(406);
				match(T__36);
				((ExpressionOtherContext)_localctx).synExpression =  new BooleanValue(true, new BooleanType());
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(408);
				match(T__37);
				((ExpressionOtherContext)_localctx).synExpression =  new BooleanValue(false, new BooleanType());
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(410);
				((ExpressionOtherContext)_localctx).val = match(ID);
				((ExpressionOtherContext)_localctx).synExpression =  new Identifier((((ExpressionOtherContext)_localctx).val!=null?((ExpressionOtherContext)_localctx).val.getText():null)); _localctx.synExpression.setLineNumber(((ExpressionOtherContext)_localctx).val.getLine());
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(412);
				((ExpressionOtherContext)_localctx).val = match(ID);
				setState(413);
				match(T__30);
				setState(414);
				((ExpressionOtherContext)_localctx).ex = expression();
				setState(415);
				match(T__31);
				((ExpressionOtherContext)_localctx).synExpression =  new ArrayCall(new Identifier((((ExpressionOtherContext)_localctx).val!=null?((ExpressionOtherContext)_localctx).val.getText():null)), ((ExpressionOtherContext)_localctx).ex.synExpression); _localctx.synExpression.setLineNumber(((ExpressionOtherContext)_localctx).val.getLine());
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(418);
				match(T__3);
				setState(419);
				((ExpressionOtherContext)_localctx).ex = expression();
				setState(420);
				match(T__4);
				((ExpressionOtherContext)_localctx).synExpression =  ((ExpressionOtherContext)_localctx).ex.synExpression;
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
		public Type synType;
		public Token val;
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
			setState(437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(425);
				match(T__6);
				((TypeContext)_localctx).synType =  new IntType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(427);
				match(T__38);
				((TypeContext)_localctx).synType =  new BooleanType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(429);
				match(T__39);
				((TypeContext)_localctx).synType =  new StringType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(431);
				match(T__6);
				setState(432);
				match(T__30);
				setState(433);
				match(T__31);
				((TypeContext)_localctx).synType =  new ArrayType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(435);
				((TypeContext)_localctx).val = match(ID);
				((TypeContext)_localctx).synType =  new UserDefinedType(); ((UserDefinedType)_localctx.synType).setName(new Identifier((((TypeContext)_localctx).val!=null?((TypeContext)_localctx).val.getText():null)));
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u01ba\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\5\4h\n\4\3\4\3\4\3\4\3\4\3\4\7\4o\n\4\f\4\16\4r\13\4"+
		"\3\4\3\4\3\4\7\4w\n\4\f\4\16\4z\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"\u0095\n\6\f\6\16\6\u0098\13\6\3\6\3\6\5\6\u009c\n\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6\u00a5\n\6\f\6\16\6\u00a8\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\7\7\u00b6\n\7\f\7\16\7\u00b9\13\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ca\n\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00dd\n"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00fb"+
		"\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0108"+
		"\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0115"+
		"\n\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0122"+
		"\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u012f"+
		"\n\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u013c"+
		"\n\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0149"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0156"+
		"\n\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0162\n\36"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u0176"+
		"\n \f \16 \u0179\13 \3 \3 \3 \3 \5 \u017f\n \3 \3 \3 \3 \3 \5 \u0186\n"+
		" \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u01aa\n!\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01b8\n\"\3\"\2\2#\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\6\3\2\30\31\3\2\32\33\3\2"+
		"\34\35\3\2\36\37\2\u01c0\2D\3\2\2\2\4Q\3\2\2\2\6c\3\2\2\2\b}\3\2\2\2\n"+
		"\u0084\3\2\2\2\f\u00b1\3\2\2\2\16\u00c9\3\2\2\2\20\u00cb\3\2\2\2\22\u00d1"+
		"\3\2\2\2\24\u00de\3\2\2\2\26\u00e5\3\2\2\2\30\u00eb\3\2\2\2\32\u00ef\3"+
		"\2\2\2\34\u00fa\3\2\2\2\36\u00fc\3\2\2\2 \u0107\3\2\2\2\"\u0109\3\2\2"+
		"\2$\u0114\3\2\2\2&\u0116\3\2\2\2(\u0121\3\2\2\2*\u0123\3\2\2\2,\u012e"+
		"\3\2\2\2.\u0130\3\2\2\2\60\u013b\3\2\2\2\62\u013d\3\2\2\2\64\u0148\3\2"+
		"\2\2\66\u0155\3\2\2\28\u0157\3\2\2\2:\u0161\3\2\2\2<\u0163\3\2\2\2>\u0185"+
		"\3\2\2\2@\u01a9\3\2\2\2B\u01b7\3\2\2\2DE\5\4\3\2EK\b\2\1\2FG\5\6\4\2G"+
		"H\b\2\1\2HJ\3\2\2\2IF\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2"+
		"MK\3\2\2\2NO\7\2\2\3OP\b\2\1\2P\3\3\2\2\2QR\7\3\2\2RS\7.\2\2ST\7\4\2\2"+
		"TU\7\5\2\2UV\7.\2\2VW\7\6\2\2WX\7\7\2\2XY\7\b\2\2YZ\7\t\2\2Z[\7\4\2\2"+
		"[\\\5\f\7\2\\]\7\n\2\2]^\5\32\16\2^_\7\13\2\2_`\7\f\2\2`a\7\f\2\2ab\b"+
		"\3\1\2b\5\3\2\2\2cd\7\3\2\2dg\7.\2\2ef\7\r\2\2fh\7.\2\2ge\3\2\2\2gh\3"+
		"\2\2\2hi\3\2\2\2ij\b\4\1\2jp\7\4\2\2kl\5\b\5\2lm\b\4\1\2mo\3\2\2\2nk\3"+
		"\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qx\3\2\2\2rp\3\2\2\2st\5\n\6\2tu\b"+
		"\4\1\2uw\3\2\2\2vs\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3"+
		"\2\2\2{|\7\f\2\2|\7\3\2\2\2}~\7\16\2\2~\177\7.\2\2\177\u0080\7\b\2\2\u0080"+
		"\u0081\5B\"\2\u0081\u0082\7\13\2\2\u0082\u0083\b\5\1\2\u0083\t\3\2\2\2"+
		"\u0084\u0085\7\5\2\2\u0085\u0086\7.\2\2\u0086\u009b\b\6\1\2\u0087\u0088"+
		"\7\6\2\2\u0088\u009c\7\7\2\2\u0089\u008a\7\6\2\2\u008a\u008b\7.\2\2\u008b"+
		"\u008c\7\b\2\2\u008c\u008d\5B\"\2\u008d\u0096\b\6\1\2\u008e\u008f\7\17"+
		"\2\2\u008f\u0090\7.\2\2\u0090\u0091\7\b\2\2\u0091\u0092\5B\"\2\u0092\u0093"+
		"\b\6\1\2\u0093\u0095\3\2\2\2\u0094\u008e\3\2\2\2\u0095\u0098\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0099\u009a\7\7\2\2\u009a\u009c\3\2\2\2\u009b\u0087\3\2\2\2\u009b"+
		"\u0089\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7\b\2\2\u009e\u009f\5B"+
		"\"\2\u009f\u00a0\b\6\1\2\u00a0\u00a6\7\4\2\2\u00a1\u00a2\5\b\5\2\u00a2"+
		"\u00a3\b\6\1\2\u00a3\u00a5\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a5\u00a8\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00aa\5\f\7\2\u00aa\u00ab\b\6\1\2\u00ab\u00ac\7\n"+
		"\2\2\u00ac\u00ad\5\32\16\2\u00ad\u00ae\b\6\1\2\u00ae\u00af\7\13\2\2\u00af"+
		"\u00b0\7\f\2\2\u00b0\13\3\2\2\2\u00b1\u00b7\b\7\1\2\u00b2\u00b3\5\16\b"+
		"\2\u00b3\u00b4\b\7\1\2\u00b4\u00b6\3\2\2\2\u00b5\u00b2\3\2\2\2\u00b6\u00b9"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\r\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bb\5\20\t\2\u00bb\u00bc\b\b\1\2\u00bc\u00ca\3"+
		"\2\2\2\u00bd\u00be\5\22\n\2\u00be\u00bf\b\b\1\2\u00bf\u00ca\3\2\2\2\u00c0"+
		"\u00c1\5\24\13\2\u00c1\u00c2\b\b\1\2\u00c2\u00ca\3\2\2\2\u00c3\u00c4\5"+
		"\26\f\2\u00c4\u00c5\b\b\1\2\u00c5\u00ca\3\2\2\2\u00c6\u00c7\5\30\r\2\u00c7"+
		"\u00c8\b\b\1\2\u00c8\u00ca\3\2\2\2\u00c9\u00ba\3\2\2\2\u00c9\u00bd\3\2"+
		"\2\2\u00c9\u00c0\3\2\2\2\u00c9\u00c3\3\2\2\2\u00c9\u00c6\3\2\2\2\u00ca"+
		"\17\3\2\2\2\u00cb\u00cc\b\t\1\2\u00cc\u00cd\7\4\2\2\u00cd\u00ce\5\f\7"+
		"\2\u00ce\u00cf\b\t\1\2\u00cf\u00d0\7\f\2\2\u00d0\21\3\2\2\2\u00d1\u00d2"+
		"\7\20\2\2\u00d2\u00d3\7\6\2\2\u00d3\u00d4\5\32\16\2\u00d4\u00d5\7\7\2"+
		"\2\u00d5\u00d6\7\21\2\2\u00d6\u00d7\5\16\b\2\u00d7\u00dc\b\n\1\2\u00d8"+
		"\u00d9\7\22\2\2\u00d9\u00da\5\16\b\2\u00da\u00db\b\n\1\2\u00db\u00dd\3"+
		"\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\23\3\2\2\2\u00de"+
		"\u00df\7\23\2\2\u00df\u00e0\7\6\2\2\u00e0\u00e1\5\32\16\2\u00e1\u00e2"+
		"\7\7\2\2\u00e2\u00e3\5\16\b\2\u00e3\u00e4\b\13\1\2\u00e4\25\3\2\2\2\u00e5"+
		"\u00e6\7\24\2\2\u00e6\u00e7\5\32\16\2\u00e7\u00e8\7\7\2\2\u00e8\u00e9"+
		"\7\13\2\2\u00e9\u00ea\b\f\1\2\u00ea\27\3\2\2\2\u00eb\u00ec\5\32\16\2\u00ec"+
		"\u00ed\7\13\2\2\u00ed\u00ee\b\r\1\2\u00ee\31\3\2\2\2\u00ef\u00f0\5\34"+
		"\17\2\u00f0\u00f1\b\16\1\2\u00f1\33\3\2\2\2\u00f2\u00f3\5\36\20\2\u00f3"+
		"\u00f4\7\25\2\2\u00f4\u00f5\5\34\17\2\u00f5\u00f6\b\17\1\2\u00f6\u00fb"+
		"\3\2\2\2\u00f7\u00f8\5\36\20\2\u00f8\u00f9\b\17\1\2\u00f9\u00fb\3\2\2"+
		"\2\u00fa\u00f2\3\2\2\2\u00fa\u00f7\3\2\2\2\u00fb\35\3\2\2\2\u00fc\u00fd"+
		"\5\"\22\2\u00fd\u00fe\5 \21\2\u00fe\u00ff\b\20\1\2\u00ff\37\3\2\2\2\u0100"+
		"\u0101\7\26\2\2\u0101\u0102\5\"\22\2\u0102\u0103\b\21\1\2\u0103\u0104"+
		"\5 \21\2\u0104\u0105\b\21\1\2\u0105\u0108\3\2\2\2\u0106\u0108\b\21\1\2"+
		"\u0107\u0100\3\2\2\2\u0107\u0106\3\2\2\2\u0108!\3\2\2\2\u0109\u010a\5"+
		"&\24\2\u010a\u010b\5$\23\2\u010b\u010c\b\22\1\2\u010c#\3\2\2\2\u010d\u010e"+
		"\7\27\2\2\u010e\u010f\5&\24\2\u010f\u0110\b\23\1\2\u0110\u0111\5$\23\2"+
		"\u0111\u0112\b\23\1\2\u0112\u0115\3\2\2\2\u0113\u0115\b\23\1\2\u0114\u010d"+
		"\3\2\2\2\u0114\u0113\3\2\2\2\u0115%\3\2\2\2\u0116\u0117\5*\26\2\u0117"+
		"\u0118\5(\25\2\u0118\u0119\b\24\1\2\u0119\'\3\2\2\2\u011a\u011b\t\2\2"+
		"\2\u011b\u011c\5*\26\2\u011c\u011d\b\25\1\2\u011d\u011e\5(\25\2\u011e"+
		"\u011f\b\25\1\2\u011f\u0122\3\2\2\2\u0120\u0122\b\25\1\2\u0121\u011a\3"+
		"\2\2\2\u0121\u0120\3\2\2\2\u0122)\3\2\2\2\u0123\u0124\5.\30\2\u0124\u0125"+
		"\5,\27\2\u0125\u0126\b\26\1\2\u0126+\3\2\2\2\u0127\u0128\t\3\2\2\u0128"+
		"\u0129\5.\30\2\u0129\u012a\b\27\1\2\u012a\u012b\5,\27\2\u012b\u012c\b"+
		"\27\1\2\u012c\u012f\3\2\2\2\u012d\u012f\b\27\1\2\u012e\u0127\3\2\2\2\u012e"+
		"\u012d\3\2\2\2\u012f-\3\2\2\2\u0130\u0131\5\62\32\2\u0131\u0132\5\60\31"+
		"\2\u0132\u0133\b\30\1\2\u0133/\3\2\2\2\u0134\u0135\t\4\2\2\u0135\u0136"+
		"\5\62\32\2\u0136\u0137\b\31\1\2\u0137\u0138\5\60\31\2\u0138\u0139\b\31"+
		"\1\2\u0139\u013c\3\2\2\2\u013a\u013c\b\31\1\2\u013b\u0134\3\2\2\2\u013b"+
		"\u013a\3\2\2\2\u013c\61\3\2\2\2\u013d\u013e\5\66\34\2\u013e\u013f\5\64"+
		"\33\2\u013f\u0140\b\32\1\2\u0140\63\3\2\2\2\u0141\u0142\t\5\2\2\u0142"+
		"\u0143\5\66\34\2\u0143\u0144\b\33\1\2\u0144\u0145\5\64\33\2\u0145\u0146"+
		"\b\33\1\2\u0146\u0149\3\2\2\2\u0147\u0149\b\33\1\2\u0148\u0141\3\2\2\2"+
		"\u0148\u0147\3\2\2\2\u0149\65\3\2\2\2\u014a\u014b\7 \2\2\u014b\u014c\5"+
		"\66\34\2\u014c\u014d\b\34\1\2\u014d\u0156\3\2\2\2\u014e\u014f\7\35\2\2"+
		"\u014f\u0150\5\66\34\2\u0150\u0151\b\34\1\2\u0151\u0156\3\2\2\2\u0152"+
		"\u0153\58\35\2\u0153\u0154\b\34\1\2\u0154\u0156\3\2\2\2\u0155\u014a\3"+
		"\2\2\2\u0155\u014e\3\2\2\2\u0155\u0152\3\2\2\2\u0156\67\3\2\2\2\u0157"+
		"\u0158\5<\37\2\u0158\u0159\5:\36\2\u0159\u015a\b\35\1\2\u015a9\3\2\2\2"+
		"\u015b\u015c\7!\2\2\u015c\u015d\5\32\16\2\u015d\u015e\7\"\2\2\u015e\u015f"+
		"\b\36\1\2\u015f\u0162\3\2\2\2\u0160\u0162\b\36\1\2\u0161\u015b\3\2\2\2"+
		"\u0161\u0160\3\2\2\2\u0162;\3\2\2\2\u0163\u0164\5@!\2\u0164\u0165\5> "+
		"\2\u0165\u0166\b\37\1\2\u0166=\3\2\2\2\u0167\u0168\7#\2\2\u0168\u017e"+
		"\b \1\2\u0169\u016a\7.\2\2\u016a\u016b\7\6\2\2\u016b\u016c\7\7\2\2\u016c"+
		"\u017f\b \1\2\u016d\u016e\7.\2\2\u016e\u016f\7\6\2\2\u016f\u0170\5\32"+
		"\16\2\u0170\u0177\b \1\2\u0171\u0172\7\17\2\2\u0172\u0173\5\32\16\2\u0173"+
		"\u0174\b \1\2\u0174\u0176\3\2\2\2\u0175\u0171\3\2\2\2\u0176\u0179\3\2"+
		"\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017a\3\2\2\2\u0179"+
		"\u0177\3\2\2\2\u017a\u017b\7\7\2\2\u017b\u017f\3\2\2\2\u017c\u017d\7$"+
		"\2\2\u017d\u017f\b \1\2\u017e\u0169\3\2\2\2\u017e\u016d\3\2\2\2\u017e"+
		"\u017c\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\b \1\2\u0181\u0182\5> "+
		"\2\u0182\u0183\b \1\2\u0183\u0186\3\2\2\2\u0184\u0186\b \1\2\u0185\u0167"+
		"\3\2\2\2\u0185\u0184\3\2\2\2\u0186?\3\2\2\2\u0187\u0188\7+\2\2\u0188\u01aa"+
		"\b!\1\2\u0189\u018a\7,\2\2\u018a\u01aa\b!\1\2\u018b\u018c\7%\2\2\u018c"+
		"\u018d\7\t\2\2\u018d\u018e\7!\2\2\u018e\u018f\7+\2\2\u018f\u0190\7\"\2"+
		"\2\u0190\u01aa\b!\1\2\u0191\u0192\7%\2\2\u0192\u0193\7.\2\2\u0193\u0194"+
		"\7\6\2\2\u0194\u0195\7\7\2\2\u0195\u01aa\b!\1\2\u0196\u0197\7&\2\2\u0197"+
		"\u01aa\b!\1\2\u0198\u0199\7\'\2\2\u0199\u01aa\b!\1\2\u019a\u019b\7(\2"+
		"\2\u019b\u01aa\b!\1\2\u019c\u019d\7.\2\2\u019d\u01aa\b!\1\2\u019e\u019f"+
		"\7.\2\2\u019f\u01a0\7!\2\2\u01a0\u01a1\5\32\16\2\u01a1\u01a2\7\"\2\2\u01a2"+
		"\u01a3\b!\1\2\u01a3\u01aa\3\2\2\2\u01a4\u01a5\7\6\2\2\u01a5\u01a6\5\32"+
		"\16\2\u01a6\u01a7\7\7\2\2\u01a7\u01a8\b!\1\2\u01a8\u01aa\3\2\2\2\u01a9"+
		"\u0187\3\2\2\2\u01a9\u0189\3\2\2\2\u01a9\u018b\3\2\2\2\u01a9\u0191\3\2"+
		"\2\2\u01a9\u0196\3\2\2\2\u01a9\u0198\3\2\2\2\u01a9\u019a\3\2\2\2\u01a9"+
		"\u019c\3\2\2\2\u01a9\u019e\3\2\2\2\u01a9\u01a4\3\2\2\2\u01aaA\3\2\2\2"+
		"\u01ab\u01ac\7\t\2\2\u01ac\u01b8\b\"\1\2\u01ad\u01ae\7)\2\2\u01ae\u01b8"+
		"\b\"\1\2\u01af\u01b0\7*\2\2\u01b0\u01b8\b\"\1\2\u01b1\u01b2\7\t\2\2\u01b2"+
		"\u01b3\7!\2\2\u01b3\u01b4\7\"\2\2\u01b4\u01b8\b\"\1\2\u01b5\u01b6\7.\2"+
		"\2\u01b6\u01b8\b\"\1\2\u01b7\u01ab\3\2\2\2\u01b7\u01ad\3\2\2\2\u01b7\u01af"+
		"\3\2\2\2\u01b7\u01b1\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8C\3\2\2\2\32Kgp"+
		"x\u0096\u009b\u00a6\u00b7\u00c9\u00dc\u00fa\u0107\u0114\u0121\u012e\u013b"+
		"\u0148\u0155\u0161\u0177\u017e\u0185\u01a9\u01b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}