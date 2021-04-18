package command;

public class Director {
    public void constructConsole(Builder builder){
        builder.reset();
        builder.setHelpCommand();
        builder.setInfoCommand();
        builder.setShowCommand();
        builder.setAddCommand();
        builder.setUpdateIdCommand();
        builder.setRemoveByIdCommand();
        builder.setClearCommand();
        builder.setSaveCommand();
        builder.setExecuteScriptCommand();
        builder.setExitCommand();
        builder.setRemoveFirstCommand();
        builder.setRemoveHeadCommand();
        builder.setHistoryCommand();
        builder.setRemoveAllByStudentsCountCommand();
        builder.setCountByStudentsCountCommand();
        builder.setPrintAscendingCommand();
    }
}
