package command;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//the Invoker class
public class Console {
    private CommandWithoutArgs helpCommand = null;
    private CommandWithArgs infoCommand = null;
    private CommandWithArgs showCommand = null;
    private CommandWithArgs exitCommand = null;
    private CommandWithArgs addCommand = null;
    private CommandWithArgs updateIdCommand = null;
    private CommandWithArgs saveCommand = null;
    private CommandWithArgs clearCommand = null;
    private CommandWithArgs removeByIdCommand = null;
    private CommandWithArgs removeFirstCommand = null;
    private CommandWithArgs removeHeadCommand = null;
    private CommandWithArgs removeAllByStudentsCountCommand = null;
    private CommandWithArgs historyCommand = null;
    private CommandWithArgs executeScriptCommand = null;
    private CommandWithArgs printAscendingCommand = null;
    private CommandWithArgs countByStudentsCountCommand = null;
    private HashMap<Pattern, CommandWithArgs> commandsWithArgs = new HashMap<>();
    private HashMap<Pattern, CommandWithoutArgs> commandsWithoutArgs = new HashMap<>();

    public Console(){
        this.commandsWithoutArgs.put(Pattern.compile("(?i)help"), this.helpCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)info"), this.infoCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)show"), this.showCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)exit"), this.exitCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)add"), this.addCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)update [0-9]+"), this.updateIdCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)save"), this.saveCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)clear"), this.clearCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)remove_by_id [0-9]+"), this.removeByIdCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)remove_first"), this.removeFirstCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)remove_head"), this.removeHeadCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)remove_all_by_students_count [0-9]+"), this.removeAllByStudentsCountCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)history"), this.historyCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)execute_script [a-zA-Z0-9/]"), this.executeScriptCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)print_ascending"), this.printAscendingCommand);
        this.commandsWithArgs.put(Pattern.compile("(?i)count_by_students_count [0-9]+"), this.countByStudentsCountCommand);
    }
    /*

    private final Command executeScriptCommand;


    private final Command historyCommand;
    private final Command removeAllByStudentsCountCommand;
    private final Command countByStudentsCountCommand;
    private final Command printAscendingCommand;
     */

    public void setHelpCommand(Receiver receiver){
        helpCommand = new HelpCommand(receiver);
    }

    public void setInfoCommand(Receiver receiver){
        infoCommand = new InfoCommand(receiver);
    }

    public void setShowCommand(Receiver receiver){
        showCommand = new ShowCommand(receiver);
    }

    public void setExitCommand(Receiver receiver){
        exitCommand = new ExitCommand(receiver);
    }

    public void setAddCommand(Receiver receiver){
        addCommand = new AddCommand(receiver);
    }

    public void setUpdateIdCommand(Receiver receiver){
        updateIdCommand = new UpdateIdCommand(receiver);
    }

    public void setSaveCommand(Receiver receiver){
        saveCommand = new SaveCommand(receiver);
    }

    public void setClearCommand(Receiver receiver){
        clearCommand = new ClearCommand(receiver);
    }

    public void setRemoveByIdCommand(Receiver receiver){
        removeByIdCommand = new RemoveByIdCommand(receiver);
    }

    public void setRemoveFirstCommand(Receiver receiver){
        removeFirstCommand = new RemoveFirstCommand(receiver);
    }

    public void setRemoveHeadCommand(Receiver receiver){
        removeHeadCommand = new RemoveHeadCommand(receiver);
    }

    public void setRemoveAllByStudentsCountCommand(Receiver receiver){
        removeAllByStudentsCountCommand = new RemoveAllByStudentsCountCommand(receiver);
    }

    public void setHistoryCommand(Receiver receiver){
        historyCommand = new HistoryCommand(receiver);
    }

    public void setExecuteScriptCommand(Receiver receiver){
        executeScriptCommand = new ExecuteScriptCommand(receiver);
    }

    public void setPrintAscendingCommand(Receiver receiver){
        printAscendingCommand = new PrintAscendingCommand(receiver);
    }

    public void setCountByStudentsCountCommand(Receiver receiver){
        countByStudentsCountCommand = new CountByStudentsCount(receiver);
    }

    public int execute(String command){
        try {
            System.out.println("point 1");
            Matcher matcher;
            String[] args = command.split(" ");
            if (args.length == 1) {
                for (Pattern pattern : commandsWithoutArgs.keySet()) {
                    matcher = pattern.matcher(command);
                    if (matcher.matches()) {
                        return commandsWithoutArgs.get(pattern).execute();
                    }
                }
                System.out.println("Given command is wrong or doesn't exist. Use 'help' to see available commands.");
                return 0;
            } else {
                for (Pattern pattern : commandsWithArgs.keySet()) {
                    matcher = pattern.matcher(command);
                    if (matcher.matches()) {
                        return commandsWithArgs.get(pattern).execute(args);
                    }
                }
                System.out.println("Given command is wrong or doesn't exist. Use 'help' to see available commands.");
                return 0;
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            return 0;
        }
    }

    public CommandWithoutArgs getHelpCommand(){
        return helpCommand;
    }
}
