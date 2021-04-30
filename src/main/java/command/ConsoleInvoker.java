package command;

import util.ClientOutput;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//the Invoker class
public class ConsoleInvoker {

    private final HashMap<Pattern, CommandWithArg> commandsWithArg = new HashMap<>();
    private final HashMap<Pattern, CommandWithoutArg> commandsWithoutArg = new HashMap<>();


    public void addCommandToParser(String pattern, CommandWithoutArg command) {
        commandsWithoutArg.put(Pattern.compile(pattern), command);
    }

    public void addCommandToParser(String pattern, CommandWithArg command) {
        commandsWithArg.put(Pattern.compile(pattern), command);
    }

    public int execute(String command) {
        try {
            Matcher matcher;
            String[] line = command.split(" ");
            if (line.length == 1) {
                for (Pattern pattern : commandsWithoutArg.keySet()) {
                    matcher = pattern.matcher(command);
                    if (matcher.matches()) {
                        return commandsWithoutArg.get(pattern).execute();
                    }
                }
                ClientOutput.print("Given command is wrong or doesn't exist. Use 'help' to see available commands.");
                return 0;
            } else if (line.length == 2) {
                for (Pattern pattern : commandsWithArg.keySet()) {
                    matcher = pattern.matcher(command);
                    if (matcher.matches()) {
                        return commandsWithArg.get(pattern).execute(line[1]);
                    }
                }
                ClientOutput.print("Given command is wrong or doesn't exist. Use 'help' to see available commands.");
                return 0;
            } else {
                ClientOutput.print("Given command is wrong or doesn't exist. Use 'help' to see available commands.");
                return 0;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
