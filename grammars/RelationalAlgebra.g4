// GRAMMAR'S NAME
grammar RelationalAlgebra;

// PRODUCTION RULES
start: 	(view ';')*  expr ';' EOF
;

view:	IDENTIFIER '=' expr			# viewAssignment
;

expr:	relation														# relationFromExpr
    |   '(' expr ')'													# bracketsExpr
    |	PROJECTION '['attrlist']' '('expr')'							# projection
    |   SELECTION '['condlist']' '('expr')'								# selection
    |	expr UNION expr													# union
    |   expr CARTESIAN_PRODUCT expr										# cartesianProduct
    |   expr DIFFERENCE expr											# difference
    |	expr NATURAL_JOIN expr											# naturalJoin
    |   expr INTERSECTION expr											# intersection
    |   expr JOIN expr '[' condlist ']'									# join
    |   expr DIVISION expr												# division
;

attrlist:   attribute										# attributeFromAttrlist
	|   attribute ',' attrlist								# attributeList
;

condlist:	condlist BOOLEAN_OR condlist					# orCondlist
	|	condlist BOOLEAN_AND condlist						# andCondlist
	|	'NOT' condlist										# notCondlist
	|	'(' condlist ')'									# bracketsCondlist
	|	compared comparator compared						# comparedCondlist
;

comparator: EQUAL				# equal
	| NOT_EQUAL					# nonEqual
	| GREATER_THAN				# greaterThan
	| GREATER_EQUAL				# greaterEqual
	| LESS_THAN					# lessThan
	| LESS_EQUAL				# lessEqual
;

compared:   attribute		# attributeFromCompared
	|   STRING				# stringFromCompared
	|   NUMBER				# numberFromCompared
;

relation:   IDENTIFIER		# relationIdentifier
;		
			
attribute:  IDENTIFIER		# attributeIdentifier
;

// TABLE BINARY OPERATORS
PROJECTION:			'PROJECTION'   	     | 'projection' 		| 'PROJECT'			| 'project';
SELECTION:			'SELECTION'    	     | 'selection' 			| 'SELECT'			| 'select';
UNION:				'UNION'        	     | 'union'				| 'U';
DIFFERENCE:			'DIFFERENCE'   	     | 'difference'			| '-';
CARTESIAN_PRODUCT:	'CARTESIAN PRODUCT'  | 'cartesian product'	| 'PRODUCT'  		| 'product'		| 'X' 	| 'x';
INTERSECTION: 		'INTERSECTION' 	     | 'intersection'		| 'INTERSECT'		| 'intersect' 	| '∩';
NATURAL_JOIN:		'NATURAL JOIN' 	     | 'NJOIN' 				| 'natural join' 	| 'njoin'		| '*';
JOIN:				'JOIN'		    	 | 'join'				| 'Y'	  			| 'y';
DIVISION:			'DIVISION'	    	 | 'division'			| '÷'		        | '/';

// COMPARISON OPERATORS
EQUAL:			'=';
NOT_EQUAL: 		'!=' | '<>';
GREATER_THAN:	'>';
GREATER_EQUAL:	'>=';
LESS_THAN:		'<';
LESS_EQUAL:		'<=';

// BOOLEAN OPERATORS
BOOLEAN_AND: 	'AND' | 'and' | '&' | '^';
BOOLEAN_OR:  	'OR'  | 'or'  | '|' | 'v';
BOOLEAN_NOT:	'NOT' | 'not' | '~';

STRING:			'"' (.)*? '"' | '\'' (.)*? '\'';
// IDENTIFIER OPTIONALLY LIKE 'TABLE.ATTR'
IDENTIFIER:  	[a-zA-Z]+([0-9] | [a-zA-Z] | '_')* ('.' ([a-zA-Z]+([0-9] | [a-zA-Z] | '_')*)+ )?;
NUMBER:    		[0-9]+;
WHITESPACES:   	[ \t\r\n]+ -> skip;

// COMMENTS
COMMENT:   		'/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT:   '//' ~[\r\n]* -> channel(HIDDEN);
