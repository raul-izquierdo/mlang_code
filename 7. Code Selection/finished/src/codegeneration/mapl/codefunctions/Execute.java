// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import ast.statement.*;
import codegeneration.mapl.*;

public class Execute extends AbstractCodeFunction {

    public Execute(MaplCodeSpecification specification) {
        super(specification);
    }

    // class Print(Expression expression)
    @Override
    public Object visit(Print print, Object param) {

        line(print);

        value(print.getExpression());
        out("out", print.getExpression().getType());

        return null;
    }

    // class Assignment(Expression left, Expression right)
    @Override
    public Object visit(Assignment assignment, Object param) {

        line(assignment);

        address(assignment.getLeft());
        value(assignment.getRight());
        out("store", assignment.getLeft().getType());

        return null;
    }

    // Auxiliary methods for the generation of code

    private void line(AST node) {
        line(node.end());
    }

    private void line(Position pos) {
        if (pos != null)
            out("\n#line " + pos.getLine());
        else
            System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
    }
}
