package command;

public class UpdateIdCommand implements Command{
    private final Receiver receiver;

    public UpdateIdCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        try {
            int id = Integer.parseInt(args[1]);
            this.receiver.updateId(id);
        }catch (NumberFormatException e){
            System.out.println("Incorrect input.");
        }
        return 0;
    }

    public String toString(){
        return "updateId";
    }
}
