package command;

public class CountByStudentsCount implements Command{
    private final Receiver receiver;

    public CountByStudentsCount(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        Long studentsCount = Long.parseLong(args[1]);
        this.receiver.countByStudentsCount(studentsCount);
        return 0;
    }

    public String toString(){
        return "help";
    }
}
