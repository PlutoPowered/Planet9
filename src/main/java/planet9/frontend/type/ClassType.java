package planet9.frontend.type;

import java.util.List;

public class ClassType implements Type {
    private List<ClassType> parents;

    public ClassType(List<ClassType> parents) {
        this.parents = parents;
    }

    public List<ClassType> parents() {
        return parents;
    }

    @Override
    public boolean isAssignableTo(Type other) {
        if (other instanceof ClassType) {
            return this.equals(other) || this.parents.stream().anyMatch(c -> c.isAssignableTo(other));
        } else if (other instanceof IntersectionType) {
            for (Type x : ((IntersectionType) other).types()) {
                if (!this.isAssignableTo(x)) {
                    return false;
                }
            }
            return true;
        } else if (other instanceof UnionType) {
            for (Type x : ((UnionType) other).types()) {
                if (this.isAssignableTo(x)) {
                    return true;
                }
            }
            return false;
        } else if (other instanceof GenericType) {
            GenericType type = (GenericType) other;
            switch (type.getKind()) {
                case LOWER:
                    return type.getLowerBound().isAssignableTo(this);
                case UPPER:
                    return this.isAssignableTo(type.getUpperBound());
                case BOTH:
                    return type.getLowerBound().isAssignableTo(this) && this.isAssignableTo(type.getUpperBound());
            }
        }
        return false;
    }

}
