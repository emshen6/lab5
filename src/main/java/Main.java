import collection.CollectionWrapper;
import command.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String envVar = "DATA";
        Scanner sc = new Scanner(System.in);
        CollectionWrapper collection = new CollectionWrapper(envVar);
        CommandsConfig commandsconfig = new CommandsConfig(collection);
        Console console = new Console(new HelpCommand(commandsconfig), new InfoCommand(commandsconfig), new ShowCommand(commandsconfig), new ExitCommand(commandsconfig), new AddCommand(commandsconfig), new UpdateIdCommand(commandsconfig), new SaveCommand(commandsconfig), new ClearCommand(commandsconfig), new RemoveByIdCommand(commandsconfig), new RemoveFirstCommand(commandsconfig), new RemoveHeadCommand(commandsconfig), new RemoveAllByStudentsCountCommand(commandsconfig), new HistoryCommand(commandsconfig), new ExecuteScriptCommand(commandsconfig), new PrintAscendingCommand(commandsconfig), new CountByStudentsCount(commandsconfig));
        int flag=0;
        while (flag == 0) {
            String line = sc.nextLine();
            flag = console.execute(line);
        }
    }
}
