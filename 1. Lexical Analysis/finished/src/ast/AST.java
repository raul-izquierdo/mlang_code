package ast;

import visitor.Visitor;

// This class will be implemented in syntax analysis phase

public interface AST {

    Position start();

    Position end();

    public Object accept(Visitor visitor, Object param);

}
