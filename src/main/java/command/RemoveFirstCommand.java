package command;

public class RemoveFirstCommand implements Command{
    private final Receiver receiver;

    public RemoveFirstCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        receiver.removeFirst();
        return 0;
    }

    public String toString(){
        return "remove first";
    }
}
