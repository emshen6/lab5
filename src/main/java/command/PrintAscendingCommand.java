package command;

public class PrintAscendingCommand implements Command {
    private final Receiver receiver;

    public PrintAscendingCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.printAscending();
        return 0;
    }

    public String toString() {
        return "info";
    }
}
