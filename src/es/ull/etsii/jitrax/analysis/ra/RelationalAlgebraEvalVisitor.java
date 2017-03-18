package es.ull.etsii.jitrax.analysis.ra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraParser.AttributeFromAttrlistContext;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraParser.ProjectionContext;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraParser.StartContext;

public class RelationalAlgebraEvalVisitor extends RelationalAlgebraBaseVisitor<String> {
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
	
	/**
	 * Attribute separator is ','.
	 * @param projectionContext
	 * @return
	 */
	private String[] splitAttrList(RelationalAlgebraParser.ProjectionContext ctx) {
		String attrList = visit(ctx.attrlist());
		return attrList.split(",");
	}
	
	/**
	 * Returns the list of attributes for the specified relational 
	 * algebra expression (a relation, a natural join operation, etc).
	 * @return
	 */
	private ArrayList<String> expressionSchema(RelationalAlgebraParser.ExprContext expr) {
		
		// PROJECTION: the schema will be the list of attributes 'L' in P(L)(R)
		if (expr instanceof RelationalAlgebraParser.ProjectionContext) {
			System.out.println("Projection");
			return new ArrayList<String>(
					Arrays.asList(splitAttrList((ProjectionContext) expr)));
		}
		
		// RELATION: return its list of attributes
		else if (expr instanceof RelationalAlgebraParser.RelationFromExprContext) {
			String tableName = expr.getText();
			System.out.println("tableName: " + tableName);
			return new ArrayList<String>(
					Arrays.asList(database.getTableByName(tableName).getColumnsNames()));
		}
		
		// SELECTION: 
		else if (expr instanceof RelationalAlgebraParser.SelectionContext) {
			expressionSchema(((RelationalAlgebraParser.SelectionContext) expr).expr());
		}
		
		// CARTESIAN PRODUCT: R(r) x S(s) -> r+s
		else if (expr instanceof RelationalAlgebraParser.CartesianProductContext) {
			ArrayList<String> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.CartesianProductContext) expr).expr(0));
			ArrayList<String> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.CartesianProductContext) expr).expr(1));
			
			// Concatenate the schemas
			leftRelationSchema.addAll(rightRelationSchema);
			return leftRelationSchema;
		}
		
		// UNION: R(r) U S(s) -> r U s
		else if (expr instanceof RelationalAlgebraParser.UnionContext) {
			ArrayList<String> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.UnionContext) expr).expr(0));
			ArrayList<String> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.UnionContext) expr).expr(1));
			
			Set<String> leftSchemaSet = new HashSet<String>(leftRelationSchema);
			Set<String> rightSchemaSet = new HashSet<String>(rightRelationSchema);
			
			// Union between the sets
			leftSchemaSet.addAll(rightSchemaSet);
			return new ArrayList<String>(leftSchemaSet);
		}
		
		// DIFFERENCE: R(r) - S(s) -> r
		else if (expr instanceof RelationalAlgebraParser.DifferenceContext) {
			ArrayList<String> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.DifferenceContext) expr).expr(0));
			
			return leftRelationSchema;
		}
		
		// INTERSECTION: R(r) ^ S(s) -> 
		else if (expr instanceof RelationalAlgebraParser.IntersectionContext) {
			
		}
		
		// JOIN: R(r) JOIN S(s) [condlist] -> r+s 
		else if (expr instanceof RelationalAlgebraParser.JoinContext) {
			ArrayList<String> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.JoinContext) expr).expr(0));
			ArrayList<String> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.JoinContext) expr).expr(1));
			
			// Concatenate the schemas
			leftRelationSchema.addAll(rightRelationSchema);
			return leftRelationSchema;
		}
		
		// NATURAL JOIN: R(r) * S(s) -> r U s
		else if (expr instanceof RelationalAlgebraParser.NaturalJoinContext) {
			ArrayList<String> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.NaturalJoinContext) expr).expr(0));
			ArrayList<String> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.NaturalJoinContext) expr).expr(1));
			
			Set<String> leftSchemaSet = new HashSet<String>(leftRelationSchema);
			Set<String> rightSchemaSet = new HashSet<String>(rightRelationSchema);
			
			// Union between the sets
			leftSchemaSet.addAll(rightSchemaSet);
			return new ArrayList<String>(leftSchemaSet);
		}
		
		// DIVISION: R(r) / S(s) -> r-s
		else if (expr instanceof RelationalAlgebraParser.DivisionContext) {
			ArrayList<String> leftRelationSchema = 
					expressionSchema(((RelationalAlgebraParser.DivisionContext) expr).expr(0));
			ArrayList<String> rightRelationSchema =
					expressionSchema(((RelationalAlgebraParser.DivisionContext) expr).expr(1));
			
			Set<String> leftSchemaSet = new HashSet<String>(leftRelationSchema);
			Set<String> rightSchemaSet = new HashSet<String>(rightRelationSchema);
			
			// Difference between sets
			leftSchemaSet.removeAll(rightSchemaSet);
			return new ArrayList<String>(leftSchemaSet);
		}
		
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@Override 
	public String visitStart(RelationalAlgebraParser.StartContext ctx) {
		// VIEWS
		for (int i = 0; i < ctx.view().size(); i++) {
			sqlTranslation += visit(ctx.view(i)) + "\n\n";
		}
		
		// Append 'SELECT *' if needed
		if (ctx.expr().getChild(0) instanceof TerminalNode) {
			TerminalNode childType = (TerminalNode) ctx.expr().getChild(0);
			
			if (childType.getSymbol().getType() != RelationalAlgebraParser.PROJECTION
					&& childType.getSymbol().getType() != RelationalAlgebraParser.SELECTION) {
				sqlTranslation += "SELECT *\nFROM ";
			}
		}
		
		// EXPRESSION
		sqlTranslation += visit(ctx.expr()) + ";";

		if (errors.size() > 0) {
			return null;
		}
		
		return sqlTranslation;
	}

	@Override
	public String visitViewAssignment(RelationalAlgebraParser.ViewAssignmentContext ctx) {
		return "CREATE OR REPLACE VIEW " + ctx.IDENTIFIER().getText() + " AS\n(" +
				visit(ctx.expr()) + ");";
	}
	
	@Override
	public String visitProjection(RelationalAlgebraParser.ProjectionContext ctx) {
		String translation = "SELECT " + visit(ctx.attrlist()) + "\nFROM " + visit(ctx.expr());
		
		// Brackets if it's a nested projection
		if (ctx.getParent().getParent() != null) {
			// Si el padre no es una vista
			if (ctx.getParent().getChild(0) instanceof TerminalNode) {
				TerminalNode parentType = (TerminalNode) ctx.getParent().getChild(0);
				if (parentType.getSymbol().getType() == RelationalAlgebraParser.RULE_view) {
					// do nothing
				}
			}
			else {
				translation = "(" + translation;
				translation += ") AS s" + subqueryCounter;
				subqueryCounter++;
			}
		}
		
		System.out.println(expressionSchema(ctx));
		
		/**
		 * CASCADE OF PROJECTIONS: PROJECT [...] (PROJECT [...] (...));
		 * => check if the attributes list of a projection contains
		 * in the outer projection's attributes list.
		 */
		// If its parent it's a projection as well...
		if (ctx.getParent().getChild(0) instanceof TerminalNode) {
			TerminalNode parentType = (TerminalNode) ctx.getParent().getChild(0);
			
			if (parentType.getSymbol().getType() == RelationalAlgebraLexer.PROJECTION) {
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
				
				// Otherwise, OK
			}
			
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
		if (ctx.expr().getChild(0) instanceof TerminalNode) {
			TerminalNode childType = (TerminalNode) ctx.expr().getChild(0);
			
			if (childType.getSymbol().getType() == RelationalAlgebraLexer.SELECTION) {
				selectStatement = visit(ctx.expr()) + " AND " + visit(ctx.condlist());
			}
			
			else {
				selectStatement = visit(ctx.expr()) + "\nWHERE " + visit(ctx.condlist());
			}
		}
		
		else {
			selectStatement = visit(ctx.expr()) + "\nWHERE " + visit(ctx.condlist());
		}
		
		/**
		 * Append SELECT * if the PARENT is not a PROJECTION or a SELECTION
		 */
		if (ctx.getParent().getChild(0) instanceof TerminalNode) {
			TerminalNode parentNodeType = (TerminalNode) ctx.getParent().getChild(0);
			
			// If the previous rule name is a projection or selection, we return what we have
			if (parentNodeType.getSymbol().getType() == RelationalAlgebraLexer.PROJECTION
					|| parentNodeType.getSymbol().getType() == RelationalAlgebraLexer.SELECTION) {
				return selectStatement;
			}
		}
		
		//Otherwise, we append SELECT *
		return "SELECT *\nFROM " + selectStatement;
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
	public String visitIntersection(RelationalAlgebraParser.IntersectionContext ctx) {
		String left = visit(ctx.expr(0));
		String right = visit(ctx.expr(1));
		return left + " INTERSECT " + right;
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
		String condition = visit(ctx.condlist());
		return left + " INNER JOIN " + right + "\nON " + condition;
	}
	
	@Override 
	public String visitDivision(RelationalAlgebraParser.DivisionContext ctx) {
		return "DIVISION NOT IMPLEMENTED YET";
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
