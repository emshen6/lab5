package command;

public class CountByStudentsCountCommand implements Command {
    private final Receiver receiver;

    public CountByStudentsCountCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(Parameters parameters) {
        receiver.countByStudentsCount(parameters.getCount());
        return 0;
    }

    public String toString() {
        return "count by students count";
    }
}
