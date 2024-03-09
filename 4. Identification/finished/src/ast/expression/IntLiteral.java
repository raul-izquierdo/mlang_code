// Generated with VGen 2.0.0

package ast.expression;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	intLiteral: expression -> intValue:int
	expression -> 
*/
public class IntLiteral extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// intLiteral: expression -> int
	private int intValue;

    // ----------------------------------
    // Constructors

	public IntLiteral(int intValue) {
		super();

		this.intValue = intValue;

		updatePositions(intValue);
	}

	public IntLiteral(Object intValue) {
		super();

        if (intValue == null)
            throw new IllegalArgumentException("Parameter 'intValue' can't be null. Pass a non-null value or use 'int?' in the abstract grammar");
        var intValue_temp = intValue;
        if (intValue_temp instanceof Token)
            intValue_temp = ((Token) intValue_temp).getText();
        if (intValue_temp instanceof String)
            intValue_temp = Integer.valueOf((String) intValue_temp);
        this.intValue = (int) intValue_temp;

		updatePositions(intValue);
	}


    // ----------------------------------
    // intLiteral: expression -> int

	// Child 'int' 

	public void setIntValue(int intValue) {
		this.intValue = intValue;

	}

    public int getIntValue() {
        return intValue;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IntLiteral{" + " intValue=" + this.getIntValue() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
