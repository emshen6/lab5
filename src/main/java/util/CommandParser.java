package util;

import command.*;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
    private HashMap <Pattern, Command> commands = new HashMap<>();
    private Receiver receiver;

    public CommandParser(Receiver receiver){
        this.receiver = receiver;
        commands.put(Pattern.compile("(?i)help"), new HelpCommand(receiver));
        commands.put(Pattern.compile("(?i)info"), new InfoCommand(receiver));
        commands.put(Pattern.compile("(?i)show"), new ShowCommand(receiver));
        commands.put(Pattern.compile("(?i)add"), new AddCommand(receiver));
        commands.put(Pattern.compile("(?i)update [0-9]+"), new UpdateIdCommand(receiver));
        commands.put(Pattern.compile("(?i)remove_by_id [0-9]+"), new RemoveByIdCommand(receiver));
        commands.put(Pattern.compile("(?i)clear"), new ClearCommand(receiver));
        commands.put(Pattern.compile("(?i)save"), new SaveCommand(receiver));
        commands.put(Pattern.compile("(?i)execute_script [A-Za-z.:/_0-9]+"), new ExecuteScriptCommand(receiver));
        commands.put(Pattern.compile("(?i)remove_first"), new RemoveFirstCommand(receiver));
        commands.put(Pattern.compile("(?i)remove_head"), new RemoveHeadCommand(receiver));
        commands.put(Pattern.compile("(?i)history"), new HistoryCommand(receiver));
        commands.put(Pattern.compile("(?i)remove_all_by_students_count [0-9]+"), new RemoveAllByStudentsCountCommand(receiver));
        commands.put(Pattern.compile("(?i)count_by_students_count [0-9]+"), new CountByStudentsCountCommand(receiver));
        commands.put(Pattern.compile("(?i)print_ascending"), new PrintAscendingCommand(receiver));
    }

    public Command get(String line){
        Matcher matcher;
        for (Pattern pattern : commands.keySet()) {
            matcher = pattern.matcher(line);
            if (matcher.matches()) {
                return commands.get(pattern);
            }
        }
        return null;
    }
}
