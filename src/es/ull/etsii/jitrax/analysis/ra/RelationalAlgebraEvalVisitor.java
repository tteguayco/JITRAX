package es.ull.etsii.jitrax.analysis.ra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraParser.ProjectionContext;

public class RelationalAlgebraEvalVisitor extends RelationalAlgebraBaseVisitor<String> {
	private static final String ALIAS_PREFIX = "query";
	
	String sqlTranslation;
	Database database;
	ArrayList<String> errors;
	int subqueryCounter;

	public RelationalAlgebraEvalVisitor(Database aDatabase) {
		 sqlTranslation = "";
		 database = aDatabase;
		 errors = new ArrayList<String>();
		 subqueryCounter = 1;
	}
	
	public ArrayList<String> getErrorsList() {
		return errors;
	}
	
	public boolean errors() {
		if (getErrorsList().size() > 0) {
			return true;
		}
		
		return false;
	}
	
	public void printErrorsList() {
		for (int i = 0; i < getErrorsList().size(); i++) {
			System.out.println(getErrorsList().get(i));
		}
	}
	
	public String getSqlTranslation() {
		return sqlTranslation;
	}
	
	private void appendError(String errorMsg) {
		getErrorsList().add(errorMsg);
	}
	
	private String appendAlias() {
		String alias = " AS " + ALIAS_PREFIX + subqueryCounter;
		subqueryCounter++;
		return alias;
	}
	
	/**
	 * Attribute separator is ','.
	 * @param projectionContext
	 * @return
	 */
	private String[] splitAttrList(RelationalAlgebraParser.ProjectionContext ctx) {
		String attrList = visit(ctx.attrlist());
		return attrList.split(",\\s+");
	}
	
	private String listToString(ArrayList<Attribute> list) {
		String listString = "";
		for (int i = 0; i < list.size(); i++) {
			listString += list.get(i).getName();
			if (i < list.size() - 1) {
				listString += ", ";
			}
		}
		
		return listString;
	}
	
	/**
	 * Returns the list of attributes for the specified relational 
	 * algebra expression (a relation, a natural join operation, etc).
	 * @return
	 */
	private ArrayList<Attribute> expressionSchema(RelationalAlgebraParser.ExprContext expr) {
		
		// PROJECTION: the schema will be the list of attributes 'L' in P(L)(R)
		if (expr instanceof RelationalAlgebraParser.ProjectionContext) {
			ArrayList<String> attributesNames = new ArrayList<String>(
					Arrays.asList(splitAttrList((ProjectionContext) expr)));
			ArrayList<Attribute> attributes = new ArrayList<Attribute>();
			// Getting the attributes
			for (int i = 0; i < attributesNames.size(); i++) {
				attributes.add(database.getAttributeByName(attributesNames.get(i)));
			}
			
			return attributes;
		}
		
		// RELATION: return its list of attributes
		else if (expr instanceof RelationalAlgebraParser.RelationFromExprContext) {
			String tableName = expr.getText();
			try {
				return new ArrayList<Attribute>(database.getTableByName(tableName).getAttributes());
			}
			catch (NullPointerException e) {
				appendError("TABLE NOT FOUND (" + tableName + ")");
			}
		}
		
		// SELECTION: 
		else if (expr instanceof RelationalAlgebraParser.SelectionContext) {
			return expressionSchema(((RelationalAlgebraParser.SelectionContext) expr).expr());
		}
		
		// CARTESIAN PRODUCT: R(r) x S(s) -> r+s
		else if (expr instanceof RelationalAlgebraParser.CartesianProductContext) {
			ArrayList<Attribute> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.CartesianProductContext) expr).expr(0));
			ArrayList<Attribute> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.CartesianProductContext) expr).expr(1));
			
			// Concatenate the schemas
			leftRelationSchema.addAll(rightRelationSchema);
			return leftRelationSchema;
		}
		
		// UNION: R(r) U S(s) -> r U s
		else if (expr instanceof RelationalAlgebraParser.UnionContext) {
			ArrayList<Attribute> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.UnionContext) expr).expr(0));
			ArrayList<Attribute> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.UnionContext) expr).expr(1));
			
			Set<Attribute> leftSchemaSet = new HashSet<Attribute>(leftRelationSchema);
			Set<Attribute> rightSchemaSet = new HashSet<Attribute>(rightRelationSchema);
			
			// Union between the sets
			leftSchemaSet.addAll(rightSchemaSet);
			return new ArrayList<Attribute>(leftSchemaSet);
		}
		
		// DIFFERENCE: R(r) - S(s) -> r
		else if (expr instanceof RelationalAlgebraParser.DifferenceContext) {
			ArrayList<Attribute> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.DifferenceContext) expr).expr(0));
			
			return leftRelationSchema;
		}
		
		// INTERSECTION: R(r) ^ S(s) -> 
		else if (expr instanceof RelationalAlgebraParser.IntersectionContext) {
			
		}
		
		// JOIN: R(r) JOIN S(s) [condlist] -> r+s 
		else if (expr instanceof RelationalAlgebraParser.JoinContext) {
			ArrayList<Attribute> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.JoinContext) expr).expr(0));
			ArrayList<Attribute> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.JoinContext) expr).expr(1));
			
			// Concatenate the schemas
			leftRelationSchema.addAll(rightRelationSchema);
			return leftRelationSchema;
		}
		
		// NATURAL JOIN: R(r) * S(s) -> r U s
		else if (expr instanceof RelationalAlgebraParser.NaturalJoinContext) {
			ArrayList<Attribute> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.NaturalJoinContext) expr).expr(0));
			ArrayList<Attribute> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.NaturalJoinContext) expr).expr(1));
			
			Set<Attribute> leftSchemaSet = new HashSet<Attribute>(leftRelationSchema);
			Set<Attribute> rightSchemaSet = new HashSet<Attribute>(rightRelationSchema);
			
			// Union between the sets
			leftSchemaSet.addAll(rightSchemaSet);
			return new ArrayList<Attribute>(leftSchemaSet);
		}
		
		// DIVISION: R(r) / S(s) -> r-s
		else if (expr instanceof RelationalAlgebraParser.DivisionContext) {
			ArrayList<Attribute> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.DivisionContext) expr).expr(0));
			ArrayList<Attribute> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.DivisionContext) expr).expr(1));
			
			Set<Attribute> leftSchemaSet = new HashSet<Attribute>(leftRelationSchema);
			Set<Attribute> rightSchemaSet = new HashSet<Attribute>(rightRelationSchema);
			
			// Difference between sets
			leftSchemaSet.removeAll(rightSchemaSet);
			return new ArrayList<Attribute>(leftSchemaSet);
		}
		
		// Expression between brackets -> call the method again
		else if (expr instanceof RelationalAlgebraParser.BracketsExprContext) {
			return expressionSchema(((RelationalAlgebraParser.BracketsExprContext) expr).expr());
		}
		
		return null;
	}
	
	/**
	 * This method is method is used before performing a set operation (Union, Intersection 
	 * or Difference). It checks two conditions:
	 * 	i) Both schemas have the same grade.
	 * 	ii) Ith attributes have compatible domains.
	 * @param attrList1
	 * @param attrList2
	 */
	private boolean attrListsSatisfySetOperationsConditions 
		(ArrayList<Attribute> attrList1, ArrayList<Attribute> attrList2) {
		
		if (attrList1.size() == attrList2.size()) {
			for (int i = 0; i < attrList1.size(); i++) {
				//if () {
					
			//	}
			}
		}
		
		return false;
	}
	
	/**
	 * If the specified expression is a subquery (its parent it's not the start node
	 * and it isn't a relation), returns true;
	 * @param ctx
	 * @return
	 */
	private boolean isSubquery(RelationalAlgebraParser.ExprContext ctx) {
		if (!(ctx.getParent() instanceof RelationalAlgebraParser.StartContext)) {
			if (!(ctx instanceof RelationalAlgebraParser.RelationFromExprContext)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Appends an alias to the translation if the context is a subquery.
	 * @param ctx
	 * @param translation
	 * @return
	 */
	private String appendAliasIfSubquery(RelationalAlgebraParser.ExprContext ctx, String translation) {
		if (isSubquery(ctx)) {
			return "(" + translation + ")" + appendAlias(); 
		}
		
		return translation;
	}
	
	private String preppendSelectStarIfNeeded(RelationalAlgebraParser.StartContext ctx, String translation) {
		if (ctx.expr() instanceof RelationalAlgebraParser.ProjectionContext) {
			return translation;
		}
		
		if (ctx.expr() instanceof RelationalAlgebraParser.SelectionContext) {
			return translation;
		}
		
		if (ctx.expr() instanceof RelationalAlgebraParser.DivisionContext) {
			return translation;
		}
		
		if (ctx.expr() instanceof RelationalAlgebraParser.RelationFromExprContext) {
			return "SELECT * FROM " + translation;
		}
		
		return translation = "SELECT * FROM (" + translation + ")" + appendAlias();
	}
	
	private void calculateTranslation(RelationalAlgebraParser.StartContext ctx) {
		// VIEWS
		for (int i = 0; i < ctx.view().size(); i++) {
			sqlTranslation += visit(ctx.view(i)) + "\n\n";
		}
		
		// EXPRESSION
		sqlTranslation += visit(ctx.expr());
		sqlTranslation = preppendSelectStarIfNeeded(ctx, sqlTranslation);
		sqlTranslation += ";";
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@Override 
	public String visitStart(RelationalAlgebraParser.StartContext ctx) {
		if (errors()) {
			return null;
		}

		calculateTranslation(ctx);
		return sqlTranslation;
	}
	
	@Override
	public String visitViewAssignment(RelationalAlgebraParser.ViewAssignmentContext ctx) {
		return "CREATE OR REPLACE VIEW " + ctx.IDENTIFIER().getText() + " AS (" +
				visit(ctx.expr()) + ");";
	}
	
	@Override
	public String visitProjection(RelationalAlgebraParser.ProjectionContext ctx) {
		String translation = "SELECT " + visit(ctx.attrlist()) + " FROM " + visit(ctx.expr());
		
		/**
		 * CASCADE OF PROJECTIONS: PROJECT [...] (PROJECT [...] (...));
		 * => check if the attributes list of a projection contains
		 * in the outer projection's attributes list.
		 */
		// If its parent it's a projection as well...
		if (ctx.getParent() instanceof RelationalAlgebraParser.ProjectionContext) {
			RelationalAlgebraParser.ProjectionContext currentProjectAttrList = ctx;
			RelationalAlgebraParser.ProjectionContext outerProjectAttrList = 
					(ProjectionContext) ctx.getParent();
			ArrayList<String> currentProjectAttributes;
			ArrayList<String> outerProjectAttributes;
			
			String[] currentProjectAttrListSplitted = splitAttrList(currentProjectAttrList);
			String[] outerProjectAttrListSplitted = splitAttrList(outerProjectAttrList);
			
			currentProjectAttributes = new ArrayList<String>(
					Arrays.asList(currentProjectAttrListSplitted));
			outerProjectAttributes = new ArrayList<String>(Arrays.asList(outerProjectAttrListSplitted));
		
			if (!currentProjectAttributes.containsAll(outerProjectAttributes)) {
				appendError("The projection attributes list " + currentProjectAttributes
						+ " does not contain its outer projection attributes list "
						+ outerProjectAttributes);
			}
			
			// Return only the RELATION
			return visit(ctx.expr());
		}
		
		return translation;
	}
	
	@Override
	public String visitSelection(RelationalAlgebraParser.SelectionContext ctx) {
		String selectStatement = "";
		
		/**
		 * Getting the skeleton 'relation WHERE condlist1 AND condlist2...'
		 * 
		 * We have to do this in order to translate a cascade of SELECTIONs 
		 * (such as SELECT [...] (SELECT [...] (...))) to
		 * a conjunction of condition lists (such as WHERE condlist1 AND condlist2...).
		 */
		// If expr() is not a selection node, this is the last selection node in the target subtree
		if (ctx.expr() instanceof RelationalAlgebraParser.SelectionContext) {
			selectStatement = visit(ctx.expr()) + " AND " + visit(ctx.condlist());
		} else {
			selectStatement = visit(ctx.expr()) + " WHERE " + visit(ctx.condlist());
		}
		
		/**
		 * Append SELECT * if the PARENT is not a PROJECTION or a SELECTION
		 */
		// If the previous rule name is a projection or selection, we return what we have
		if (ctx.getParent() instanceof RelationalAlgebraParser.ProjectionContext
				|| ctx.getParent() instanceof RelationalAlgebraParser.SelectionContext) {
			return selectStatement;
		}
		
		//Otherwise, we append SELECT *
		return "SELECT * FROM " + selectStatement;
	}
	
	@Override 
	public String visitCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		String translation = left + ", " + right;
		return appendAliasIfSubquery(ctx, translation);
	}
	
	@Override
	public String visitUnion(RelationalAlgebraParser.UnionContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		left = appendAliasIfSubquery(ctx.expr(0), left);
		right = appendAliasIfSubquery(ctx.expr(1), right);
		String translation = "SELECT * FROM " + left + " UNION SELECT * FROM " + right;
		return appendAliasIfSubquery(ctx, translation);
	}

	@Override
	public String visitDifference(RelationalAlgebraParser.DifferenceContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		String translation = "SELECT * FROM " + left + " EXCEPT SELECT * FROM " + right;
		return appendAliasIfSubquery(ctx, translation);
	}
	
	@Override 
	public String visitIntersection(RelationalAlgebraParser.IntersectionContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		String translation = "SELECT * FROM " + left + " INTERSECT SELECT * FROM " + right;
		return appendAliasIfSubquery(ctx, translation);
	}
	
	@Override 
	public String visitNaturalJoin(RelationalAlgebraParser.NaturalJoinContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		return left + " NATURAL JOIN " + right;
	}
	
	@Override 
	public String visitJoin(RelationalAlgebraParser.JoinContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		String conditionList = visit(ctx.condlist());
		return left + " INNER JOIN " + right + " ON " + conditionList;
	}
	
	/**
	 * https://users.dcc.uchile.cl/~cgutierr/cursos/BD/divisionSQL.pdf
	 */
	@Override
	public String visitDivision(RelationalAlgebraParser.DivisionContext ctx) {
		ArrayList<Attribute> leftRelationColumns = expressionSchema(ctx.expr(0));
		ArrayList<Attribute> rightRelationColumns = expressionSchema(ctx.expr(1));
		
		if (leftRelationColumns == null || rightRelationColumns == null) {
			return "";
		}
		
		// Let R(r) / S(s), r must contain s strictly 
		if (leftRelationColumns.size() > rightRelationColumns.size()) {
			if (leftRelationColumns.containsAll(rightRelationColumns)) {
				String division = "";
				String divisionSchema = listToString(expressionSchema(ctx));
				String rightRelationSchema = listToString(rightRelationColumns);
				String leftRelationName = visit(ctx.expr(0));
				String rightRelationName = visit(ctx.expr(1));
				
				division += "SELECT " + divisionSchema + " ";
				division += "FROM " + leftRelationName + "\n";
				division += "WHERE (" + rightRelationSchema + ")";
				division += "\nIN (SELECT " + rightRelationSchema + " FROM " + rightRelationName +")\n";
				division += "GROUP BY " + divisionSchema + "\n";
				division += "HAVING COUNT(*) = (SELECT COUNT(*) FROM " + rightRelationName + ")";
				
				return appendAliasIfSubquery(ctx, division);
			}
		}
		
		appendError("Division: incompatible schemas.");
		return "";
	}
	
	@Override 
	public String visitBracketsExpr(RelationalAlgebraParser.BracketsExprContext ctx) {
		return visit(ctx.expr());
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
		return "(" + visit(ctx.condlist()) + ")";
	}
	
	@Override 
	public String visitComparedCondlist(RelationalAlgebraParser.ComparedCondlistContext ctx) {
		String left = (String) visit(ctx.compared(0));
		String right = (String) visit(ctx.compared(1));
		String comparator = (String) visit(ctx.comparator());
		return "(" + left + " " + comparator + " " + right + ")";
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
