package collection;

import java.time.LocalDate;

public class Person {
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final LocalDate birthday; //Поле может быть null
    private final double height; //Значение поля должно быть больше 0
    private final double weight; //Значение поля должно быть больше 0
    private final String passportID; //Длина строки не должна быть больше 40, Поле не может быть null

    Person(String name, LocalDate birthday, double height, double weight, String passportID) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
    }

    public String getPerson() {
        String result = String.join(";",
                name,
                birthday.toString(),
                Double.toString(height),
                Double.toString(weight),
                passportID
        );
        return result;
    }
}
