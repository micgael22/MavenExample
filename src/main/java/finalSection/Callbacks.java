package finalSection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        hello("John", null, value -> {
            System.out.println("No lastName provided for " + value);
        });

        hello2("John", null, (value)-> System.out.println("No lastName provided"));
    }
    static void hello (String firstName, String lastName, Consumer <String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        }
        else {
            callback.accept(firstName);
        }
    }
    static void hello2 (String firstName, String lastName, Consumer <String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        }
        else {
            callback.accept(firstName);
        }
    }
}
