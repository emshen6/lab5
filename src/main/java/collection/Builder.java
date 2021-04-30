package collection;

import java.time.LocalDate;

interface Builder {
    void reset();

    void setId(int id);

    void setGroupName(String name);

    void setCoordinates(String x, String y);

    void setCoordinates(String x);

    void setCreationDate(LocalDate date);

    void setStudentsCount(String count);

    void setFormOfEducation(String formOfEducation);

    void setSemester(String semester);

    void setAdmin(String name, String birthday, String height, String weight, String passportID);
}
