package command;

public class ClearCommand implements Command{

    private final Receiver receiver;

    public ClearCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        receiver.clear();
        return 0;
    }

    public String toString(){
        return "clear";
    }
}
