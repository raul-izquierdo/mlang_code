/**
 * MLang. Programming Language Design Tutorial
 * @author Raúl Izquierdo (raul@uniovi.es)
 */

package main;

import ast.*;

public class ErrorManager {

    private int errorsCount = 0;

    public void notify(String phase, String message, Position position) {

        var text = "Error in " + phase + ": ";

        if (position != null)
            text += "[" + position + "] ";

        notify(text + message);
    }

    public void notify(String phase, String message) {
        notify(phase, message, null);
    }

    public void notify(String message) {
        errorsCount++;
        System.out.println(message);
    }

    public int errorsCount() {
        return errorsCount;
    }

}
