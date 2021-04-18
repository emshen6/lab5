package command;

public class AddCommand implements CommandWithArgs {
    private final Receiver receiver;

    public AddCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        receiver.add();
        return 0;
    }

    public String toString(){
        return "exit";
    }
}
