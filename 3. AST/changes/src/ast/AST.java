// Generated with VGen 2.0.0

package ast;

import visitor.Visitor;



/*
	AST -> 
*/
public interface AST {



    // ------------------------------
    // AST Methods

    public Object accept(Visitor visitor, Object param);

    Position start();
    Position end();

    public void updatePositions(Object... children);
    public void updatePositions(Position newStart, Position newEnd);




}
