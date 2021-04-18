import collection.CollectionWrapper;
import command.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String envVar = "DATA";
        Scanner sc = new Scanner(System.in);
        CollectionWrapper collection = new CollectionWrapper(envVar);
        collection.printCollection();
        CommandsConfig commandsconfig = new CommandsConfig(collection);
        ConsoleBuilder builder = new ConsoleBuilder(commandsconfig);
        Director director = new Director();
        director.constructConsole(builder);
        Console console = builder.getResult();
        System.out.println(console.getHelpCommand());
        console.getHelpCommand().execute();
        //Console console = new Console(new HelpCommand(commandsconfig), new InfoCommand(commandsconfig), new ShowCommand(commandsconfig), new ExitCommand(commandsconfig), new AddCommand(commandsconfig), new UpdateIdCommand(commandsconfig), new SaveCommand(commandsconfig), new ClearCommand(commandsconfig), new RemoveByIdCommand(commandsconfig), new RemoveFirstCommand(commandsconfig), new RemoveHeadCommand(commandsconfig), new RemoveAllByStudentsCountCommand(commandsconfig), new HistoryCommand(commandsconfig), new ExecuteScriptCommand(commandsconfig), new PrintAscendingCommand(commandsconfig), new CountByStudentsCount(commandsconfig));
        /*
        int flag=0;
        while (flag == 0) {
            System.out.println(1);
            String line = sc.nextLine();
            System.out.println(2);
            flag = console.execute(line);
        }
         */
    }
}
