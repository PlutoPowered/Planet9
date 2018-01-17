package planet9.frontend.type;

public class NullType implements Type {

    @Override
    public boolean isAssignableTo(Type other) {
        return other instanceof NullType;
    }

}
