package command;

//The Command Interface
public interface CommandWithArg extends Command {
    int execute(String arg);
}
