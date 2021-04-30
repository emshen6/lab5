package command;

import util.ClientOutput;

import java.util.LinkedHashMap;

//команда для вывода справки по доступным командам
public class HelpCommand implements CommandWithoutArg {
    private final Receiver receiver;
    private final LinkedHashMap<String, String> commandsList = new LinkedHashMap<>();

    public HelpCommand(Receiver receiver) {
        this.receiver = receiver;
        commandsList.put("help", "shows help for available commands");
        commandsList.put("info", "shows information about the collection (type, initialization date, number of elements, etc.) to the standard output stream.)");
        commandsList.put("show", "prints to standard output all elements of the collection in string representation");
        commandsList.put("add {element}", "adds a new element to collection");
        commandsList.put("update id {element}", "updates the value of the collection element whose id is equal to the given");
        commandsList.put("remove_by_id {id}", "removes an item from the collection by its id");
        commandsList.put("clear", "clears the collection");
        commandsList.put("save", "saves the collection into file");
        commandsList.put("execute_script {file_name}", "reads and executes the script from the specified file. The script contains commands in the same form in which the user enters them interactively");
        commandsList.put("exit", "ends the program (without saving to file)");
        commandsList.put("remove_first", "removes the first item from the collection");
        commandsList.put("remove_head", "dumps the first element of the collection and removes it");
        commandsList.put("history", "prints the last 12 commands (without their arguments)");
        commandsList.put("remove_all_by_students_count {studentsCount}", "removes from the collection all elements whose studentsCount field value is equivalent to the given one");
        commandsList.put("print_ascending", "shows the elements of the collection in ascending order");
    }

    public int execute() {
        ClientOutput.print("Available commands list:");
        String description;
        for (String command : commandsList.keySet()) {
            description = commandsList.get(command);
            ClientOutput.print("\t-" + command + ": " + description);
        }
        receiver.help();
        return 0;
    }

    public String toString() {
        return "help";
    }
}
