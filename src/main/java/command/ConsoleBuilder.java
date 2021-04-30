package command;

public class ConsoleBuilder implements Builder {

    private final Receiver receiver;
    private ConsoleInvoker console;

    public ConsoleBuilder(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void reset() {
        console = new ConsoleInvoker();
    }

    @Override
    public void setHelpCommand() {
        console.addCommandToParser("(?i)help", new HelpCommand(receiver));
    }

    @Override
    public void setInfoCommand() {
        console.addCommandToParser("(?i)info", new InfoCommand(receiver));
    }

    @Override
    public void setShowCommand() {
        console.addCommandToParser("(?i)show", new ShowCommand(receiver));
    }

    @Override
    public void setAddCommand() {
        console.addCommandToParser("(?i)add", new AddCommand(receiver));
    }

    @Override
    public void setUpdateIdCommand() {
        console.addCommandToParser("(?i)update [0-9]+", new UpdateIdCommand(receiver));
    }

    @Override
    public void setRemoveByIdCommand() {
        console.addCommandToParser("(?i)remove_by_id [0-9]+", new RemoveByIdCommand(receiver));
    }

    @Override
    public void setClearCommand() {
        console.addCommandToParser("(?i)clear", new ClearCommand(receiver));
    }

    @Override
    public void setSaveCommand() {
        console.addCommandToParser("(?i)save", new SaveCommand(receiver));
    }

    @Override
    public void setExecuteScriptCommand() {
        console.addCommandToParser("(?i)execute_script [A-Za-z.:/_0-9]+", new ExecuteScriptCommand(receiver));
    }

    @Override
    public void setExitCommand() {
        console.addCommandToParser("(?i)exit", new ExitCommand(receiver));
    }

    @Override
    public void setRemoveFirstCommand() {
        console.addCommandToParser("(?i)remove_first", new RemoveFirstCommand(receiver));
    }

    @Override
    public void setRemoveHeadCommand() {
        console.addCommandToParser("(?i)remove_head", new RemoveHeadCommand(receiver));
    }

    @Override
    public void setHistoryCommand() {
        console.addCommandToParser("(?i)history", new HistoryCommand(receiver));
    }

    @Override
    public void setRemoveAllByStudentsCountCommand() {
        console.addCommandToParser("(?i)remove_all_by_students_count [0-9]+", new RemoveAllByStudentsCountCommand(receiver));
    }

    @Override
    public void setCountByStudentsCountCommand() {
        console.addCommandToParser("(?i)count_by_students_count [0-9]+", new CountByStudentsCountCommand(receiver));
    }

    @Override
    public void setPrintAscendingCommand() {
        console.addCommandToParser("(?i)print_ascending", new PrintAscendingCommand(receiver));
    }

    public ConsoleInvoker getResult() {
        return console;
    }
}
