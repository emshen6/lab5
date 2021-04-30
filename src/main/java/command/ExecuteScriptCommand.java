package command;

public class ExecuteScriptCommand implements CommandWithArg {
    private final Receiver receiver;

    public ExecuteScriptCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String arg) {

        this.receiver.executeScript(arg);
        return 0;
    }

    public String toString() {
        return "execute_script";
    }
}
