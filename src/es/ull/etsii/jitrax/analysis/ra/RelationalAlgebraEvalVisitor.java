package es.ull.etsii.jitrax.analysis.ra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraParser.AttributeFromAttrlistContext;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraParser.ProjectionContext;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraParser.StartContext;

public class RelationalAlgebraEvalVisitor extends RelationalAlgebraBaseVisitor<String> {
	//HashMap<String, String> views;
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
	 * Returns the list of attributes for the specified relational 
	 * algebra expression (a relation, a natural join operation, etc).
	 * @return
	 */
	private ArrayList<String> expressionSchema(RelationalAlgebraParser.ExprContext expr) {
		
		// if (expr es relation) {
			// return esquema de la relacion
		//}
		
		
		
		
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
					|| childType.getSymbol().getType() != RelationalAlgebraParser.SELECTION) {
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
		return "CREATE OR REPLACE VIEW " + ctx.IDENTIFIER().getText() + " AS\n" +
				visit(ctx.expr()) + ";";
	}
	
	@Override
	public String visitProjection(RelationalAlgebraParser.ProjectionContext ctx) {
		String translation = "SELECT " + visit(ctx.attrlist()) + "\nFROM " + visit(ctx.expr());
		
		// Brackets if it's a nested projection
		if (ctx.getParent().getParent() != null) {
			translation = "(" + translation;
			translation += ") AS s" + subqueryCounter;
			subqueryCounter++;
		}
		
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
	
	/**
	 * Attribute separator is ','.
	 * @param projectionContext
	 * @return
	 */
	private String[] splitAttrList(RelationalAlgebraParser.ProjectionContext ctx) {
		String attrList = visit(ctx.attrlist());
		return attrList.split(",");
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
		// Does this relation exist?
		//if (database.containsTable(ctx.IDENTIFIER().getText())) {
			return ctx.IDENTIFIER().getText();
		//}
		
		//errors.add(new String("Relation '" + ctx.IDENTIFIER().getText() + "' does not exist."));
		//return "";
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
