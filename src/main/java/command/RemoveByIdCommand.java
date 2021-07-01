package command;

public class RemoveByIdCommand implements Command {
    private final Receiver receiver;

    public RemoveByIdCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.removeById(parameters.getNum());
        return 0;
    }

    public String toString() {
        return "removeById";
    }
}
