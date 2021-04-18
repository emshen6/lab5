package command;

public class ExecuteScriptCommand implements CommandWithArgs {
    private final Receiver receiver;

    public ExecuteScriptCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        String filename = args[1];
        this.receiver.executeScript(filename);
        return 0;
    }

    public String toString(){
        return "execute_script";
    }
}
