package command;


public class AddCommand implements Command {
    private final Receiver receiver;

    public AddCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.add(parameters.getStudyGroup());
        return 0;
    }

    public String toString() {
        return "add";
    }
}
