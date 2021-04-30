package command;

public class ClearCommand implements CommandWithoutArg {

    private final Receiver receiver;

    public ClearCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        receiver.clear();
        return 0;
    }

    public String toString() {
        return "clear";
    }
}
