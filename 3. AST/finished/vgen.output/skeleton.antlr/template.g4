// Generated with VGen 2.0.0

grammar Grammar;

@header {
	    import ast.expression.*;
	    import ast.statement.*;
	    import ast.type.*;
	    import ast.*;
}

program returns[Program ast]
    : varDefinitions+=varDefinition* statements+=statement* { $ast = new Program($varDefinitions, $statements); }  
	;

varDefinition returns[VarDefinition ast]
    : type name=IDENT                     { $ast = new VarDefinition($type.ast, $name); }        
	;

type returns[Type ast]
    :                                     { $ast = new IntType(); }                              
    |                                     { $ast = new FloatType(); }                            
	;

statement returns[Statement ast]
    : expression                          { $ast = new Print($expression.ast); }                 
    | left=expression right=expression    { $ast = new Assignment($left.ast, $right.ast); }      
	;

expression returns[Expression ast]
    : left=expression operator=IDENT right=expression { $ast = new Arithmetic($left.ast, $operator, $right.ast); }
    | name=IDENT                          { $ast = new Variable($name); }                        
    | INT_LITERAL                         { $ast = new IntLiteral($INT_LITERAL); }               
    | FLOAT_LITERAL                       { $ast = new FloatLiteral($FLOAT_LITERAL); }           
	;


// ---------------------------------------------------------------
// Tokens

IDENT: [a-zA-Z_][a-zA-Z0-9_]*;
FLOAT_LITERAL: [0-9]+ '.' [0-9]+;
INT_LITERAL: [0-9]+;
