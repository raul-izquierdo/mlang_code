package semantic;

import java.util.*;

import ast.*;
import ast.expression.Variable;
import main.ErrorManager;
import visitor.DefaultVisitor;

// This class will be implemented in identification phase

public class Identification extends DefaultVisitor {

    private ErrorManager errorManager;
    private Map<String, VarDefinition> variables = new HashMap<>();

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // # ----------------------------------------------------------
    // class VarDefinition(Type type, String name)
    @Override
    public Object visit(VarDefinition varDefinition, Object param) {
        var definition = variables.get(varDefinition.getName());
        if (definition != null)
            notifyError("Variable already defined: " + varDefinition.getName(), varDefinition);
        else
            variables.put(varDefinition.getName(), varDefinition);
        return null;
    }

    // class Variable(String name)
    // phase Identification { VarDefinition varDefinition }
    @Override
    public Object visit(Variable variable, Object param) {

        var definition = variables.get(variable.getName());
        if (definition == null)
            notifyError("Undefined variable: " + variable.getName(), variable);
        else
            variable.setVarDefinition(definition);
        return null;
    }

    // # --------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    private void notifyError(String msg) {
        errorManager.notify("Identification", msg);
    }

    private void notifyError(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }

    private void notifyError(String msg, AST node) {
        notifyError(msg, node.start());
    }

}
