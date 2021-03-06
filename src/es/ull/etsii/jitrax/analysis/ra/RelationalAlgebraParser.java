package es.ull.etsii.jitrax.analysis.ra;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PROJECTION=8, 
		SELECTION=9, UNION=10, DIFFERENCE=11, CARTESIAN_PRODUCT=12, INTERSECTION=13, 
		NATURAL_JOIN=14, JOIN=15, DIVISION=16, EQUAL=17, NOT_EQUAL=18, GREATER_THAN=19, 
		GREATER_EQUAL=20, LESS_THAN=21, LESS_EQUAL=22, BOOLEAN_AND=23, BOOLEAN_OR=24, 
		BOOLEAN_NOT=25, STRING=26, IDENTIFIER=27, NUMBER=28, WHITESPACES=29, COMMENT=30, 
		LINE_COMMENT=31;
	public static final int
		RULE_start = 0, RULE_view = 1, RULE_expr = 2, RULE_attrlist = 3, RULE_condlist = 4, 
		RULE_comparator = 5, RULE_compared = 6, RULE_relation = 7, RULE_attribute = 8;
	public static final String[] ruleNames = {
		"start", "view", "expr", "attrlist", "condlist", "comparator", "compared", 
		"relation", "attribute"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'['", "']'", "','", "'NOT'", null, null, null, 
		null, null, null, null, null, null, "'='", null, "'>'", "'>='", "'<'", 
		"'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "PROJECTION", "SELECTION", 
		"UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", "NATURAL_JOIN", 
		"JOIN", "DIVISION", "EQUAL", "NOT_EQUAL", "GREATER_THAN", "GREATER_EQUAL", 
		"LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", "BOOLEAN_OR", "BOOLEAN_NOT", 
		"STRING", "IDENTIFIER", "NUMBER", "WHITESPACES", "COMMENT", "LINE_COMMENT"
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RelationalAlgebraParser.EOF, 0); }
		public List<ViewContext> view() {
			return getRuleContexts(ViewContext.class);
		}
		public ViewContext view(int i) {
			return getRuleContext(ViewContext.class,i);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(18);
					view();
					setState(19);
					match(T__0);
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(26);
			expr(0);
			setState(27);
			match(T__0);
			setState(28);
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
		enterRule(_localctx, 2, RULE_view);
		try {
			_localctx = new ViewAssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(IDENTIFIER);
			setState(31);
			match(EQUAL);
			setState(32);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				_localctx = new RelationFromExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(35);
				relation();
				}
				break;
			case T__1:
				{
				_localctx = new BracketsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				match(T__1);
				setState(37);
				expr(0);
				setState(38);
				match(T__2);
				}
				break;
			case PROJECTION:
				{
				_localctx = new ProjectionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(PROJECTION);
				setState(41);
				match(T__3);
				setState(42);
				attrlist();
				setState(43);
				match(T__4);
				setState(44);
				match(T__1);
				setState(45);
				expr(0);
				setState(46);
				match(T__2);
				}
				break;
			case SELECTION:
				{
				_localctx = new SelectionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(SELECTION);
				setState(49);
				match(T__3);
				setState(50);
				condlist(0);
				setState(51);
				match(T__4);
				setState(52);
				match(T__1);
				setState(53);
				expr(0);
				setState(54);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(59);
						match(UNION);
						setState(60);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new CartesianProductContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(62);
						match(CARTESIAN_PRODUCT);
						setState(63);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(65);
						match(DIFFERENCE);
						setState(66);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new NaturalJoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(68);
						match(NATURAL_JOIN);
						setState(69);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new IntersectionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(71);
						match(INTERSECTION);
						setState(72);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new DivisionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(74);
						match(DIVISION);
						setState(75);
						expr(2);
						}
						break;
					case 7:
						{
						_localctx = new JoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(77);
						match(JOIN);
						setState(78);
						expr(0);
						setState(79);
						match(T__3);
						setState(80);
						condlist(0);
						setState(81);
						match(T__4);
						}
						break;
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		enterRule(_localctx, 6, RULE_attrlist);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AttributeFromAttrlistContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				attribute();
				}
				break;
			case 2:
				_localctx = new AttributeListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				attribute();
				setState(90);
				match(T__5);
				setState(91);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_condlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				_localctx = new NotCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(96);
				match(T__6);
				setState(97);
				condlist(3);
				}
				break;
			case T__1:
				{
				_localctx = new BracketsCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(T__1);
				setState(99);
				condlist(0);
				setState(100);
				match(T__2);
				}
				break;
			case STRING:
			case IDENTIFIER:
			case NUMBER:
				{
				_localctx = new ComparedCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				compared();
				setState(103);
				comparator();
				setState(104);
				compared();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new OrCondlistContext(new CondlistContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlist);
						setState(108);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(109);
						match(BOOLEAN_OR);
						setState(110);
						condlist(6);
						}
						break;
					case 2:
						{
						_localctx = new AndCondlistContext(new CondlistContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlist);
						setState(111);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(112);
						match(BOOLEAN_AND);
						setState(113);
						condlist(5);
						}
						break;
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
	 
		public ComparatorContext() { }
		public void copyFrom(ComparatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualContext extends ComparatorContext {
		public TerminalNode EQUAL() { return getToken(RelationalAlgebraParser.EQUAL, 0); }
		public EqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanContext extends ComparatorContext {
		public TerminalNode LESS_THAN() { return getToken(RelationalAlgebraParser.LESS_THAN, 0); }
		public LessThanContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterEqualContext extends ComparatorContext {
		public TerminalNode GREATER_EQUAL() { return getToken(RelationalAlgebraParser.GREATER_EQUAL, 0); }
		public GreaterEqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitGreaterEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessEqualContext extends ComparatorContext {
		public TerminalNode LESS_EQUAL() { return getToken(RelationalAlgebraParser.LESS_EQUAL, 0); }
		public LessEqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitLessEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NonEqualContext extends ComparatorContext {
		public TerminalNode NOT_EQUAL() { return getToken(RelationalAlgebraParser.NOT_EQUAL, 0); }
		public NonEqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNonEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanContext extends ComparatorContext {
		public TerminalNode GREATER_THAN() { return getToken(RelationalAlgebraParser.GREATER_THAN, 0); }
		public GreaterThanContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comparator);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUAL:
				_localctx = new EqualContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(EQUAL);
				}
				break;
			case NOT_EQUAL:
				_localctx = new NonEqualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(NOT_EQUAL);
				}
				break;
			case GREATER_THAN:
				_localctx = new GreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(GREATER_THAN);
				}
				break;
			case GREATER_EQUAL:
				_localctx = new GreaterEqualContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(GREATER_EQUAL);
				}
				break;
			case LESS_THAN:
				_localctx = new LessThanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
				match(LESS_THAN);
				}
				break;
			case LESS_EQUAL:
				_localctx = new LessEqualContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(124);
				match(LESS_EQUAL);
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
	public static class StringFromComparedContext extends ComparedContext {
		public TerminalNode STRING() { return getToken(RelationalAlgebraParser.STRING, 0); }
		public StringFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitStringFromCompared(this);
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
	public static class NumberFromComparedContext extends ComparedContext {
		public TerminalNode NUMBER() { return getToken(RelationalAlgebraParser.NUMBER, 0); }
		public NumberFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNumberFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparedContext compared() throws RecognitionException {
		ComparedContext _localctx = new ComparedContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compared);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new AttributeFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				attribute();
				}
				break;
			case STRING:
				_localctx = new StringFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
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
		enterRule(_localctx, 14, RULE_relation);
		try {
			_localctx = new RelationIdentifierContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
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
		enterRule(_localctx, 16, RULE_attribute);
		try {
			_localctx = new AttributeIdentifierContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 4:
			return condlist_sempred((CondlistContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 2);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u008b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4;\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4V\n\4\f\4\16\4"+
		"Y\13\4\3\5\3\5\3\5\3\5\3\5\5\5`\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6m\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6u\n\6\f\6\16\6x\13\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u0080\n\7\3\b\3\b\3\b\5\b\u0085\n\b\3\t\3\t"+
		"\3\n\3\n\3\n\2\4\6\n\13\2\4\6\b\n\f\16\20\22\2\2\u0098\2\31\3\2\2\2\4"+
		" \3\2\2\2\6:\3\2\2\2\b_\3\2\2\2\nl\3\2\2\2\f\177\3\2\2\2\16\u0084\3\2"+
		"\2\2\20\u0086\3\2\2\2\22\u0088\3\2\2\2\24\25\5\4\3\2\25\26\7\3\2\2\26"+
		"\30\3\2\2\2\27\24\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32"+
		"\34\3\2\2\2\33\31\3\2\2\2\34\35\5\6\4\2\35\36\7\3\2\2\36\37\7\2\2\3\37"+
		"\3\3\2\2\2 !\7\35\2\2!\"\7\23\2\2\"#\5\6\4\2#\5\3\2\2\2$%\b\4\1\2%;\5"+
		"\20\t\2&\'\7\4\2\2\'(\5\6\4\2()\7\5\2\2);\3\2\2\2*+\7\n\2\2+,\7\6\2\2"+
		",-\5\b\5\2-.\7\7\2\2./\7\4\2\2/\60\5\6\4\2\60\61\7\5\2\2\61;\3\2\2\2\62"+
		"\63\7\13\2\2\63\64\7\6\2\2\64\65\5\n\6\2\65\66\7\7\2\2\66\67\7\4\2\2\67"+
		"8\5\6\4\289\7\5\2\29;\3\2\2\2:$\3\2\2\2:&\3\2\2\2:*\3\2\2\2:\62\3\2\2"+
		"\2;W\3\2\2\2<=\f\t\2\2=>\7\f\2\2>V\5\6\4\n?@\f\b\2\2@A\7\16\2\2AV\5\6"+
		"\4\tBC\f\7\2\2CD\7\r\2\2DV\5\6\4\bEF\f\6\2\2FG\7\20\2\2GV\5\6\4\7HI\f"+
		"\5\2\2IJ\7\17\2\2JV\5\6\4\6KL\f\3\2\2LM\7\22\2\2MV\5\6\4\4NO\f\4\2\2O"+
		"P\7\21\2\2PQ\5\6\4\2QR\7\6\2\2RS\5\n\6\2ST\7\7\2\2TV\3\2\2\2U<\3\2\2\2"+
		"U?\3\2\2\2UB\3\2\2\2UE\3\2\2\2UH\3\2\2\2UK\3\2\2\2UN\3\2\2\2VY\3\2\2\2"+
		"WU\3\2\2\2WX\3\2\2\2X\7\3\2\2\2YW\3\2\2\2Z`\5\22\n\2[\\\5\22\n\2\\]\7"+
		"\b\2\2]^\5\b\5\2^`\3\2\2\2_Z\3\2\2\2_[\3\2\2\2`\t\3\2\2\2ab\b\6\1\2bc"+
		"\7\t\2\2cm\5\n\6\5de\7\4\2\2ef\5\n\6\2fg\7\5\2\2gm\3\2\2\2hi\5\16\b\2"+
		"ij\5\f\7\2jk\5\16\b\2km\3\2\2\2la\3\2\2\2ld\3\2\2\2lh\3\2\2\2mv\3\2\2"+
		"\2no\f\7\2\2op\7\32\2\2pu\5\n\6\bqr\f\6\2\2rs\7\31\2\2su\5\n\6\7tn\3\2"+
		"\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\13\3\2\2\2xv\3\2\2\2y\u0080"+
		"\7\23\2\2z\u0080\7\24\2\2{\u0080\7\25\2\2|\u0080\7\26\2\2}\u0080\7\27"+
		"\2\2~\u0080\7\30\2\2\177y\3\2\2\2\177z\3\2\2\2\177{\3\2\2\2\177|\3\2\2"+
		"\2\177}\3\2\2\2\177~\3\2\2\2\u0080\r\3\2\2\2\u0081\u0085\5\22\n\2\u0082"+
		"\u0085\7\34\2\2\u0083\u0085\7\36\2\2\u0084\u0081\3\2\2\2\u0084\u0082\3"+
		"\2\2\2\u0084\u0083\3\2\2\2\u0085\17\3\2\2\2\u0086\u0087\7\35\2\2\u0087"+
		"\21\3\2\2\2\u0088\u0089\7\35\2\2\u0089\23\3\2\2\2\f\31:UW_ltv\177\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}