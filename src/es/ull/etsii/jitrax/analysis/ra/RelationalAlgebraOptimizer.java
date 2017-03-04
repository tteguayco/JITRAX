package es.ull.etsii.jitrax.analysis.ra;

public class RelationalAlgebraOptimizer extends RelationalAlgebraBaseVisitor {
	private String optimizedExpression;
	
	public RelationalAlgebraOptimizer() {
		optimizedExpression = "";
	}
}
