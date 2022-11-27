grammar miniPython;

/** KEY-WORDS */
IF    : 'if';
ELIF  : 'elif';
ELSE  : 'else';
WHILE : 'while';
CLAZZ : 'class';
DEF   : 'def';
RET   : 'return';
SELF  : 'self';

WS    : [ \t]+ -> skip;
NL    : [\n\r]+;

/** DATATYPES */
INT   : [1-9][0-9]*;
BOOL  : 'True' | 'False';
STRING: '"' ('\\' ["\\] | ~["\\\r\n])* '"';

/** IDENTIFIER */
ID    : [a-zA-Z_][a-zA-Z_0-9]*;

/** END-MARKER TO CLOSE SCOPES */
END   : '#end' NL?;

lit   : INT | BOOL | STRING;

expr : expr  '*'   expr # MUL
     | expr  '/'   expr # DIV
     | expr  '+'   expr # ADD
     | expr  '-'   expr # SUB
     | expr  '=='  expr # EQUI
     | expr  '!='  expr # UNEQUI
     | expr  '>='  expr # GEQUI
     | expr  '>'   expr # GREATER
     | expr  '<='  expr # LEQUI
     | expr  '<'   expr # LESS
     | expr  'or'  expr # OR
     | expr  'and' expr # AND
     |       'not' expr # NOT
     | ID               # ID
     | lit              # ATOM
     ;

/** INSTRUCTIONS */

assign : ID '=' expr NL
       | ID '=' methodCall
       | ID '=' funcCall
       | ID '=' obj;

block : (inst)*;

funcCall : ID '(' (expr  (','expr)*)? ')' NL;

methodCall : ID'.'ID'(' (expr (','expr)*)? ')' NL;

obj : ID'('(expr  (','expr)*)? ')' NL;

whileStmt : WHILE expr ':' NL block END;

ifStmt : IF expr ':' NL block (ELIF expr ':' NL block)* (ELSE ':' NL block)? END;

inst : assign
     | funcCall 
     | methodCall 
     | whileStmt 
     | ifStmt;

/** FUNCTION, METHOD, CLASS DEFINITION */

funcDef : DEF ID '(' (ID (','ID)*)? '):' NL block (RET expr NL)? END;

clazz : CLAZZ ID '(' ID? '):' NL (methodDef)* END;

methodDef : DEF ID '(' SELF (','ID)* '):' NL block (RET expr NL)? END;


prog : (funcDef | clazz | inst | NL)* EOF;