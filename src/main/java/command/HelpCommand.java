package command;

//команда для вывода справки по доступным командам
public class HelpCommand implements CommandWithoutArgs {
    private final Receiver receiver;

    public HelpCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public int execute() {
        this.receiver.help();
        return 0;
    }

    public String toString(){
        return "help";
    }
}
