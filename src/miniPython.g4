grammar MiniPython;

WS    : [ \t]+ -> skip;
NL	  : '\r'? '\n';

/** KEY-WORDS */
IF    : 'if';
ELIF  : 'elif';
ELSE  : 'else';
WHILE : 'while';
CLAZZ : 'class';
DEF	  : 'def';
RET	  : 'return';
SELF  : 'self';
TYPE_NUM  : 'num';
TYPE_STR  : 'str';
TYPE_BOOL : 'bool';

/** DATATYPES */
INT    : [1-9][0-9]* | [0]; 
BOOL   : 'True' | 'False';
STRING : '"' ('\\' ["\\] | ~["\\\r\n])* '"';

/** IDENTIFIER */
ID    : [a-zA-Z_][a-zA-Z_0-9]*;

/** END-MARKER TO CLOSE SCOPES */
END   : '#end'NL;

lit   : INT | STRING | BOOL;

type : TYPE_NUM | TYPE_STR | TYPE_BOOL | ID;

identifier : (SELF | ID ) '.' ID
		   | ID
		   ;

expr : expr  op='*'   expr	# MUL
	 | expr  op='/'   expr  # DIV
	 | expr  op='+'   expr  # ADD
	 | expr  op='-'   expr  # SUB
	 | expr  op='=='  expr  # EQUI
	 | expr  op='!='  expr  # UNEQUI
	 | expr  op='>='  expr  # GEQUI
	 | expr  op='>'   expr  # GREATER
	 | expr  op='<='  expr  # LEQUI
	 | expr  op='<'   expr  # LESS
	 |       op='not' expr  # NOT
	 | expr  op='and' expr  # AND
	 | expr  op='or'  expr  # OR
	 | lit					# ATOM
	 | call					# ExprCall
	 | identifier		 	# ID
	 ;

parameters : ID (':'type)? (','ID (':'type)?)*;

arguments  : expr (','expr)*;

return : RET expr NL;


/** INSTRUCTIONS */

assign : identifier (':'type)? '=' expr NL;

call : identifier '(' arguments? ')';

whileStmt : WHILE expr ':' NL block END;

ifStmt   : IF expr ':' NL block elifStmt* (ELSE ':' NL block)? END;
elifStmt : ELIF expr ':' NL block;

statement : assign
		  | call NL 
	      | whileStmt 
	      | ifStmt
		  ;

block : (statement | NL)*;

/** FUNCTION, METHOD, CLASS DEFINITION */

funcDef : DEF ID '(' parameters? '):' (type':')? NL block return? END;

methodDef : DEF ID '(' SELF (',' parameters)? '):' (type':')? NL block return? END;

clazz : CLAZZ ID '(' ID? '):' NL (methodDef)* END;

prog : (funcDef | clazz | statement | NL)* EOF;