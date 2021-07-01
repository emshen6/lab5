package collection;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class StudyGroup implements Comparable<StudyGroup> {
    @Builder.Default
    private final int id = Id.last; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NotBlank
    private final String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    private final Coordinates coordinates; //Поле не может быть null
    @Builder.Default
    private final LocalDate creationDate = LocalDate.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @Min(value = 0)
    private final Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private final FormOfEducation formOfEducationEnum; //Поле может быть null
    @NotNull
    private final Semester semesterEnum; //Поле не может быть null
    @NotNull
    private final Person groupAdmin; //Поле не может быть null

    public int compareTo(StudyGroup o) {
        int result = studentsCount.compareTo(o.studentsCount);
        if (result == 0) {
            result = name.compareTo(o.name);
        }
        return result;
    }


}

