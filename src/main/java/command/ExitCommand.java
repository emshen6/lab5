package command;

public class ExitCommand implements CommandWithoutArg {
    private final Receiver receiver;

    public ExitCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        receiver.exit();
        return 1;
    }

    public String toString() {
        return "exit";
    }
}
