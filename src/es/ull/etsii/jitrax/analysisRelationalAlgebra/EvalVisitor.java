package es.ull.etsii.jitrax.analysisRelationalAlgebra;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends RelationalAlgebraBaseVisitor<String> {
	
	@Override 
	public String visitStart(RelationalAlgebraParser.StartContext ctx) {
		//System.out.println(visit(ctx.expr()));
		return null;
	}

	@Override 
	public String visitCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		String operation = ctx.CARTESIAN_PRODUCT().getText();
		System.out.println("from visitCartesianProduct: " + left + " " + operation + " " + right);
		return left + operation + right;
	}
	
	@Override
	public String visitUnion(RelationalAlgebraParser.UnionContext ctx) { 
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		String querySQL = left + " UNION " + right;
		return querySQL;
	}

	@Override 
	public String visitRelationIdentifier(RelationalAlgebraParser.RelationIdentifierContext ctx) { 
		return ctx.IDENTIFIER().getText();
	}
}
