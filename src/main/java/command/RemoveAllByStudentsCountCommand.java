package command;

public class RemoveAllByStudentsCountCommand implements Command {
    private final Receiver receiver;

    public RemoveAllByStudentsCountCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.removeAllByStudentsCount(parameters.getCount());
        return 0;
    }

    public String toString() {
        return "remove all by students count";
    }
}
