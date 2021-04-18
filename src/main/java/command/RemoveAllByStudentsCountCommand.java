package command;

public class RemoveAllByStudentsCountCommand implements CommandWithArgs {
    private final Receiver receiver;

    public RemoveAllByStudentsCountCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        Long count = Long.parseLong(args[1]);
        receiver.removeAllByStudentsCount(count);
        return 0;
    }

    public String toString(){
        return "remove all by students count";
    }
}
