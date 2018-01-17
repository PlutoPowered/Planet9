package planet9.frontend.type;

public class PrimitiveType implements Type {
    private Kind kind;

    public PrimitiveType(Kind kind) {
        this.kind = kind;
    }

    @Override
    public boolean isAssignableTo(Type other) {
        if (other instanceof PrimitiveType) {
            Kind otherKind = ((PrimitiveType) other).kind;
            if (otherKind == this.kind) {
                return true;
            } else if ((otherKind.isInteger() && this.kind.isInteger()) || (otherKind.isDecimal() && this.kind.isDecimal())) {
                return otherKind.getHeight() > this.kind.getHeight();
            }
        }
        return false;
    }

    public enum Kind {
        BYTE(true, false, 0),
        SHORT(true, false, 1),
        CHAR(true, false, 1),
        INT(true, false, 2),
        LONG(true, false, 3),

        FLOAT(false, true, 0),
        DOUBLE(false, true, 0),

        BOOLEAN(false, false, 0);

        private boolean integer;
        private boolean decimal;
        private int height;

        Kind(boolean integer, boolean decimal, int height) {
            this.integer = integer;
            this.decimal = decimal;
            this.height = height;
        }

        public boolean isInteger() {
            return integer;
        }

        public boolean isDecimal() {
            return decimal;
        }

        public int getHeight() {
            return height;
        }
    }

}
