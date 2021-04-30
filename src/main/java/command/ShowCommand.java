package command;

public class ShowCommand implements CommandWithoutArg {
    private final Receiver receiver;

    public ShowCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        receiver.show();
        return 0;
    }

    public String toString() {
        return "show";
    }
}
