package command;

public class RemoveAllByStudentsCountCommand implements Command {
    private final Receiver receiver;

    public RemoveAllByStudentsCountCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String arg) {
        Long count = Long.parseLong(arg);
        receiver.removeAllByStudentsCount(count);
        return 0;
    }

    public String toString() {
        return "remove all by students count";
    }
}
