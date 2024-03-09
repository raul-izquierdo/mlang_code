// Generated with VGen 2.0.0

/*

Esta es la clase base de todos los visitors correspondientes a las funciones de código. Contiene los
métodos que permiten invocar a las distintas funciones haciendo transparente el cambio entre
visitors.

Para su uso, sólo hay que copiarla a su ubicación deseada en el proyecto actualizando su 'package'.
NO ES NECESARIO añadir nada más para usarla.

NOTA: Si hay código que se use en varios visitor, esta clase puede ser un lugar candidato para
ubicarlo. Sin embargo, si se regenera esta clase, acordarse de no borrar dicho código.

*/

package codegeneration.mapl;

import java.util.stream.Stream;
import java.util.Optional;

import ast.AST;
import ast.type.*;
import visitor.ExceptionThrowerVisitor;

/**
 * Common code for all Code Functions.
 */

public abstract class AbstractCodeFunction extends ExceptionThrowerVisitor {

    private MaplCodeSpecification specification;

    protected AbstractCodeFunction(MaplCodeSpecification specification) {
        this.specification = specification;
    }

    protected MaplCodeSpecification getSpecification() {
        return specification;
    }

    //# ------------------------------------------------------------------
    // Métodos auxiliares para la escritura de código

    protected void out(String line) {
        specification.getPrintWriter().println(line);
    }

    protected void out(String instruction, Type type) {
        out(instruction + suffixFor(type));
    }

    protected String suffixFor(Type type) {
        if (type instanceof IntType)
            return "i";
        if (type instanceof FloatType)
            return "f";

        // Sealed classes + pattern matching would avoid this situation. Those features were not
        // finished when this code was implemented
        throw new IllegalArgumentException("Unknown Type: " + type);
    }

    //# ------------------------------------------------------------------
    //# Método genérico para invocar cualquier función de código

    protected Object accept(MaplCodeSpecification.CodeFunction function, AST node, Object param) {
        return node.accept(specification.getVisitor(function), param);
    }

    //# ------------------------------------------------------------------
    //# Métodos específicos para cada función de código

    // Code Function: 'run'

    protected Object run(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.RUN), param);
    }

    protected Object run(AST node) {
        return run(node, null);
    }

    protected <T extends AST> void run(Stream<T> nodes, Object param) {
        nodes.forEach(node -> run(node, param));
    }

    protected <T extends AST> void run(Stream<T> nodes) {
        nodes.forEach(this::run);
    }

    protected <T extends AST> Object run(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> run(node, param)).orElse(null);
    }

    protected <T extends AST> Object run(Optional<T> optionalNode) {
        return optionalNode.map(this::run).orElse(null);
    }

    // Code Function: 'execute'

    protected Object execute(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.EXECUTE), param);
    }

    protected Object execute(AST node) {
        return execute(node, null);
    }

    protected <T extends AST> void execute(Stream<T> nodes, Object param) {
        nodes.forEach(node -> execute(node, param));
    }

    protected <T extends AST> void execute(Stream<T> nodes) {
        nodes.forEach(this::execute);
    }

    protected <T extends AST> Object execute(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> execute(node, param)).orElse(null);
    }

    protected <T extends AST> Object execute(Optional<T> optionalNode) {
        return optionalNode.map(this::execute).orElse(null);
    }

    // Code Function: 'value'

    protected Object value(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.VALUE), param);
    }

    protected Object value(AST node) {
        return value(node, null);
    }

    protected <T extends AST> void value(Stream<T> nodes, Object param) {
        nodes.forEach(node -> value(node, param));
    }

    protected <T extends AST> void value(Stream<T> nodes) {
        nodes.forEach(this::value);
    }

    protected <T extends AST> Object value(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> value(node, param)).orElse(null);
    }

    protected <T extends AST> Object value(Optional<T> optionalNode) {
        return optionalNode.map(this::value).orElse(null);
    }

    // Code Function: 'address'

    protected Object address(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.ADDRESS), param);
    }

    protected Object address(AST node) {
        return address(node, null);
    }

    protected <T extends AST> void address(Stream<T> nodes, Object param) {
        nodes.forEach(node -> address(node, param));
    }

    protected <T extends AST> void address(Stream<T> nodes) {
        nodes.forEach(this::address);
    }

    protected <T extends AST> Object address(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> address(node, param)).orElse(null);
    }

    protected <T extends AST> Object address(Optional<T> optionalNode) {
        return optionalNode.map(this::address).orElse(null);
    }

    // Code Function: 'metadata'

    protected Object metadata(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.METADATA), param);
    }

    protected Object metadata(AST node) {
        return metadata(node, null);
    }

    protected <T extends AST> void metadata(Stream<T> nodes, Object param) {
        nodes.forEach(node -> metadata(node, param));
    }

    protected <T extends AST> void metadata(Stream<T> nodes) {
        nodes.forEach(this::metadata);
    }

    protected <T extends AST> Object metadata(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> metadata(node, param)).orElse(null);
    }

    protected <T extends AST> Object metadata(Optional<T> optionalNode) {
        return optionalNode.map(this::metadata).orElse(null);
    }

}
