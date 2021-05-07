package collection;

import java.time.LocalDate;

public class StudyGroup implements Comparable<StudyGroup> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле не может быть null

    public StudyGroup(StudyGroupBuilder builder) {
        name = builder.getName();
        coordinates = builder.getCoordinates();
        creationDate = builder.getCreationDate();
        studentsCount = builder.getStudentsCount();
        formOfEducation = builder.getFormOfEducation();
        semesterEnum = builder.getSemesterEnum();
        groupAdmin = builder.getGroupAdmin();
    }

    public String toFormattedString(StudyGroupFormatter formatter) {
        return new StudyGroupFormatter().format(this);
    }

    public void setAdmin(Person admin) {
        groupAdmin = admin;
    }

    public int compareTo(StudyGroup o) {
        int result = studentsCount.compareTo(o.studentsCount);
        if (result == 0) {
            result = name.compareTo(o.name);
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public void setSemesterEnum(Semester semester) {
        semesterEnum = semester;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public Long getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Long count) {
        studentsCount = count;
    }
}
