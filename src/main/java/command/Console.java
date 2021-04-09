package command;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//the Invoker class
public class Console {
    private final Command helpCommand;
    private final Command infoCommand;
    private final Command showCommand;
    private final Command exitCommand;
    private final Command addCommand;
    private final Command updateIdCommand;
    private final Command saveCommand;
    private final Command clearCommand;
    private final Command removeByIdCommand;
    private final Command removeFirstCommand;
    private final Command removeHeadCommand;
    private final Command removeAllByStudentsCountCommand;
    private final Command historyCommand;
    private final Command executeScriptCommand;
    private final Command printAscendingCommand;
    private final Command countByStudentsCountCommand;

    /*

    private final Command executeScriptCommand;


    private final Command historyCommand;
    private final Command removeAllByStudentsCountCommand;
    private final Command countByStudentsCountCommand;
    private final Command printAscendingCommand;
     */
    private HashMap<Pattern, Command> patterns = new HashMap<>();


    public Console(Command helpCommand, Command infoCommand, Command showCommand, Command exitCommand, Command addCommand, Command updateIdCommand, Command saveCommand, Command clearCommand, Command removeByIdCommand, Command removeFirstCommand, Command removeHeadCommand, Command removeAllByStudentsCountCommand, Command historyCommand, Command executeScriptCommand, Command printAscendingCommand, Command countByStudentsCountCommand){ //Command removeByIdCommand, Command clearCommand, Command saveCommand, Command executeScriptCommand, Command removeFirstCommand, Command removeHeadCommand, Command historyCommand, Command removeAllByStudentsCountCommand, Command countByStudentsCountCommand, Command printAscendingCommand) {
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.exitCommand = exitCommand;
        this.addCommand = addCommand;
        this.updateIdCommand = updateIdCommand;
        this.saveCommand = saveCommand;
        this.clearCommand = clearCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.removeFirstCommand = removeFirstCommand;
        this.removeHeadCommand = removeHeadCommand;
        this.removeAllByStudentsCountCommand = removeAllByStudentsCountCommand;
        this.historyCommand = historyCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.printAscendingCommand = printAscendingCommand;
        this.countByStudentsCountCommand = countByStudentsCountCommand;
        /*
        this.executeScriptCommand = executeScriptCommand;
        this.removeFirstCommand = removeFirstCommand;
        this.removeHeadCommand = removeHeadCommand;
        this.historyCommand = historyCommand;
        this.removeAllByStudentsCountCommand = removeAllByStudentsCountCommand;
        this.countByStudentsCountCommand = countByStudentsCountCommand;
        this.printAscendingCommand = printAscendingCommand;
        */
        this.patterns.put(Pattern.compile("(?i)help"), this.helpCommand);
        this.patterns.put(Pattern.compile("(?i)info"), this.infoCommand);
        this.patterns.put(Pattern.compile("(?i)show"), this.showCommand);
        this.patterns.put(Pattern.compile("(?i)exit"), this.exitCommand);
        this.patterns.put(Pattern.compile("(?i)add"), this.addCommand); //[a-zA-Z0-9]+;[0-9]+;(DISTANCE_EDUCATION|FULL_TIME_EDUCATION|EVENING_CLASSES);(FIRST|SECOND|THIRD|FIFTH|SEVENTH);[A-Za-z]+;[.0-9]+;[0-9.,]+;[0-9.,]+;[a-zA-Z0-9]+"), this.addCommand);
        this.patterns.put(Pattern.compile("(?i)update [0-9]+"), this.updateIdCommand);//[a-zA-Z0-9]+;[0-9]+;(DISTANCE_EDUCATION|FULL_TIME_EDUCATION|EVENING_CLASSES);(FIRST|SECOND|THIRD|FIFTH|SEVENTH);[A-Za-z]+;[.0-9]+;[0-9.,]+;[0-9.,]+;[a-zA-Z0-9]+"), this.updateIdCommand);
        this.patterns.put(Pattern.compile("(?i)save"), this.saveCommand);
        this.patterns.put(Pattern.compile("(?i)clear"), this.clearCommand);
        this.patterns.put(Pattern.compile("(?i)remove_by_id [0-9]+"), this.removeByIdCommand);
        this.patterns.put(Pattern.compile("(?i)remove_first"), this.removeFirstCommand);
        this.patterns.put(Pattern.compile("(?i)remove_head"), this.removeHeadCommand);
        this.patterns.put(Pattern.compile("(?i)remove_all_by_students_count [0-9]+"), this.removeAllByStudentsCountCommand);
        this.patterns.put(Pattern.compile("(?i)history"), this.historyCommand);
        this.patterns.put(Pattern.compile("(?i)execute_script [a-zA-Z0-9/]"), this.executeScriptCommand);
        this.patterns.put(Pattern.compile("(?i)print_ascending"), this.printAscendingCommand);
        this.patterns.put(Pattern.compile("(?i)count_by_students_count [0-9]+"), this.countByStudentsCountCommand);
    }

    public int execute(String command){
        Matcher matcher;
        for (Pattern pattern: patterns.keySet()){
            matcher = pattern.matcher(command);
            if (matcher.matches()){
                return patterns.get(pattern).execute(command.split(" "));
            }
        }
        System.out.println("Given command is wrong or doesn't exist. Use 'help' to see available commands.");
        return 0;
    }
}
