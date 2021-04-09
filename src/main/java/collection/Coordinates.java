package collection;

public class Coordinates {
    private final Float x; //Максимальное значение поля: 429, Поле не может быть null
    private final float y; //Максимальное значение поля: 398

    Coordinates(Float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        String s = "";
        s+= Float.toString(x);
        s+=";";
        s+= Float.toString(y);
        return s;
    }
}
