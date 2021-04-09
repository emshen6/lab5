package execeptions;

public class MaxValueReachedException extends RuntimeException{
    public MaxValueReachedException() {
        super("Max value reached!");
    }
}
