package collection;

public class PersonFormatter {
    public static String format(Person person) {
        return String.join(
                ";",
                person.getName(),
                person.getBirthday().toString(),
                Double.toString(person.getHeight()),
                Double.toString(person.getWeight()),
                person.getPassportID()
        );
    }
}
