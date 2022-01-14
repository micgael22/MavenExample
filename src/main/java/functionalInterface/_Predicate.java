package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000056000"));
        System.out.println(isPhoneNumberValid("07000056000"));

        System.out.println("with predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000056000"));
        System.out.println(isPhoneNumberValidPredicate.test("07000056000"));


        System.out.println("Is phone number valid and contains 3 = "
                + isPhoneNumberValidPredicate.and(contains3).test("09000056000"));

        System.out.println("Is phone number valid and contains 3 = "
                + isPhoneNumberValidPredicate.and(contains3).test("07000056003"));

    }
    static Predicate<String> contains3 = phoneNumber -> phoneNumber.contains("3");

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    }
}
//Predicate<>  = Represents a predicate (boolean-valued function) of one argument