package execeptions;

public class ExistingIDException extends Exception{
    public ExistingIDException() {
        super("Element with that id already exists!");
    }
}
