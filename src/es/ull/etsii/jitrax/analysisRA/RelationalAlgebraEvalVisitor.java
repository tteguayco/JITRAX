package es.ull.etsii.jitrax.analysisRA;

import java.util.HashMap;

public class RelationalAlgebraEvalVisitor extends RelationalAlgebraBaseVisitor<String> {
	HashMap<String, String> views;
	String sqlTranslation;
	
	public RelationalAlgebraEvalVisitor() {
		 views = new HashMap<String, String>();
	}	

	@Override 
	public String visitStart(RelationalAlgebraParser.StartContext ctx) {
		sqlTranslation = visit(ctx.expr()) + ";";
		System.out.println(sqlTranslation);
		return sqlTranslation;
	}

	@Override
	public String visitProjection(RelationalAlgebraParser.ProjectionContext ctx) {
		return "SELECT " + visit(ctx.attrlist()) + " FROM " + visit(ctx.expr());
	}
	
	@Override
	public String visitSelection(RelationalAlgebraParser.SelectionContext ctx) {
		return "WHERE " + visit(ctx.condlist());
	}
	
	@Override
	public String visitUnion(RelationalAlgebraParser.UnionContext ctx) { 
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		return left + " UNION " + right;
	}

	@Override
	public String visitDifference(RelationalAlgebraParser.DifferenceContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		return left + " EXCEPT " + right;
	}
	
	@Override 
	public String visitCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		return left + ", " + right;
	}
	
	@Override 
	public String visitBracketsExpr(RelationalAlgebraParser.BracketsExprContext ctx) {
		return "(" + visit(ctx.expr()) + ")";
	}
	
	@Override 
	public String visitAttributeFromAttrlist(RelationalAlgebraParser.AttributeFromAttrlistContext ctx) {
		return (String) visit(ctx.attribute());
	}
	
	@Override 
	public String visitAttributeList(RelationalAlgebraParser.AttributeListContext ctx) {
		return visit(ctx.attribute()) + ", " + visit(ctx.attrlist());
	}
	
	@Override
	public String visitOrCondlist(RelationalAlgebraParser.OrCondlistContext ctx) {
		String left = (String) visit(ctx.condlist(0));
		String right = (String) visit(ctx.condlist(1));
		return left + " OR " + right;
	}
	
	@Override public String visitAndCondlist(RelationalAlgebraParser.AndCondlistContext ctx) {
		String left = (String) visit(ctx.condlist(0));
		String right = (String) visit(ctx.condlist(1));
		return left + " AND " + right;
	}
	
	@Override
	public String visitNotCondlist(RelationalAlgebraParser.NotCondlistContext ctx) {
		return "NOT " + visit(ctx.condlist());
	}
	
	@Override 
	public String visitBracketsCondlist(RelationalAlgebraParser.BracketsCondlistContext ctx) {
		return "(" + visit(ctx.condlist()) + ")";
	}
	
	@Override 
	public String visitComparedCondlist(RelationalAlgebraParser.ComparedCondlistContext ctx) {
		String left = (String) visit(ctx.compared(0));
		String right = (String) visit(ctx.compared(1));
		String comparator = (String) visit(ctx.comparator());
		return left + " " + comparator + " " + right;
	}
	
	@Override 
	public String visitEqual(RelationalAlgebraParser.EqualContext ctx) {
		return " = ";
	}
	
	@Override 
	public String visitNonEqual(RelationalAlgebraParser.NonEqualContext ctx) {
		return " <> ";
	}
	
	@Override 
	public String visitGreaterThan(RelationalAlgebraParser.GreaterThanContext ctx) {
		return " > ";
	}
	
	@Override 
	public String visitGreaterEqual(RelationalAlgebraParser.GreaterEqualContext ctx) {
		return " >= ";
	}
	
	@Override 
	public String visitLessThan(RelationalAlgebraParser.LessThanContext ctx) {
		return " < ";
	}
	
	@Override 
	public String visitLessEqual(RelationalAlgebraParser.LessEqualContext ctx) {
		return " <= ";
	}
	
	@Override
	public String visitAttributeFromCompared(RelationalAlgebraParser.AttributeFromComparedContext ctx) {
		return (String) visit(ctx.attribute());
	}
	
	@Override
	public String visitDataFromCompared(RelationalAlgebraParser.DataFromComparedContext ctx) {
		return ctx.NUMBER().getText();
	}
	
	@Override
	public String visitRelationIdentifier(RelationalAlgebraParser.RelationIdentifierContext ctx) { 
		return ctx.IDENTIFIER().getText();
	}
	
	@Override
	public String visitAttributeIdentifier(RelationalAlgebraParser.AttributeIdentifierContext ctx) {
		return ctx.IDENTIFIER().getText();
	}
	
	@Override
	public String visitDataNumber(RelationalAlgebraParser.DataNumberContext ctx) {
		return ctx.NUMBER().getText();
	}
	
	@Override
	public String visitDataIdentifier(RelationalAlgebraParser.DataIdentifierContext ctx) {
		return ctx.IDENTIFIER().getText();
	}
}