package es.ull.etsii.jitrax.analysisRA;

// Generated from RelationalAlgebra.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RelationalAlgebraParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RelationalAlgebraVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RelationalAlgebraParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(RelationalAlgebraParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code viewAssignment}
	 * labeled alternative in {@link RelationalAlgebraParser#view}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewAssignment(RelationalAlgebraParser.ViewAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code renameTable}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTable(RelationalAlgebraParser.RenameTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code union}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(RelationalAlgebraParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code division}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(RelationalAlgebraParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code renameSchema}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameSchema(RelationalAlgebraParser.RenameSchemaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cartesianProduct}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(RelationalAlgebraParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalJoin(RelationalAlgebraParser.NaturalJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationFromExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationFromExpr(RelationalAlgebraParser.RelationFromExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntersection(RelationalAlgebraParser.IntersectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code difference}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(RelationalAlgebraParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code projection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(RelationalAlgebraParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code join}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin(RelationalAlgebraParser.JoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketsExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketsExpr(RelationalAlgebraParser.BracketsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeFromAttrlist}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeFromAttrlist(RelationalAlgebraParser.AttributeFromAttrlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeList}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeList(RelationalAlgebraParser.AttributeListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketsCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketsCondlist(RelationalAlgebraParser.BracketsCondlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondlist(RelationalAlgebraParser.NotCondlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparedCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparedCondlist(RelationalAlgebraParser.ComparedCondlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCondlist(RelationalAlgebraParser.AndCondlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCondlist(RelationalAlgebraParser.OrCondlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(RelationalAlgebraParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeFromCompared(RelationalAlgebraParser.AttributeFromComparedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dataFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataFromCompared(RelationalAlgebraParser.DataFromComparedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationIdentifier(RelationalAlgebraParser.RelationIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeIdentifier(RelationalAlgebraParser.AttributeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dataNumber}
	 * labeled alternative in {@link RelationalAlgebraParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataNumber(RelationalAlgebraParser.DataNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dataIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataIdentifier(RelationalAlgebraParser.DataIdentifierContext ctx);
}