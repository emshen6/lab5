package command;

public class SaveCommand implements Command {
    private final Receiver receiver;

    public SaveCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.save();
        return 0;
    }

    public String toString() {
        return "save";
    }
}
