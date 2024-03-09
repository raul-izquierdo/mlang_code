grammar Grammar;

import Tokenizer;

@header {
	    import ast.*;
	    import ast.type.*;
	    import ast.statement.*;
	    import ast.expression.*;
}

// --------------------------------------------------------------------
// Solución 1. Versión básica sin posiciones del fichero en el AST.
// - A los constructores se les pasa sólo el lexema de los Tokens ('$TOKEN.text').

// program returns[Program ast]
// 	: 'DATA' varDefinitions 'CODE' statements EOF { $ast = new Program($varDefinitions.list, $statements.list); }
// 	;

// varDefinitions returns[List<VarDefinition> list = new ArrayList<VarDefinition>()]
// 	: (varDefinition { $list.add($varDefinition.ast); })*
// 	;

// statements returns[List<Statement> list = new ArrayList<Statement>()]
// 	: (statement { $list.add($statement.ast); })*
// 	;

// varDefinition returns[VarDefinition ast]
// 	: type IDENT ';' { $ast = new VarDefinition($type.ast, $IDENT.text); }
// 	;

// type returns[Type ast]
// 	: 'int'		{ $ast = new IntType(); }
// 	| 'float'	{ $ast = new FloatType(); }
// 	;

// statement returns[Statement ast]
// 	: 'print' expression ';'					{ $ast = new Print($expression.ast); }
// 	| left=expression '=' right=expression ';'	{ $ast = new Assignment($left.ast, $right.ast); }
// 	;

// expression returns[Expression ast]
// 	: left=expression op=('*' | '/') right=expression	{ $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
// 	| left=expression op=('+' | '-') right=expression	{ $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
// 	| '(' expression ')'								{ $ast = $expression.ast; }
// 	| IDENT												{ $ast = new Variable($IDENT.text); }
// 	| INT_LITERAL										{ $ast = new IntLiteral($INT_LITERAL.text); }
// 	| FLOAT_LITERAL										{ $ast = new FloatLiteral($FLOAT_LITERAL.text); }
// 	;

// --------------------------------------------------------------------
// Solución 2. Versión con posiciones del fichero en el AST (requiere VGen).
// - A los constructores se les pasa el objeto Token completo ('$TOKEN' -> sin ".text").

program returns[Program ast]
	: 'DATA' varDefinitions 'CODE' statements EOF { $ast = new Program($varDefinitions.list, $statements.list); }
	;

varDefinitions returns[List<VarDefinition> list = new ArrayList<VarDefinition>()]
	: (varDefinition { $list.add($varDefinition.ast); })*
	;

statements returns[List<Statement> list = new ArrayList<Statement>()]
	: (statement { $list.add($statement.ast); })*
	;

varDefinition returns[VarDefinition ast]
	: type IDENT ';' { $ast = new VarDefinition($type.ast, $IDENT); }
	;

type returns[Type ast]
	: 'int'		{ $ast = new IntType(); }
	| 'float'	{ $ast = new FloatType(); }
	;

statement returns[Statement ast]
	: 'print' expression ';'					{ $ast = new Print($expression.ast); }
	| left=expression '=' right=expression ';'	{ $ast = new Assignment($left.ast, $right.ast); }
	;

expression returns[Expression ast]
	: left=expression op=('*' | '/') right=expression	{ $ast = new Arithmetic($left.ast, $op, $right.ast); }
	| left=expression op=('+' | '-') right=expression	{ $ast = new Arithmetic($left.ast, $op, $right.ast); }
	| '(' expression ')'								{ $ast = $expression.ast; }
	| IDENT												{ $ast = new Variable($IDENT); }
	| INT_LITERAL										{ $ast = new IntLiteral($INT_LITERAL); }
	| FLOAT_LITERAL										{ $ast = new FloatLiteral($FLOAT_LITERAL); }
	;

// --------------------------------------------------------------------
// Solución 3. Versión simplificada y con posiciones del fichero en el AST (requiere VGen).
// - Se usa el operador '+=' de ANTLR para simplificar la gramática (desaparecen las reglas 'varDefinitions' y 'statements').

// program returns[Program ast]
// 	: 'DATA' definitions+=varDefinition* 'CODE' statements+=statement* EOF { $ast = new Program($definitions, $statements); }
// 	;

// varDefinition returns[VarDefinition ast]
// 	: type IDENT ';' { $ast = new VarDefinition($type.ast, $IDENT); }
// 	;

// type returns[Type ast]
// 	: 'int'		{ $ast = new IntType(); }
// 	| 'float'	{ $ast = new FloatType(); }
// 	;

// statement returns[Statement ast]
// 	: 'print' expression ';'					{ $ast = new Print($expression.ast); }
// 	| left=expression '=' right=expression ';'	{ $ast = new Assignment($left.ast, $right.ast); }
// 	;

// expression returns[Expression ast]
// 	: left=expression op=('*' | '/') right=expression	{ $ast = new Arithmetic($left.ast, $op, $right.ast); }
// 	| left=expression op=('+' | '-') right=expression	{ $ast = new Arithmetic($left.ast, $op, $right.ast); }
// 	| '(' expression ')'								{ $ast = $expression.ast; }
// 	| IDENT												{ $ast = new Variable($IDENT); }
// 	| INT_LITERAL										{ $ast = new IntLiteral($INT_LITERAL); }
// 	| FLOAT_LITERAL										{ $ast = new FloatLiteral($FLOAT_LITERAL); }
// 	;
