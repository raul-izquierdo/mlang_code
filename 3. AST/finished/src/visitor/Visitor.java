// Generated with VGen 2.0.0

/**
* Este interfaz es el resultado de la aplicación del patrón Visitor a los nodos del AST.
*/

package visitor;

import ast.*;
import ast.type.*;
import ast.statement.*;
import ast.expression.*;




public interface Visitor {
	public Object visit(Program program, Object param);

	public Object visit(VarDefinition varDefinition, Object param);

	public Object visit(IntType intType, Object param);

	public Object visit(FloatType floatType, Object param);

	public Object visit(Print print, Object param);

	public Object visit(Assignment assignment, Object param);

	public Object visit(Arithmetic arithmetic, Object param);

	public Object visit(Variable variable, Object param);

	public Object visit(IntLiteral intLiteral, Object param);

	public Object visit(FloatLiteral floatLiteral, Object param);


}
