package command;

public class HistoryCommand implements CommandWithoutArg {
    private final Receiver receiver;

    public HistoryCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        receiver.history();
        return 0;
    }

    public String toString() {
        return "history";
    }
}
