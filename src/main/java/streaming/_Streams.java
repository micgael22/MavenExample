package streaming;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*public class _Streams {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Jill", Gender.FEMALE),
                new Person("John", Gender.MALE),
                new Person("Becky", Gender.FEMALE),
                new Person("Amy", Gender.FEMALE),
                new Person("Bob", Gender.PREFER_NOT_TO_SAY)
        );
        people.stream().map(person -> person.name).collect(Collectors.toSet()).forEach(System.out::println);
        people.stream().map(person -> person.name).mapToInt(String::length).forEach(System.out::println);

        //Predicate<Person> PersonPredicate = person -> Gender.PREFER_NOT_TO_SAY.equals(person.gender);
        //boolean containsOnlyFemales = people.stream().noneMatch(PersonPredicate);
        //System.out.println(containsOnlyFemales);
    }
    static class Person {
        private final String name;
        private final Gender gender;

        Person (String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
        @Override
        public String toString() {
            return "Person{" + "name = " + name + '\\' + " gender = " + gender + '}';
        }
    }
    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
*/