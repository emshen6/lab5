package command;

public class RemoveFirstCommand implements CommandWithoutArg {
    private final Receiver receiver;

    public RemoveFirstCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        receiver.removeFirst();
        return 0;
    }

    public String toString() {
        return "remove first";
    }
}
