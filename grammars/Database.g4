// GRAMMAR'S NAME
grammar Database;

// PRODUCTION RULES
start:
	database
;

database:
	DATABASE ID ';' table+				# databaseCreation
;

table:
	TABLE ID '(' attrlist ')' 
		('=>' ('(' datalist ')' ';')+)?		# tableCreation
;

attrlist:													
	attribute								# singleAttribute
	| attribute ';' attrlist				# attributeList
;

datalist:
	datum									# singleDatum
	| datum ',' datalist					# dataList
;

attribute:
	ID ':' datatype	(',' PK)?				# attributeValue
;

datum:
	STRING_VAL								# stringDatum
	| NUMBER								# numberDatum				
;

datatype:   								
	STRING 									# stringValue
	| CHAR 									# charValue
	| INT 									# IntegerValue
	| FLOAT 								# floatValue
	| DATE									# dateValue
;

// TERMINALS
DATABASE:	'DATABASE' | 'Database' | 'database';
TABLE:		'TABLE' | 'Table' | 'table';
STRING:		'STRING' | 'String' | 'string';
CHAR:		'CHAR' | 'Char' | 'char';
INT:		'INTEGER' | 'Integer' | 'integer' | 'INT' | 'int';
FLOAT:		'FLOAT' | 'Float' | 'float';
DATE:		'DATE' | 'Date' | 'date';
PK:			'PK' | 'pk' | 'Primary Key';
STRING_VAL: 	'\'' ([a-zA-Z]| [0-9] | '@' | '_' | '-' | '+' | '*' | '/' | '.')* '\'';
NUMBER:			[0-9]+ ('.' | [0-9])*;
ID:				([a-zA-Z])+([a-zA-Z]| [0-9] | '@' | '_' | '-' | '+' | '*' | '/' | '.')*;
WHITESPACES:   	[ \t\r\n]+ -> skip;
