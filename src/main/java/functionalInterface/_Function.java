package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //int increment = Increment(1);
        //System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10.apply(increment2);
        System.out.println(multiply);

        //--------------chain functions together---------------//
        Function<Integer, Integer> addByOneMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10);
        System.out.println(addByOneMultiplyBy10.apply(4));


    }
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;

    //static int Increment (int number) {
    //return number +1;
    //}
}
