package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+02489723847",
                LocalDate.of(2000, 1, 1));

        //System.out.println(new CustomerValidatorService().isValid(customer));
        //if valid We can store customer in db

        //Using combinator pattern
        ValidationResult result = isEmailValid().and(isPhoneNumberValid()).and(isAdult()).apply(customer);
        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
