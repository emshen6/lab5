package command;

public class ExitCommand implements Command {
    private final Receiver receiver;

    public ExitCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.exit();
        return 1;
    }

    public String toString() {
        return "exit";
    }
}
