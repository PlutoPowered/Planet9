package planet9.frontend.type;

import java.util.ArrayList;

public interface Type {
    Type OBJECT = new ClassType(new ArrayList<>());
    Type NULL = new NullType();


    Type BYTE = new PrimitiveType(PrimitiveType.Kind.BYTE);
    Type SHORT = new PrimitiveType(PrimitiveType.Kind.SHORT);
    Type CHAR = new PrimitiveType(PrimitiveType.Kind.CHAR);
    Type INT = new PrimitiveType(PrimitiveType.Kind.INT);
    Type LONG = new PrimitiveType(PrimitiveType.Kind.LONG);

    Type FLOAT = new PrimitiveType(PrimitiveType.Kind.FLOAT);
    Type DOUBLE = new PrimitiveType(PrimitiveType.Kind.DOUBLE);

    Type BOOLEAN = new PrimitiveType(PrimitiveType.Kind.BOOLEAN);


    boolean isAssignableTo(Type other);

    default boolean isAssignableFrom(Type other) {
        return other.isAssignableTo(this);
    }

}
