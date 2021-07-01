package command;

public class RemoveHeadCommand implements Command {
    private final Receiver receiver;

    public RemoveHeadCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.removeHead();
        return 0;
    }

    public String toString() {
        return "remove head";
    }
}
