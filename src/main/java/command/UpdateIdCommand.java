package command;


import collection.StudyGroupBuilder;

public class UpdateIdCommand implements CommandWithArg {
    private final Receiver receiver;

    public UpdateIdCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String arg) {
        int id = Integer.parseInt(arg);
        StudyGroupBuilder builder = new StudyGroupBuilder();
        builder.userInput();
        builder.setId(id);
        receiver.updateId(builder, id);
        return 0;
    }

    public String toString() {
        return "updateId";
    }
}
