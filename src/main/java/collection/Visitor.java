package collection;

import execeptions.MaxValueReachedException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface Visitor {
    static FormOfEducation visitFormOfEducation(String formOfEducation) {
        if (formOfEducation.equals("DISTANCE_EDUCATION")) {
            return FormOfEducation.DISTANCE_EDUCATION;
        } else if (formOfEducation.equals("FULL_TIME_EDUCATION")) {
            return FormOfEducation.FULL_TIME_EDUCATION;
        } else if (formOfEducation.equals("EVENING_CLASSES")) {
            return FormOfEducation.EVENING_CLASSES;
        } else return null;
    }

    static Semester visitSemester(String semester) {
        if (semester.equals("FIRST")) {
            return Semester.FIRST;
        } else if (semester.equals("SECOND")) {
            return Semester.SECOND;
        } else if (semester.equals("THIRD")) {
            return Semester.THIRD;
        } else if (semester.equals("FIFTH")) {
            return Semester.FIFTH;
        } else if (semester.equals("SEVENTH")) {
            return Semester.SEVENTH;
        } else return null;
    }

    static Person visitPerson(String name, String birthday, String height, String weight, String passportID) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate localDate = LocalDate.parse(birthday, formatter);
        return new Person(name, localDate, Double.parseDouble(height), Double.parseDouble(weight), passportID);
    }

    //Validation
    static Coordinates visitCoordinates(Float x, float y){
        if ((x>429)||(y>398)){
            throw new MaxValueReachedException();
        } else return new Coordinates(x,y);
    }

}
