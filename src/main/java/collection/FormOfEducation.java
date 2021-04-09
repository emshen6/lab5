package collection;

public enum FormOfEducation {
    DISTANCE_EDUCATION("DISTANCE_EDUCATION"),
    FULL_TIME_EDUCATION("FULL_TIME_EDUCATION"),
    EVENING_CLASSES("EVENING_CLASSES");

    private final String text;

    FormOfEducation(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
