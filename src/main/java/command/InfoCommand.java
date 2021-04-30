package command;

//команда для вывода информации о коллекции
public class InfoCommand implements CommandWithoutArg {
    private final Receiver receiver;

    public InfoCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        receiver.info();
        return 0;
    }

    public String toString() {
        return "info";
    }
}
