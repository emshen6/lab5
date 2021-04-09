package collection;

public enum Semester {
    FIRST("FIRST"),
    SECOND("SECOND"),
    THIRD("THIRD"),
    FIFTH("FIFTH"),
    SEVENTH("SEVENTH");

    private final String text;

    Semester(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
