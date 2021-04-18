package command;

//The Command Interface
public interface CommandWithArgs extends Command{
    int execute(String[] args);
}
