package planet9.frontend.type;

public class GenericType implements Type {
    private Type upperBound;
    private Type lowerBound;
    private Kind kind;

    public GenericType(Type upperBound, Type lowerBound) {
        if (upperBound == null && lowerBound == null) {
            upperBound = Type.OBJECT;
        }

        this.upperBound = upperBound;
        this.lowerBound = lowerBound;

        this.kind = upperBound != null && lowerBound != null ? Kind.BOTH :
                upperBound != null ? Kind.UPPER : Kind.LOWER;
    }

    public Kind getKind() {
        return this.kind;
    }

    public Type getUpperBound() {
        return upperBound;
    }

    public Type getLowerBound() {
        return lowerBound;
    }

    @Override
    public boolean isAssignableTo(Type other) {
        switch (kind) {
            case LOWER:
                return other.isAssignableTo(lowerBound);
            case UPPER:
                return upperBound.isAssignableTo(other);
            case BOTH:
                return upperBound.isAssignableTo(other) && other.isAssignableTo(lowerBound);
            default:
                return false;
        }
    }

    public enum Kind {
        LOWER,
        UPPER,
        BOTH,
    }

}
