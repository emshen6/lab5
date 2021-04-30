package command;


import collection.StudyGroupBuilder;

public class AddCommand implements CommandWithoutArg {
    private final Receiver receiver;

    public AddCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        StudyGroupBuilder builder = new StudyGroupBuilder();
        builder.userInput();
        receiver.add(builder);
        return 0;
    }

    public String toString() {
        return "add";
    }
}
