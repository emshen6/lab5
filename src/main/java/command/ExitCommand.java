package command;

public class ExitCommand implements CommandWithArgs {
    private final Receiver receiver;

    public ExitCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        receiver.exit();
        return 1;
    }

    public String toString(){
        return "exit";
    }
}
