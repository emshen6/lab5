package command;

public class PrintAscendingCommand implements CommandWithoutArg {
    private final Receiver receiver;

    public PrintAscendingCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        receiver.printAscending();
        return 0;
    }

    public String toString() {
        return "info";
    }
}
