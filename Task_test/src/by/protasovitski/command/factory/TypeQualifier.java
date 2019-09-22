package by.protasovitski.command.factory;

import javax.enterprise.util.AnnotationLiteral;

public class TypeQualifier extends AnnotationLiteral<Type> implements Type {
    private CommandType type;

    public TypeQualifier(CommandType type) {
        this.type = type;
    }

    @Override
    public CommandType value() {
        return type;
    }
}
