package collection;

import util.ClientOutput;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;

public class StudyGroupBuilder {
    private StudyGroup result;
    private String name;
    private Coordinates coordinates;
    private final LocalDate creationDate = LocalDate.now();
    private Long studentsCount;
    private FormOfEducation formOfEducation;
    private Semester semesterEnum;
    private Person groupAdmin;

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getStudentsCount() {
        return studentsCount;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public StudyGroupBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudyGroup build() {
        return new StudyGroup(this);
    }

    public void setId(int id) {
        result.setId(id);
    }

    public void setGroupName(String name) {
        result.setName(name);
    }

    public void setCoordinates(String x, String y) {
        Coordinates coordinates = new Coordinates(Float.parseFloat(x), Float.parseFloat(y));
        result.setCoordinates(coordinates);
    }


    public void setCoordinates(String x) {
        Coordinates coordinates = new Coordinates(Float.parseFloat(x));
    }


    public void setCreationDate(LocalDate date) {
        result.setCreationDate(date);
    }


    public void setStudentsCount(String count) {
        result.setStudentsCount(Long.parseLong(count));
    }


    public void setFormOfEducation(String formOfEducation) {
        HashMap<String, FormOfEducation> list = new HashMap<String, FormOfEducation>() {{
            put("DISTANCE_EDUCATION", FormOfEducation.DISTANCE_EDUCATION);
            put("FULL_TIME_EDUCATION", FormOfEducation.FULL_TIME_EDUCATION);
            put("EVENING_CLASSES", FormOfEducation.EVENING_CLASSES);
        }};
        FormOfEducation arg = list.get(formOfEducation);
        result.setFormOfEducation(arg);
    }


    public void setSemester(String semester) {
        HashMap<String, Semester> list = new HashMap<String, Semester>() {{
            put("FIRST", Semester.FIRST);
            put("SECOND", Semester.SECOND);
            put("FIFTH", Semester.FIFTH);
            put("THIRD", Semester.THIRD);
            put("SEVENTH", Semester.SEVENTH);
        }};
        Semester arg = list.get(semester);
        result.setSemesterEnum(arg);
    }


    public void setAdmin(String name, String birthday, String height, String weight, String passportID) {
        System.out.println(birthday);
        LocalDate date = LocalDate.parse(birthday);
        Person admin = new Person(name, date, Double.parseDouble(height), Double.parseDouble(weight), passportID);
        result.setAdmin(admin);
    }

    public void userInput() {
        Scanner sc = new Scanner(System.in);
        try {
            ClientOutput.print("Enter group name:");
            String line = sc.nextLine();
            setGroupName(line);
            ClientOutput.print("Enter x:");
            line = sc.nextLine();
            String x = line;
            ClientOutput.print("Enter y or null:");
            line = sc.nextLine();
            if (line.equals("null")) {
                setCoordinates(x);
            } else {
                setCoordinates(x, line);
            }
            ClientOutput.print("Enter students count:");
            line = sc.nextLine();
            setStudentsCount(line);
            ClientOutput.print("Choose form of education (DISTANCE_EDUCATION/FULL_TIME_EDUCATION/EVENING_CLASSES):");
            line = sc.nextLine();
            setFormOfEducation(line);
            ClientOutput.print("Choose semester (FIRST/SECOND/THIRD/FIFTH/SEVENTH):");
            line = sc.nextLine();
            setSemester(line);
            ClientOutput.print("Enter admin's name:");
            String adminName = sc.nextLine();
            ClientOutput.print("Enter admin's birthday (Example: 2005-06-07):");
            String adminBirthday = sc.nextLine();
            ClientOutput.print("Enter admin's height:");
            String height = sc.nextLine();
            ClientOutput.print("Enter admin's weight:");
            String weight = sc.nextLine();
            ClientOutput.print("Enter admin's passport ID:");
            String adminPassportID = sc.nextLine();
            setAdmin(adminName, adminBirthday, height, weight, adminPassportID);
        } catch (NumberFormatException | DateTimeParseException e) {
            ClientOutput.print("Enter correct data!");
        }
    }

    public StudyGroup getResult() {
        return result;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
