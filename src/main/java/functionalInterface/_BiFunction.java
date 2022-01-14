package functionalInterface;

import java.util.function.BiFunction;

public class _BiFunction {
    public static void main(String[] args) {
        System.out.println(incrementBy1AndMultiply(4,100));

        System.out.println(incrementBy1AndMultiplyBi.apply(4,100));

    }
    //Function takes 2 argument and produces 2 result
    static BiFunction <Integer, Integer, Integer> incrementBy1AndMultiplyBi =
            (numToIncrementByOne, numToMultiply) -> (numToIncrementByOne +1) * numToMultiply;

    static int incrementBy1AndMultiply (int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
