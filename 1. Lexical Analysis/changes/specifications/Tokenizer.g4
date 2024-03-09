lexer grammar Tokenizer;

DATA: 'DATA';

CODE: 'CODE';

PRINT: 'print';

INT: 'int';

FLOAT: 'float';

INT_LITERAL: [0-9]+;

FLOAT_LITERAL: [0-9]+ '.' [0-9]+;

IDENT: [a-zA-Z][a-zA-Z0-9_]*;

PLUS: '+';

MULT: '*';

SUB: '-';

DIV: '/';

ASSIGNMENT: '=';

SEMICOLON: ';';

OPEN_PARENTHESIS: '(';

CLOSE_PARENTHESIS: ')';

LINE_COMMENT: '//' .*? '\r'? ('\n' | EOF) -> skip;

MULTILINE_COMMENT: '/*' .*? '*/' -> skip;

WHITESPACE: [ \t\r\n]+ -> skip;
