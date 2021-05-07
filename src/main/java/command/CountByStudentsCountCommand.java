package command;

public class CountByStudentsCountCommand implements Command {
    private final Receiver receiver;

    public CountByStudentsCountCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String args) {
        Long studentsCount = Long.parseLong(args);
        this.receiver.countByStudentsCount(studentsCount);
        return 0;
    }

    public String toString() {
        return "count by students count";
    }
}
