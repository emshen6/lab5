package command;

public class RemoveByIdCommand implements CommandWithArg {
    private final Receiver receiver;

    public RemoveByIdCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String args) {
        int id = Integer.parseInt(args);
        receiver.removeById(id);
        return 0;
    }

    public String toString() {
        return "removeById";
    }
}
