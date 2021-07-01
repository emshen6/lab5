package command;


public class UpdateIdCommand implements Command {
    private final Receiver receiver;

    public UpdateIdCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.updateId(parameters.getStudyGroup(), parameters.getId());
        return 0;
    }

    public String toString() {
        return "updateId";
    }
}
