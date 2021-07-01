package collection;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class Person {
    @NotBlank
    private String name; //Поле не может быть null, Строка не может быть пустой
    private LocalDate birthday; //Поле может быть null
    @Min(value = 0)
    private double height; //Значение поля должно быть больше 0
    @Min(value = 0)
    private double weight; //Значение поля должно быть больше 0
    @NotNull
    @Size(max = 40)
    private String passportID; //Длина строки не должна быть больше 40, Поле не может быть null

    public Person(String name, LocalDate birthday, double height, double weight, String passportID) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
    }
}
