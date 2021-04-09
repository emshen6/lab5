package collection;

import java.time.LocalDate;

public class StudyGroup implements Comparable<StudyGroup> {
    private final int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private final LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private final FormOfEducation formOfEducation; //Поле может быть null
    private final Semester semesterEnum; //Поле не может быть null
    private final Person groupAdmin; //Поле не может быть null


    StudyGroup(int id, String name,Float x, float y, LocalDate creationDate, Long studentsCount, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        this.id = id;
        this.name = name;
        this.coordinates = Visitor.visitCoordinates(x,y);
        this.creationDate = creationDate;
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

    public String getStudyGroup() {
        String result = String.join(
                ";",
                Integer.toString(id),
                name,
                coordinates.toString(),
                creationDate.toString(),
                Long.toString(studentsCount),
                formOfEducation.getText(),
                semesterEnum.getText(),
                groupAdmin.getPerson()
        );
        return result;
    }

    public int compareTo(StudyGroup o) {
        int result = this.studentsCount.compareTo(o.studentsCount);
        if (result==0){
            result = this.name.compareTo(o.name);
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public Long getStudentsCount(){
        return studentsCount;
    }
}
