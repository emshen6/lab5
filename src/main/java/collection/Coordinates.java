package collection;

public class Coordinates {
    private final Float x; //Максимальное значение поля: 429, Поле не может быть null
    private float y; //Максимальное значение поля: 398

    Coordinates(Float x, float y) {
        this.x = x;
        this.y = y;
    }

    Coordinates(Float x) {
        this.x = x;
    }

    public String toString() {
        String s = "";
        s += Float.toString(x);
        s += ";";
        s += Float.toString(y);
        return s;
    }

    public Float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
