package command;

import util.ClientOutput;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//the Invoker class
public class ConsoleInvoker {

    private final HashMap<Pattern, Command> commands = new HashMap<>();


    public void addCommandToParser(String pattern, Command command) {
        commands.put(Pattern.compile(pattern), command);
    }

    public int execute(String command) {
        try {
            Matcher matcher;
            String[] line = command.split(" ");
            for (Pattern pattern : commands.keySet()) {
                matcher = pattern.matcher(command);
                if (matcher.matches()) {
                    return commands.get(pattern).execute(line[1]);
                }
            }
            ClientOutput.print("Given command is wrong or doesn't exist. Use 'help' to see available commands.");
            return 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
