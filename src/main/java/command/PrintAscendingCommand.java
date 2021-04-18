package command;

public class PrintAscendingCommand implements CommandWithArgs {
    private final Receiver receiver;

    public PrintAscendingCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        receiver.printAscending();
        return 0;
    }

    public String toString(){
        return "info";
    }
}
