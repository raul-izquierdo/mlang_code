// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.expression.*;
import codegeneration.mapl.*;

public class Address extends AbstractCodeFunction {

    public Address(MaplCodeSpecification specification) {
        super(specification);
    }

    // class Variable(String name)
    // phase Identification { VarDefinition varDefinition }
    // phase TypeChecking { Type type, boolean lvalue }
    @Override
    public Object visit(Variable variable, Object param) {

        out("pusha " + variable.getVarDefinition().getAddress());

        return null;
    }

}
