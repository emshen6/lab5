package command;

public class RemoveByIdCommand implements Command{
    private final Receiver receiver;

    public RemoveByIdCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        int id = Integer.parseInt(args[1]);
        receiver.removeById(id);
        return 0;
    }

    public String toString(){
        return "removeById";
    }
}