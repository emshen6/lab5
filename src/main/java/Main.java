import collection.CollectionWrapper;
import command.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String envVar = "DATA";
        Scanner sc = new Scanner(System.in);
        CollectionWrapper collection = new CollectionWrapper(envVar);
        collection.printCollection();
        CommandManager consoleReceiver = new CommandManager(collection);
        ConsoleBuilder builder = new ConsoleBuilder(consoleReceiver);
        Director director = new Director();
        director.constructConsole(builder);
        ConsoleInvoker console = builder.getResult();

        int flag=0;
        while (flag == 0) {
            String line = sc.nextLine();
            flag = console.execute(line);
        }
    }
}
