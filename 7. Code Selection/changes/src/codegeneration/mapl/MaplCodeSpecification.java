// Generated with VGen 2.0.0

/*

Esta clase es el punto de entrada a la especificación de código. Es la coordinadora de todos sus
visitors (funciones de código).

Para finalizar la implementación de esta clase:
- Copiar este fichero a su ubicación deseada en el proyecto.
- Actualizar su 'package' si es necesario.
No es necesario cambiar nada más.

Para usar esta clase:
- Invocar el método 'process(AST)' para generar el código.

Si posteriormente se necesita añadir o quitar funciones (visitors), aunque se puede hacer aquí a
mano, es más fácil indicar los cambios en el fichero de VGen y volver a generarla.

*/


package codegeneration.mapl;

import java.io.*;
import java.util.*;

import ast.AST;
import visitor.Visitor;

import codegeneration.mapl.codefunctions.*;

public class MaplCodeSpecification {

    enum CodeFunction {
        RUN, EXECUTE, VALUE, ADDRESS, METADATA
    }

    private String sourceFile;
    private PrintWriter printWriter;
    private Map<CodeFunction, Visitor> functions;

    public MaplCodeSpecification(String sourceFile, Writer writer) {

        this.sourceFile = sourceFile;
        this.printWriter = new PrintWriter(writer);

        this.functions = new EnumMap<>(CodeFunction.class);

		functions.put(CodeFunction.RUN, new Run(this));
		functions.put(CodeFunction.EXECUTE, new Execute(this));
		functions.put(CodeFunction.VALUE, new Value(this));
		functions.put(CodeFunction.ADDRESS, new Address(this));
		functions.put(CodeFunction.METADATA, new Metadata(this));

    }


    //$ Punto de entrada y lanzamiento de la primera función sobre el nodo raíz ---------

    public void process(AST ast) {
        ast.accept(functions.get(CodeFunction.RUN), null);
    }


    //$ Métodos auxiliares para los visitors de las funciones -----------------------------

    public Visitor getVisitor(CodeFunction function) {
        if (!functions.containsKey(function))
            throw new UnsupportedOperationException(
                    "Se te ha olvidado meter este visitor en la tabla hash: " + function);

        return functions.get(function);
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

}
