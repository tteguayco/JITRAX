package es.ull.etsii.jitrax.analysisRelationalAlgebra;

// Generated from RelationalAlgebra.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelationalAlgebraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, PROJECTION=12, SELECTION=13, UNION=14, DIFFERENCE=15, 
		CARTESIAN_PRODUCT=16, INTERSECTION=17, NATURAL_JOIN=18, JOIN=19, DIVISION=20, 
		RENAME=21, AS=22, EQUAL=23, NOT_EQUAL=24, GREATER_THAN=25, GREATER_EQUAL=26, 
		LESS_THAN=27, LESS_EQUAL=28, BOOLEAN_AND=29, BOOLEAN_OR=30, BOOLEAN_NOT=31, 
		IDENTIFIER=32, NUMBER=33, WHITESPACES=34;
	public static final int
		RULE_start = 0, RULE_inline_comment = 1, RULE_multiline_comment = 2, RULE_view = 3, 
		RULE_expr = 4, RULE_attrlist = 5, RULE_condlist = 6, RULE_comparator = 7, 
		RULE_compared = 8, RULE_relation = 9, RULE_attribute = 10, RULE_data = 11;
	public static final String[] ruleNames = {
		"start", "inline_comment", "multiline_comment", "view", "expr", "attrlist", 
		"condlist", "comparator", "compared", "relation", "attribute", "data"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'//'", "'/*'", "'*/'", "'='", "'('", "')'", "'['", "']'", 
		"','", "'NOT'", null, null, null, null, null, null, null, null, null, 
		null, "'AS'", null, null, "'>'", "'>='", "'<'", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"PROJECTION", "SELECTION", "UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", 
		"INTERSECTION", "NATURAL_JOIN", "JOIN", "DIVISION", "RENAME", "AS", "EQUAL", 
		"NOT_EQUAL", "GREATER_THAN", "GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", 
		"BOOLEAN_AND", "BOOLEAN_OR", "BOOLEAN_NOT", "IDENTIFIER", "NUMBER", "WHITESPACES"
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
	public String getGrammarFileName() { return "RelationalAlgebra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RelationalAlgebraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<Inline_commentContext> inline_comment() {
			return getRuleContexts(Inline_commentContext.class);
		}
		public Inline_commentContext inline_comment(int i) {
			return getRuleContext(Inline_commentContext.class,i);
		}
		public List<Multiline_commentContext> multiline_comment() {
			return getRuleContexts(Multiline_commentContext.class);
		}
		public Multiline_commentContext multiline_comment(int i) {
			return getRuleContext(Multiline_commentContext.class,i);
		}
		public List<ViewContext> view() {
			return getRuleContexts(ViewContext.class);
		}
		public ViewContext view(int i) {
			return getRuleContext(ViewContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(32);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(24);
					inline_comment();
					}
					break;
				case 2:
					{
					setState(25);
					multiline_comment();
					}
					break;
				case 3:
					{
					setState(26);
					view();
					setState(27);
					match(T__0);
					}
					break;
				case 4:
					{
					setState(29);
					expr(0);
					setState(30);
					match(T__0);
					}
					break;
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__5) | (1L << PROJECTION) | (1L << SELECTION) | (1L << RENAME) | (1L << IDENTIFIER))) != 0) );
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

	public static class Inline_commentContext extends ParserRuleContext {
		public Inline_commentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_comment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitInline_comment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inline_commentContext inline_comment() throws RecognitionException {
		Inline_commentContext _localctx = new Inline_commentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_inline_comment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__1);
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(37);
					matchWildcard();
					}
					} 
				}
				setState(42);
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
			exitRule();
		}
		return _localctx;
	}

	public static class Multiline_commentContext extends ParserRuleContext {
		public Multiline_commentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiline_comment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitMultiline_comment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiline_commentContext multiline_comment() throws RecognitionException {
		Multiline_commentContext _localctx = new Multiline_commentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multiline_comment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__2);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(44);
					matchWildcard();
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(50);
			match(T__3);
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

	public static class ViewContext extends ParserRuleContext {
		public ViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view; }
	 
		public ViewContext() { }
		public void copyFrom(ViewContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ViewAssignmentContext extends ViewContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ViewAssignmentContext(ViewContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitViewAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ViewContext view() throws RecognitionException {
		ViewContext _localctx = new ViewContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_view);
		try {
			_localctx = new ViewAssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(IDENTIFIER);
			setState(53);
			match(T__4);
			setState(54);
			expr(0);
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
	public static class RenameTableContext extends ExprContext {
		public TerminalNode RENAME() { return getToken(RelationalAlgebraParser.RENAME, 0); }
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode AS() { return getToken(RelationalAlgebraParser.AS, 0); }
		public RenameTableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRenameTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode UNION() { return getToken(RelationalAlgebraParser.UNION, 0); }
		public UnionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIVISION() { return getToken(RelationalAlgebraParser.DIVISION, 0); }
		public DivisionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameSchemaContext extends ExprContext {
		public TerminalNode RENAME() { return getToken(RelationalAlgebraParser.RENAME, 0); }
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public List<AttrlistContext> attrlist() {
			return getRuleContexts(AttrlistContext.class);
		}
		public AttrlistContext attrlist(int i) {
			return getRuleContext(AttrlistContext.class,i);
		}
		public TerminalNode AS() { return getToken(RelationalAlgebraParser.AS, 0); }
		public RenameSchemaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRenameSchema(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CartesianProductContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CARTESIAN_PRODUCT() { return getToken(RelationalAlgebraParser.CARTESIAN_PRODUCT, 0); }
		public CartesianProductContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitCartesianProduct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectionContext extends ExprContext {
		public TerminalNode SELECTION() { return getToken(RelationalAlgebraParser.SELECTION, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SelectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NaturalJoinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NATURAL_JOIN() { return getToken(RelationalAlgebraParser.NATURAL_JOIN, 0); }
		public NaturalJoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNaturalJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationFromExprContext extends ExprContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public RelationFromExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRelationFromExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntersectionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode INTERSECTION() { return getToken(RelationalAlgebraParser.INTERSECTION, 0); }
		public IntersectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitIntersection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DifferenceContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIFFERENCE() { return getToken(RelationalAlgebraParser.DIFFERENCE, 0); }
		public DifferenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProjectionContext extends ExprContext {
		public TerminalNode PROJECTION() { return getToken(RelationalAlgebraParser.PROJECTION, 0); }
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProjectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JoinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode JOIN() { return getToken(RelationalAlgebraParser.JOIN, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public JoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketsExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BracketsExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitBracketsExpr(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new RelationFromExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(57);
				relation();
				}
				break;
			case 2:
				{
				_localctx = new BracketsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				match(T__5);
				setState(59);
				expr(0);
				setState(60);
				match(T__6);
				}
				break;
			case 3:
				{
				_localctx = new ProjectionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(PROJECTION);
				setState(63);
				match(T__7);
				setState(64);
				attrlist();
				setState(65);
				match(T__8);
				setState(66);
				match(T__5);
				setState(67);
				expr(0);
				setState(68);
				match(T__6);
				}
				break;
			case 4:
				{
				_localctx = new SelectionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(SELECTION);
				setState(71);
				match(T__7);
				setState(72);
				condlist(0);
				setState(73);
				match(T__8);
				setState(74);
				match(T__5);
				setState(75);
				expr(0);
				setState(76);
				match(T__6);
				}
				break;
			case 5:
				{
				_localctx = new RenameTableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(RENAME);
				setState(79);
				relation();
				setState(80);
				match(AS);
				setState(81);
				relation();
				}
				break;
			case 6:
				{
				_localctx = new RenameSchemaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(RENAME);
				setState(84);
				relation();
				setState(85);
				match(T__5);
				setState(86);
				attrlist();
				setState(87);
				match(T__6);
				setState(88);
				match(AS);
				setState(89);
				relation();
				setState(90);
				match(T__5);
				setState(91);
				attrlist();
				setState(92);
				match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(121);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(97);
						match(UNION);
						setState(98);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new CartesianProductContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(100);
						match(CARTESIAN_PRODUCT);
						setState(101);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(102);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(103);
						match(DIFFERENCE);
						setState(104);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new NaturalJoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(106);
						match(NATURAL_JOIN);
						setState(107);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new IntersectionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(108);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(109);
						match(INTERSECTION);
						setState(110);
						expr(6);
						}
						break;
					case 6:
						{
						_localctx = new DivisionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(111);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(112);
						match(DIVISION);
						setState(113);
						expr(4);
						}
						break;
					case 7:
						{
						_localctx = new JoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(115);
						match(JOIN);
						setState(116);
						expr(0);
						setState(117);
						match(T__5);
						setState(118);
						condlist(0);
						setState(119);
						match(T__6);
						}
						break;
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class AttrlistContext extends ParserRuleContext {
		public AttrlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrlist; }
	 
		public AttrlistContext() { }
		public void copyFrom(AttrlistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttributeFromAttrlistContext extends AttrlistContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttributeFromAttrlistContext(AttrlistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeFromAttrlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeListContext extends AttrlistContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public AttributeListContext(AttrlistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrlistContext attrlist() throws RecognitionException {
		AttrlistContext _localctx = new AttrlistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attrlist);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AttributeFromAttrlistContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				attribute();
				}
				break;
			case 2:
				_localctx = new AttributeListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				attribute();
				setState(128);
				match(T__9);
				setState(129);
				attrlist();
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

	public static class CondlistContext extends ParserRuleContext {
		public CondlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condlist; }
	 
		public CondlistContext() { }
		public void copyFrom(CondlistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BracketsCondlistContext extends CondlistContext {
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public BracketsCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitBracketsCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotCondlistContext extends CondlistContext {
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public NotCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNotCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparedCondlistContext extends CondlistContext {
		public List<ComparedContext> compared() {
			return getRuleContexts(ComparedContext.class);
		}
		public ComparedContext compared(int i) {
			return getRuleContext(ComparedContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ComparedCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitComparedCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndCondlistContext extends CondlistContext {
		public List<CondlistContext> condlist() {
			return getRuleContexts(CondlistContext.class);
		}
		public CondlistContext condlist(int i) {
			return getRuleContext(CondlistContext.class,i);
		}
		public TerminalNode BOOLEAN_AND() { return getToken(RelationalAlgebraParser.BOOLEAN_AND, 0); }
		public AndCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAndCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrCondlistContext extends CondlistContext {
		public List<CondlistContext> condlist() {
			return getRuleContexts(CondlistContext.class);
		}
		public CondlistContext condlist(int i) {
			return getRuleContext(CondlistContext.class,i);
		}
		public TerminalNode BOOLEAN_OR() { return getToken(RelationalAlgebraParser.BOOLEAN_OR, 0); }
		public OrCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitOrCondlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondlistContext condlist() throws RecognitionException {
		return condlist(0);
	}

	private CondlistContext condlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondlistContext _localctx = new CondlistContext(_ctx, _parentState);
		CondlistContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_condlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				_localctx = new NotCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				match(T__10);
				setState(135);
				condlist(3);
				}
				break;
			case T__5:
				{
				_localctx = new BracketsCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(T__5);
				setState(137);
				condlist(0);
				setState(138);
				match(T__6);
				}
				break;
			case IDENTIFIER:
			case NUMBER:
				{
				_localctx = new ComparedCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				compared();
				setState(141);
				comparator();
				setState(142);
				compared();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(152);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new OrCondlistContext(new CondlistContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlist);
						setState(146);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(147);
						match(BOOLEAN_OR);
						setState(148);
						condlist(6);
						}
						break;
					case 2:
						{
						_localctx = new AndCondlistContext(new CondlistContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlist);
						setState(149);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(150);
						match(BOOLEAN_AND);
						setState(151);
						condlist(5);
						}
						break;
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(RelationalAlgebraParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(RelationalAlgebraParser.NOT_EQUAL, 0); }
		public TerminalNode GREATER_THAN() { return getToken(RelationalAlgebraParser.GREATER_THAN, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(RelationalAlgebraParser.GREATER_EQUAL, 0); }
		public TerminalNode LESS_THAN() { return getToken(RelationalAlgebraParser.LESS_THAN, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(RelationalAlgebraParser.LESS_EQUAL, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NOT_EQUAL) | (1L << GREATER_THAN) | (1L << GREATER_EQUAL) | (1L << LESS_THAN) | (1L << LESS_EQUAL))) != 0)) ) {
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

	public static class ComparedContext extends ParserRuleContext {
		public ComparedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compared; }
	 
		public ComparedContext() { }
		public void copyFrom(ComparedContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DataFromComparedContext extends ComparedContext {
		public TerminalNode NUMBER() { return getToken(RelationalAlgebraParser.NUMBER, 0); }
		public DataFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitDataFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeFromComparedContext extends ComparedContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttributeFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparedContext compared() throws RecognitionException {
		ComparedContext _localctx = new ComparedContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compared);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new AttributeFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				attribute();
				}
				break;
			case NUMBER:
				_localctx = new DataFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(NUMBER);
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

	public static class RelationContext extends ParserRuleContext {
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	 
		public RelationContext() { }
		public void copyFrom(RelationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelationIdentifierContext extends RelationContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public RelationIdentifierContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRelationIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relation);
		try {
			_localctx = new RelationIdentifierContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(IDENTIFIER);
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

	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttributeIdentifierContext extends AttributeContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public AttributeIdentifierContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attribute);
		try {
			_localctx = new AttributeIdentifierContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(IDENTIFIER);
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

	public static class DataContext extends ParserRuleContext {
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	 
		public DataContext() { }
		public void copyFrom(DataContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DataNumberContext extends DataContext {
		public TerminalNode NUMBER() { return getToken(RelationalAlgebraParser.NUMBER, 0); }
		public DataNumberContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitDataNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DataIdentifierContext extends DataContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public DataIdentifierContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitDataIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_data);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new DataNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				_localctx = new DataIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(IDENTIFIER);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 6:
			return condlist_sempred((CondlistContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean condlist_sempred(CondlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$\u00ae\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2#\n\2\r\2\16\2"+
		"$\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6a\n\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6|\n\6\f\6\16\6\177\13\6\3\7\3\7\3\7\3\7\3\7\5\7\u0086\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0093\n\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\7\b\u009b\n\b\f\b\16\b\u009e\13\b\3\t\3\t\3\n\3\n\5\n\u00a4"+
		"\n\n\3\13\3\13\3\f\3\f\3\r\3\r\5\r\u00ac\n\r\3\r\4*\61\4\n\16\16\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\2\3\3\2\31\36\u00ba\2\"\3\2\2\2\4&\3\2\2\2\6"+
		"-\3\2\2\2\b\66\3\2\2\2\n`\3\2\2\2\f\u0085\3\2\2\2\16\u0092\3\2\2\2\20"+
		"\u009f\3\2\2\2\22\u00a3\3\2\2\2\24\u00a5\3\2\2\2\26\u00a7\3\2\2\2\30\u00ab"+
		"\3\2\2\2\32#\5\4\3\2\33#\5\6\4\2\34\35\5\b\5\2\35\36\7\3\2\2\36#\3\2\2"+
		"\2\37 \5\n\6\2 !\7\3\2\2!#\3\2\2\2\"\32\3\2\2\2\"\33\3\2\2\2\"\34\3\2"+
		"\2\2\"\37\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\3\3\2\2\2&*\7\4\2\2"+
		"\')\13\2\2\2(\'\3\2\2\2),\3\2\2\2*+\3\2\2\2*(\3\2\2\2+\5\3\2\2\2,*\3\2"+
		"\2\2-\61\7\5\2\2.\60\13\2\2\2/.\3\2\2\2\60\63\3\2\2\2\61\62\3\2\2\2\61"+
		"/\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\6\2\2\65\7\3\2\2\2\66\67"+
		"\7\"\2\2\678\7\7\2\289\5\n\6\29\t\3\2\2\2:;\b\6\1\2;a\5\24\13\2<=\7\b"+
		"\2\2=>\5\n\6\2>?\7\t\2\2?a\3\2\2\2@A\7\16\2\2AB\7\n\2\2BC\5\f\7\2CD\7"+
		"\13\2\2DE\7\b\2\2EF\5\n\6\2FG\7\t\2\2Ga\3\2\2\2HI\7\17\2\2IJ\7\n\2\2J"+
		"K\5\16\b\2KL\7\13\2\2LM\7\b\2\2MN\5\n\6\2NO\7\t\2\2Oa\3\2\2\2PQ\7\27\2"+
		"\2QR\5\24\13\2RS\7\30\2\2ST\5\24\13\2Ta\3\2\2\2UV\7\27\2\2VW\5\24\13\2"+
		"WX\7\b\2\2XY\5\f\7\2YZ\7\t\2\2Z[\7\30\2\2[\\\5\24\13\2\\]\7\b\2\2]^\5"+
		"\f\7\2^_\7\t\2\2_a\3\2\2\2`:\3\2\2\2`<\3\2\2\2`@\3\2\2\2`H\3\2\2\2`P\3"+
		"\2\2\2`U\3\2\2\2a}\3\2\2\2bc\f\13\2\2cd\7\20\2\2d|\5\n\6\fef\f\n\2\2f"+
		"g\7\22\2\2g|\5\n\6\13hi\f\t\2\2ij\7\21\2\2j|\5\n\6\nkl\f\b\2\2lm\7\24"+
		"\2\2m|\5\n\6\tno\f\7\2\2op\7\23\2\2p|\5\n\6\bqr\f\5\2\2rs\7\26\2\2s|\5"+
		"\n\6\6tu\f\6\2\2uv\7\25\2\2vw\5\n\6\2wx\7\b\2\2xy\5\16\b\2yz\7\t\2\2z"+
		"|\3\2\2\2{b\3\2\2\2{e\3\2\2\2{h\3\2\2\2{k\3\2\2\2{n\3\2\2\2{q\3\2\2\2"+
		"{t\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\13\3\2\2\2\177}\3\2\2\2\u0080"+
		"\u0086\5\26\f\2\u0081\u0082\5\26\f\2\u0082\u0083\7\f\2\2\u0083\u0084\5"+
		"\f\7\2\u0084\u0086\3\2\2\2\u0085\u0080\3\2\2\2\u0085\u0081\3\2\2\2\u0086"+
		"\r\3\2\2\2\u0087\u0088\b\b\1\2\u0088\u0089\7\r\2\2\u0089\u0093\5\16\b"+
		"\5\u008a\u008b\7\b\2\2\u008b\u008c\5\16\b\2\u008c\u008d\7\t\2\2\u008d"+
		"\u0093\3\2\2\2\u008e\u008f\5\22\n\2\u008f\u0090\5\20\t\2\u0090\u0091\5"+
		"\22\n\2\u0091\u0093\3\2\2\2\u0092\u0087\3\2\2\2\u0092\u008a\3\2\2\2\u0092"+
		"\u008e\3\2\2\2\u0093\u009c\3\2\2\2\u0094\u0095\f\7\2\2\u0095\u0096\7 "+
		"\2\2\u0096\u009b\5\16\b\b\u0097\u0098\f\6\2\2\u0098\u0099\7\37\2\2\u0099"+
		"\u009b\5\16\b\7\u009a\u0094\3\2\2\2\u009a\u0097\3\2\2\2\u009b\u009e\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\17\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a0\t\2\2\2\u00a0\21\3\2\2\2\u00a1\u00a4\5\26\f"+
		"\2\u00a2\u00a4\7#\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\23"+
		"\3\2\2\2\u00a5\u00a6\7\"\2\2\u00a6\25\3\2\2\2\u00a7\u00a8\7\"\2\2\u00a8"+
		"\27\3\2\2\2\u00a9\u00ac\7#\2\2\u00aa\u00ac\7\"\2\2\u00ab\u00a9\3\2\2\2"+
		"\u00ab\u00aa\3\2\2\2\u00ac\31\3\2\2\2\17\"$*\61`{}\u0085\u0092\u009a\u009c"+
		"\u00a3\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}