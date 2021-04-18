package command;

public class HistoryCommand implements CommandWithArgs {
    private final Receiver receiver;

    public HistoryCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        receiver.history();
        return 0;
    }

    public String toString(){
        return "history";
    }
}
