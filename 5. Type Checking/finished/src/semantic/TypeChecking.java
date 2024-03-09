/**
 * MLang. Programming Language Design Tutorial
 * @author Raúl Izquierdo (raul@uniovi.es)
 */

package semantic;

import ast.*;
import ast.expression.*;
import ast.statement.Assignment;
import ast.type.*;
import main.ErrorManager;
import visitor.DefaultVisitor;

public class TypeChecking extends DefaultVisitor {

    private ErrorManager errorManager;

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // # ----------------------------------------------------------

    // class Assignment(Expression left, Expression right)
    @Override
    public Object visit(Assignment assignment, Object param) {

        super.visit(assignment, param);

        predicate(sameType(assignment.getLeft(), assignment.getRight()), "The expression types don't match",
                assignment);
        predicate(assignment.getLeft().isLvalue(),
                "The expression on the left is not modifiable",
                assignment.getLeft());

        return null;
    }

    // class Arithmetic(Expression left, String operator, Expression right)
    // phase TypeChecking { Type type, boolean lvalue }
    @Override
    public Object visit(Arithmetic arithmetic, Object param) {

        super.visit(arithmetic, param);

        predicate(sameType(arithmetic.getLeft(), arithmetic.getRight()), "The expression types don't match",
                arithmetic);

        arithmetic.setType(arithmetic.getLeft().getType());
        arithmetic.setLvalue(false);

        return null;
    }

    // class Variable(String name)
    // phase Identification { VarDefinition varDefinition }
    // phase TypeChecking { Type type, boolean lvalue }
    @Override
    public Object visit(Variable variable, Object param) {

        variable.setType(variable.getVarDefinition().getType());
        variable.setLvalue(true);

        return null;
    }

    // class IntLiteral(int intValue)
    // phase TypeChecking { Type type, boolean lvalue }
    @Override
    public Object visit(IntLiteral intLiteral, Object param) {

        intLiteral.setType(new IntType());
        intLiteral.setLvalue(false);

        return null;
    }

    // class FloatLiteral(float floatValue)
    // phase TypeChecking { Type type, boolean lvalue }
    @Override
    public Object visit(FloatLiteral floatLiteral, Object param) {

        floatLiteral.setType(new FloatType());
        floatLiteral.setLvalue(false);

        return null;
    }
    //# ----------------------------------------------------------
    //# Auxiliary methods (optional)

    private boolean sameType(Expression a, Expression b) {
        return (a.getType().getClass() == b.getType().getClass());
    }

    private void notifyError(String errorMessage, Position position) {
        errorManager.notify("Type Checking", errorMessage, position);
    }

    /**
     * predicate. Auxiliary method to implement predicates. Delete if not needed.
     *
     * Usage examples:
     *
     *    predicate(expr.type != null), "Type cannot be null", expr.start());
     *
     *    predicate(expr.type != null), "Type cannot be null", expr);       // expr.start() is assumed
     *
     * The start() method (example 1) indicates the position in the file where the node was. If VGen is used, this method
     * will have been generated in all AST nodes.
     *
     * @param condition     Must be met to avoid an error
     * @param errorMessage  Printed if the condition is not met
     * @param errorPosition Row and column in the file where the error occurred.
     * @return true if the condition is met
     */

    private boolean predicate(boolean condition, String errorMessage, Position position) {
        if (!condition) {
            notifyError(errorMessage, position);
            return false;
        }

        return true;
    }

    private boolean predicate(boolean condition, String errorMessage, AST node) {
        return predicate(condition, errorMessage, node.start());
    }

}
