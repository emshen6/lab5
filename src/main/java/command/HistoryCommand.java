package command;

public class HistoryCommand implements Command {
    private final Receiver receiver;

    public HistoryCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.history();
        return 0;
    }

    public String toString() {
        return "history";
    }
}
