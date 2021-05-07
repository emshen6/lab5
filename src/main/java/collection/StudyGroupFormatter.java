package collection;

public class StudyGroupFormatter {
    public String format(StudyGroup group) {
        return String.join(
                ";",
                group.getName(),
                group.getCoordinates().toString(),
                Long.toString(group.getStudentsCount()),
                group.getFormOfEducation().getText(),
                group.getSemesterEnum().getText(),
                PersonFormatter.format(group.getGroupAdmin())
        );
    }
}
