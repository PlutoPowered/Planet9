import planet9.frontend.type.ClassType;
import planet9.frontend.type.GenericType;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        ClassType A = new ClassType(new ArrayList<>());
        ClassType B = new ClassType(Arrays.asList(A));
        ClassType C = new ClassType(Arrays.asList(B));
        ClassType D = new ClassType(Arrays.asList(C));
        ClassType E = new ClassType(Arrays.asList(D));

        GenericType G = new GenericType(B, D);

        System.out.println(A.isAssignableTo(G));
        System.out.println(B.isAssignableTo(G));
        System.out.println(C.isAssignableTo(G));
        System.out.println(D.isAssignableTo(G));
        System.out.println(E.isAssignableTo(G));

    }

}
