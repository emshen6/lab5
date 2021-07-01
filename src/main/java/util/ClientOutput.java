package util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientOutput {
    public void print(String message) {
        System.out.println(message);
    }

    public void print() {
        System.out.println();
    }
}
