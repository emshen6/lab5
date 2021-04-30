package util;

public interface ClientOutput {
    static void print(String message) {
        System.out.println(message);
    }

    static void print() {
        System.out.println();
    }
}
