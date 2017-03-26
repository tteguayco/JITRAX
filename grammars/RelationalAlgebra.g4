// GRAMMAR'S NAME
grammar RelationalAlgebra;

// PRODUCTION RULES
start: 	(view ';')*  expr ';' EOF
;

view:	IDENTIFIER '=' expr			# viewAssignment
;

expr:	relation								# relationFromExpr
    |   '(' expr ')'							# bracketsExpr
    |	PROJECTION '['attrlist']' '('expr')'	# projection
    |   SELECTION '['condlist']' '('expr')'		# selection
    |	expr UNION expr							# union
    |   expr CARTESIAN_PRODUCT expr				# cartesianProduct
    |   expr DIFFERENCE expr					# difference
    |	expr NATURAL_JOIN expr					# naturalJoin
    |   expr INTERSECTION expr					# intersection
    |   expr JOIN expr '[' condlist ']'			# join
    |   expr DIVISION expr						# division
    |   RENAME relation AS relation					# renameTable
    |   RENAME relation '(' attrlist ')' AS relation '(' attrlist ')' 	# renameSchema
;

attrlist:   attribute				# attributeFromAttrlist
	|   attribute ',' attrlist		# attributeList
;

condlist:	condlist BOOLEAN_OR condlist	# orCondlist
	|	condlist BOOLEAN_AND condlist	# andCondlist
	|	'NOT' condlist			# notCondlist
	|	'(' condlist ')'		# bracketsCondlist
	|	compared comparator compared	# comparedCondlist
;

comparator: EQUAL				# equal
	| NOT_EQUAL				# nonEqual
	| GREATER_THAN				# greaterThan
	| GREATER_EQUAL				# greaterEqual
	| LESS_THAN				# lessThan
	| LESS_EQUAL				# lessEqual
;

compared:   attribute		# attributeFromCompared
	|   NUMBER		# dataFromCompared
;

relation:   IDENTIFIER		# relationIdentifier
;		
			
attribute:  IDENTIFIER		# attributeIdentifier
;
	
data:	NUMBER			# dataNumber
    |	IDENTIFIER		# dataIdentifier
;

// TABLE BINARY OPERATORS
PROJECTION:		'PROJECTION'   	     | 'PROJECT'		| 'project';
SELECTION:		'SELECTION'    	     | 'SELECT'			| 'select';
UNION:			'UNION'        	     | 'union'			| 'U';
DIFFERENCE:		'DIFFERENCE'   	     | 'difference'		| '-';
CARTESIAN_PRODUCT:	'CARTESIAN PRODUCT'  | 'cartesian product'	| 'PRODUCT'  		| 'product'	| 'X' 	| 'x';
INTERSECTION: 		'INTERSECTION' 	     | 'INTERSECT'		| 'intersect' 		| '∩';
NATURAL_JOIN:		'NATURAL JOIN' 	     | 'NJOIN' 			| 'natural join' 	| 'njoin'	| '*';
JOIN:			'JOIN'		     | 'join'			| 'Y'	  		| 'y';
DIVISION:		'DIVISION'	     | 'division'		| '÷'		        | '/';
RENAME:			'RENAME'	     | 'rename' 		| 'REN';
AS:			'AS'		     | 'as';

// COMPARISON OPERATORS
EQUAL:		'==';
NOT_EQUAL: 	'!=';
GREATER_THAN:	'>';
GREATER_EQUAL:	'>=';
LESS_THAN:	'<';
LESS_EQUAL:	'<=';

// BOOLEAN OPERATORS
BOOLEAN_AND: 	'AND' | 'and' | '&';
BOOLEAN_OR:  	'OR'  | 'or'  | '|';
BOOLEAN_NOT:	'NOT' | 'not' | '~';

// IDENTIFIER OPTIONALLY LIKE 'TABLE.ATTR'
IDENTIFIER:  	[a-zA-Z]+([0-9] | [a-zA-Z] | '_')* ('.' ([a-zA-Z]+([0-9] | [a-zA-Z] | '_'))*)?;
NUMBER:    	[0-9]+;
WHITESPACES:   	[ \t\r\n]+ -> skip;
