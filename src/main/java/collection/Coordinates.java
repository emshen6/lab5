package collection;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
public class Coordinates {
    @NotNull
    @Max(value = 429)
    private Float x; //Максимальное значение поля: 429, Поле не может быть null
    @Max(value = 398)
    private float y; //Максимальное значение поля: 398

    public Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
