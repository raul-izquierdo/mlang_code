package codegeneration;

import ast.*;
import visitor.DefaultVisitor;

public class MemoryAllocation extends DefaultVisitor {

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // class Program(List<VarDefinition> varDefinitions, List<Statement> statements)
    @Override
    public Object visit(Program program, Object param) {

        var currentAddress = 0;

        for (var varDefinition : program.getVarDefinitions()) {

            varDefinition.accept(this, param);

            varDefinition.setAddress(currentAddress);
            currentAddress += varDefinition.getType().getSize();
        }

        return null;
    }

}
