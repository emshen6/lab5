package command;

public class ConsoleBuilder implements Builder {

    private Console console;
    private final Receiver receiver;

    public ConsoleBuilder(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void reset() {
        console = new Console();
    }

    @Override
    public void setHelpCommand() {
        console.setHelpCommand(receiver);
    }

    @Override
    public void setInfoCommand() {
        console.setInfoCommand(receiver);
    }

    @Override
    public void setShowCommand() {
        console.setShowCommand(receiver);
    }

    @Override
    public void setAddCommand() {
        console.setAddCommand(receiver);
    }

    @Override
    public void setUpdateIdCommand() {
        console.setUpdateIdCommand(receiver);
    }

    @Override
    public void setRemoveByIdCommand() {
        console.setRemoveByIdCommand(receiver);
    }

    @Override
    public void setClearCommand() {
        console.setClearCommand(receiver);
    }

    @Override
    public void setSaveCommand() {
        console.setSaveCommand(receiver);
    }

    @Override
    public void setExecuteScriptCommand() {
        console.setExecuteScriptCommand(receiver);
    }

    @Override
    public void setExitCommand() {
        console.setExitCommand(receiver);
    }

    @Override
    public void setRemoveFirstCommand() {
        console.setRemoveFirstCommand(receiver);
    }

    @Override
    public void setRemoveHeadCommand() {
        console.setRemoveHeadCommand(receiver);
    }

    @Override
    public void setHistoryCommand() {
        console.setHistoryCommand(receiver);
    }

    @Override
    public void setRemoveAllByStudentsCountCommand() {
        console.setRemoveAllByStudentsCountCommand(receiver);
    }

    @Override
    public void setCountByStudentsCountCommand() {
        console.setCountByStudentsCountCommand(receiver);
    }

    @Override
    public void setPrintAscendingCommand() {
        console.setPrintAscendingCommand(receiver);
    }

    public Console getResult(){
        return console;
    }
}
