// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import ast.type.*;
import codegeneration.mapl.*;

public class Metadata extends AbstractCodeFunction {

    public Metadata(MaplCodeSpecification specification) {
        super(specification);
    }

    // class Program(List<VarDefinition> varDefinitions, List<Statement> statements)
    @Override
    public Object visit(Program program, Object param) {

        out("#source \"" + getSpecification().getSourceFile() + "\"");
        metadata(program.varDefinitions());

        return null;
    }

    // class VarDefinition(Type type, String name)
    // phase MemoryAllocation { int address }
    @Override
    public Object visit(VarDefinition varDefinition, Object param) {

        out("#GLOBAL " + varDefinition.getName() + ":" + getMaplName(varDefinition.getType()));

        return null;
    }

    //# ------------------------------------------------------------------
    //# Auxiliary methods

    private String getMaplName(Type type) {
        if (type instanceof IntType)
            return "int";
        if (type instanceof FloatType)
            return "float";

        // Sealed classes + pattern matching would avoid this situation. Those features were not
        // finished when this code was implemented
        throw new IllegalArgumentException("Unknown Type: " + type);
    }

}
