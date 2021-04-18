package command;

//команда для вывода информации о коллекции
public class InfoCommand implements CommandWithArgs {
    private final Receiver receiver;

    public InfoCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute(String[] args) {
        receiver.info();
        return 0;
    }

    public String toString(){
        return "info";
    }
}
