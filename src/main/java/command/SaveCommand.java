package command;

public class SaveCommand implements CommandWithoutArg {
    private final Receiver receiver;

    public SaveCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        receiver.save();
        return 0;
    }

    public String toString() {
        return "save";
    }
}
