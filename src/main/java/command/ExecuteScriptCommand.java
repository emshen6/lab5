package command;

public class ExecuteScriptCommand implements Command {
    private final Receiver receiver;

    public ExecuteScriptCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.executeScript(parameters.getFilename());
        return 0;
    }

    public String toString() {
        return "execute_script";
    }
}
