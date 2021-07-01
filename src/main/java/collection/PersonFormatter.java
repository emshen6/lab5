package collection;

public class PersonFormatter {
    public static String format(Person person) {
        String birthday;
        try {
            birthday = person.getBirthday().toString();
        } catch (NullPointerException e) {
            birthday = "null";
        }
        return String.join(
                ";",
                person.getName(),
                birthday,
                Double.toString(person.getHeight()),
                Double.toString(person.getWeight()),
                person.getPassportID()
        );
    }
}
