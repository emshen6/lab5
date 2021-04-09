package command;

public class RemoveHeadCommand implements Command{
    private final Receiver receiver;

    public RemoveHeadCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        receiver.removeHead();
        return 0;
    }

    public String toString(){
        return "remove head";
    }
}
