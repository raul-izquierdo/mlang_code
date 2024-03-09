// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	variable: expression -> name:string
	expression -> 
	
	PHASE Identification
	variable -> varDefinition:varDefinition
	
	PHASE TypeChecking
	expression -> type:type
	expression -> lvalue:boolean
*/
public class Variable extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// variable: expression -> string
	private String name;

    // PHASE Identification
	private VarDefinition varDefinition;

    // ----------------------------------
    // Constructors

	public Variable(String name) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		updatePositions(name);
	}

	public Variable(Object name) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

		updatePositions(name);
	}


    // ----------------------------------
    // variable: expression -> string

	// Child 'string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }



    // --------------------------------
    // PHASE Identification

	// Attribute 'varDefinition' 

	public void setVarDefinition(VarDefinition varDefinition) {
		if (varDefinition == null)
			throw new IllegalArgumentException("Parameter 'varDefinition' can't be null. Pass a non-null value or use 'varDefinition?' in the abstract grammar");
		this.varDefinition = varDefinition;

	}

    public VarDefinition getVarDefinition() {
        return varDefinition;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Variable{" + " name=" + this.getName() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
