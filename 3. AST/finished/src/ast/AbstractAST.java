// Generated with VGen 2.0.0

package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import static java.util.stream.Collectors.joining;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	AST -> 
*/
public abstract class AbstractAST implements AST {




    // ------------------------------------------------------------
    //$ Methods for handling node Positions
    //

    private Position start, end;

    @Override
    public Position start() { return start; }

    @Override
    public Position end() { return end; }

    @Override
    public void updatePositions(Position newStart, Position newEnd) {
        if (newStart != null && (this.start == null || newStart.lessThan(this.start)))
            this.start = newStart;

        if (newEnd != null && (this.end == null || newEnd.greaterThan(this.end)))
            this.end = newEnd;
    }

    @Override
    public void updatePositions(Object... children) {
        updatePositions(Arrays.asList(children));
    }

    private void updatePositions(Object obj) {

        if (obj instanceof AST ast)
            updatePositions(ast.start(), ast.end());

        else if (obj instanceof Token token)
            updatePositions(
                    new Position(token.getLine(), token.getCharPositionInLine() + 1),
                    new Position(token.getLine(), token.getCharPositionInLine() + 1 + token.getText().length()));

        else if (obj instanceof ParserRuleContext context)
            updatePositions(unwrapANTLRContext(context));

        else if (obj instanceof Position position)
            updatePositions(position, position);

        else if (obj instanceof List<?> list)
            list.stream().forEach(this::updatePositions);
    }

    // ------------------------------------------------------------
    //$ Helper methods used in generated constructors(Object)
    //

    protected <T> List<T> castList(Object obj, Function<Object, T> mapping) {
        if (obj == null)
            return new ArrayList<>();

        if (!(obj instanceof List<?> list))
            throw new IllegalArgumentException("Argument should be a `List`. Received: " + obj.getClass());

        return list.stream().map(mapping).toList();
    }

    protected static Object unwrapANTLRContext(ParserRuleContext context) {
        var returnNames = List.of("ast", "value", "val", "ret");
        for (String name : returnNames) {
            try {
                return context.getClass().getField(name).get(context);
            } catch (Exception e) {
                // El campo no existe: probar el siguiente
            }
        }

        throw new IllegalArgumentException(
                "Return value <name> in ANTLR 'returns[<type> <name>]' is not valid. Allowed names are: "
                        + returnNames.stream().map(name -> "'" + name + "'").collect(joining(", ")));
    }

    protected static Function<Object, Object> unwrapIfContext = obj -> (obj instanceof ParserRuleContext context)
            ? unwrapANTLRContext(context)
            : obj;

    protected static Function<Object, Object> unwrapIfToken = obj -> (obj instanceof Token t) ? t.getText() : obj;

    protected Object parseIfString(Object obj, Function<String, Object> parser) {
        if (!(obj instanceof String s))
            return obj;
        return parser.apply(s);
    }

    @SuppressWarnings("unchecked")
    protected <T> Optional<T> castOptional(Object obj, Function<Object, Object> mapping, Class<T> elementType) {

        if (obj instanceof Optional<?> opt) {
            if (opt.isPresent() && !elementType.isInstance(opt.get()))
                throw new IllegalArgumentException("Optional<%s> expected".formatted(elementType.getName()));
            return (Optional<T>) opt; // Este unckeck cast es seguro porque se han comprobado los tipos con los ifs
        }

        // Si no se ha pasado un Optional, meter el obj dentro de uno haciendo antes el
        // mapping indicado
        return Optional.ofNullable(elementType.cast(mapping.apply(obj)));
    }

    protected <T> Optional<T> castOptional(Object obj, Class<T> elementType) {
        return castOptional(obj, value -> value, elementType);  // No mapping needed for obj
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
