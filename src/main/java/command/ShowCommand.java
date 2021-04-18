package command;

//команда для вывода всех элементов коллекции
public class ShowCommand implements CommandWithArgs {
    private final Receiver receiver;

    public ShowCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        receiver.show();
        return 0;
    }

    public String toString(){
        return "show";
    }
}
