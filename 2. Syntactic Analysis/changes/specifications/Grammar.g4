grammar Grammar;

import Tokenizer;

program
	: 'DATA' varDefinition* 'CODE' statement* EOF
	;

varDefinition
	: type IDENT ';'
	;

type
	: 'float'
	| 'int'
	;

statement
	: 'print' expression ';'
	| expression '=' expression ';'
	;

expression
	: expression ('*' | '/') expression
	| expression ('+' | '-') expression
	| '(' expression ')'
	| IDENT
	| INT_LITERAL
	| FLOAT_LITERAL
	;
