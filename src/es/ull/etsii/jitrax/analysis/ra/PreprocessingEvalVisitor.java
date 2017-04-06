package es.ull.etsii.jitrax.analysis.ra;

public class PreprocessingEvalVisitor extends RelationalAlgebraBaseVisitor<String> {

	public String visitStart(RelationalAlgebraParser.StartContext ctx) {
		String preprocessedQuery = "";
		
		// VIEWS
		for (int i = 0; i < ctx.view().size(); i++) {
			preprocessedQuery += visit(ctx.view(i)) + "\n\n";
		}
		
		preprocessedQuery += visit(ctx.expr()) + ";";
		
		return preprocessedQuery;
	}
	
	/**
	 * Remove redundant parentheses.
	 */
	@Override
	public String visitBracketsExpr(RelationalAlgebraParser.BracketsExprContext ctx) {
		if (ctx.getParent() instanceof RelationalAlgebraParser.BracketsExprContext) {
			return visit(ctx.expr());
		} 
		
		else {
			return "(" + visit(ctx.expr()) + ")";
		}
	}
	
	@Override public String visitViewAssignment(RelationalAlgebraParser.ViewAssignmentContext ctx) {
		return ctx.IDENTIFIER().getText() + " = " + visit(ctx.expr()) + ";";
	}
	
	@Override public String visitRenameTable(RelationalAlgebraParser.RenameTableContext ctx) { 
		return "RENAME " + visit(ctx.relation(0)) + " AS " + visit(ctx.relation(1)); 
	}
	
	@Override public String visitUnion(RelationalAlgebraParser.UnionContext ctx) { 
		return visit(ctx.expr(0)) + " UNION " + visit(ctx.expr(1)); 
	}
	
	@Override public String visitDivision(RelationalAlgebraParser.DivisionContext ctx) { 
		return visit(ctx.expr(0)) + " DIVISION " + visit(ctx.expr(1));
	}
	
	@Override public String visitRenameSchema(RelationalAlgebraParser.RenameSchemaContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx) { 
		return visit(ctx.expr(0)) + " PRODUCT " + visit(ctx.expr(1)); 
	}
	
	@Override public String visitSelection(RelationalAlgebraParser.SelectionContext ctx) {
		String query = "SELECTION [" + visit(ctx.condlist()) + "] ";
		String expr = visit(ctx.expr());
		
		if (!(ctx.expr() instanceof RelationalAlgebraParser.BracketsExprContext)) {
			expr = "(" + expr + ")";
		}
		
		return query + expr;
	}
	
	@Override public String visitNaturalJoin(RelationalAlgebraParser.NaturalJoinContext ctx) { 
		return visit(ctx.expr(0)) + " * " + visit(ctx.expr(1)); 
	}
	
	@Override public String visitRelationFromExpr(RelationalAlgebraParser.RelationFromExprContext ctx) { 
		return visit(ctx.relation()); 
	}
	
	@Override public String visitIntersection(RelationalAlgebraParser.IntersectionContext ctx) { 
		return visit(ctx.expr(0)) + " INTERSECT " + visit(ctx.expr(1)); 
	}
	
	@Override public String visitDifference(RelationalAlgebraParser.DifferenceContext ctx) { 
		return visit(ctx.expr(0)) + " PRODUCT " + visit(ctx.expr(1)); 
	}
	
	@Override public String visitProjection(RelationalAlgebraParser.ProjectionContext ctx) {
		String query = "PROJECTION [" + visit(ctx.attrlist()) + "] ";
		String expr = visit(ctx.expr());
		
		if (!(ctx.expr() instanceof RelationalAlgebraParser.BracketsExprContext)) {
			expr = "(" + expr + ")";
		}
		
		return query + expr;
	}
	
	@Override public String visitJoin(RelationalAlgebraParser.JoinContext ctx) { 
		return visit(ctx.expr(0)) + " Y " + visit(ctx.expr(1)) + " [" + visit(ctx.condlist()) + "]"; 
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
		return "(" + left + " OR " + right + ")";
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
		return visit(ctx.condlist());
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
		return "=";
	}
	
	@Override 
	public String visitNonEqual(RelationalAlgebraParser.NonEqualContext ctx) {
		return "<>";
	}
	
	@Override 
	public String visitGreaterThan(RelationalAlgebraParser.GreaterThanContext ctx) {
		return ">";
	}
	
	@Override 
	public String visitGreaterEqual(RelationalAlgebraParser.GreaterEqualContext ctx) {
		return ">=";
	}
	
	@Override 
	public String visitLessThan(RelationalAlgebraParser.LessThanContext ctx) {
		return "<";
	}
	
	@Override 
	public String visitLessEqual(RelationalAlgebraParser.LessEqualContext ctx) {
		return "<=";
	}
	
	@Override
	public String visitAttributeFromCompared(RelationalAlgebraParser.AttributeFromComparedContext ctx) {
		return (String) visit(ctx.attribute());
	}
	
	@Override
	public String visitStringFromCompared(RelationalAlgebraParser.StringFromComparedContext ctx) {
		return ctx.STRING().getText();
	}
	
	@Override
	public String visitNumberFromCompared(RelationalAlgebraParser.NumberFromComparedContext ctx) {
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
}
