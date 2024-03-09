// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import java.util.*;

import ast.expression.*;
import codegeneration.mapl.*;

public class Value extends AbstractCodeFunction {

    private Map<String, String> instruccion = new HashMap<>();

    public Value(MaplCodeSpecification specification) {
        super(specification);

        instruccion.put("+", "add");
        instruccion.put("-", "sub");
        instruccion.put("*", "mul");
        instruccion.put("/", "div");
    }

    // class Arithmetic(Expression left, String operator, Expression right)
    // phase TypeChecking { Type type, boolean lvalue }
    @Override
    public Object visit(Arithmetic arithmetic, Object param) {

        value(arithmetic.getLeft());
        value(arithmetic.getRight());
        out(instruccion.get(arithmetic.getOperator()), arithmetic.getType());

        return null;
    }

    // class Variable(String name)
    // phase Identification { VarDefinition varDefinition }
    // phase TypeChecking { Type type, boolean lvalue }
    @Override
    public Object visit(Variable variable, Object param) {

        address(variable);
        out("load", variable.getType());

        return null;
    }

    // class IntLiteral(int intValue)
    // phase TypeChecking { Type type, boolean lvalue }
    @Override
    public Object visit(IntLiteral intLiteral, Object param) {

        out("push " + intLiteral.getIntValue());

        return null;
    }

    // class FloatLiteral(float floatValue)
    // phase TypeChecking { Type type, boolean lvalue }
    @Override
    public Object visit(FloatLiteral floatLiteral, Object param) {

        out("pushf " + floatLiteral.getFloatValue());

        return null;
    }

}
