/**
 * MLang. Programming Language Design Tutorial
 * @author Raúl Izquierdo (raul@uniovi.es)
 */

package semantic;

import main.*;
import ast.*;

/**
 * This class coordinates the two main phases of Semantic Analysis:
 * 1. Identification phase.
 * 2. Type Checking phase.
 *
 * It is not necessary to modify this class. Instead, you should modify the classes
 * that are called from here: "Identification.java" and "TypeChecking.java".
 */
public class SemanticAnalisys {

    public SemanticAnalisys(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void analize(AST ast) {

        // This check can be removed in the final version when de AST is generated
        if (ast == null)
            return;

        var identification = new Identification(errorManager);
        identification.process(ast);

        if (errorManager.errorsCount() > 0)
            return;

        var checking = new TypeChecking(errorManager);
        checking.process(ast);
    }

    private ErrorManager errorManager;
}
