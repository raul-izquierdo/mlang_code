// Generated with VGen 2.0.0

package ast;

import ast.statement.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	program -> varDefinitions:varDefinition* statements:statement*
*/
public class Program extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// program -> varDefinition* statement*
	private List<VarDefinition> varDefinitions;
	private List<Statement> statements;

    // ----------------------------------
    // Constructors

	public Program(List<VarDefinition> varDefinitions, List<Statement> statements) {
		super();

		if (varDefinitions == null)
			varDefinitions = new ArrayList<>();
		this.varDefinitions = varDefinitions;

		if (statements == null)
			statements = new ArrayList<>();
		this.statements = statements;

		updatePositions(varDefinitions, statements);
	}

	public Program(Object varDefinitions, Object statements) {
		super();

        this.varDefinitions = castList(varDefinitions, unwrapIfContext.andThen(VarDefinition.class::cast));
        this.statements = castList(statements, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(varDefinitions, statements);
	}


    // ----------------------------------
    // program -> varDefinition* statement*

	// Child 'varDefinition*' 

	public void setVarDefinitions(List<VarDefinition> varDefinitions) {
		if (varDefinitions == null)
			varDefinitions = new ArrayList<>();
		this.varDefinitions = varDefinitions;

	}

    public List<VarDefinition> getVarDefinitions() {
        return varDefinitions;
    }

    public Stream<VarDefinition> varDefinitions() {
        return varDefinitions.stream();
    }


	// Child 'statement*' 

	public void setStatements(List<Statement> statements) {
		if (statements == null)
			statements = new ArrayList<>();
		this.statements = statements;

	}

    public List<Statement> getStatements() {
        return statements;
    }

    public Stream<Statement> statements() {
        return statements.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Program{" + " varDefinitions=" + this.getVarDefinitions() + " statements=" + this.getStatements() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
