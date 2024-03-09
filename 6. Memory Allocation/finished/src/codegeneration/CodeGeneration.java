/**
 * MLang. Programming Language Design Tutorial
 * @author Raúl Izquierdo (raul@uniovi.es)
 */

package codegeneration;

import java.io.Writer;

import ast.AST;
import codegeneration.mapl.MaplCodeSpecification;

/**
 * This class coordinates the two main phases of Code Generation:
 * 1. Memory Allocation.
 * 2. Code Selection.
 *
 * It is not necessary to modify this class. Instead, you should modify the classes
 * that are called from here: "MemoryAllocation.java" and "MaplCodeSpecification.java".
 */
public class CodeGeneration {

    public void generate(String sourceFile, AST ast, Writer out) {

        // This check can be removed in the final version when de AST is generated
        if (ast == null)
            return;

        var allocator = new MemoryAllocation();
        allocator.process(ast);

        var specification = new MaplCodeSpecification(sourceFile, out);
        specification.process(ast);

    }

}
