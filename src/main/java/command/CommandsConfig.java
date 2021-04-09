package command;

import collection.CollectionWrapper;
import execeptions.IncorrectInputException;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Receiver class
public class CommandsConfig implements Receiver {

    private final Pattern groupNamePattern = Pattern.compile("[a-zA-Z0-9]+");
    private final Pattern namePattern = Pattern.compile("[a-zA-Z]+");
    private final Pattern semesterPattern = Pattern.compile("(FIRST|SECOND|THIRD|FIFTH|SEVENTH)");
    private final Pattern formOfEducationPattern = Pattern.compile("(DISTANCE_EDUCATION|FULL_TIME_EDUCATION|EVENING_CLASSES)");
    private final Stack<String> history = new Stack<>();
    private LinkedHashMap<String, String> commandsList = new LinkedHashMap<>();
    private CollectionWrapper collection;

    public CommandsConfig(CollectionWrapper collection) {
        this.collection = collection;
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

    public void help() {
        System.out.println("Available commands list:");
        String description;
        for (String command : commandsList.keySet()) {
            description = commandsList.get(command);
            System.out.println("\t-" + command + ": " + description);
        }
        history.push("help");
    }

    public void info() {
        System.out.println("Collection type:");
        System.out.println(collection.getType());
        System.out.println("Init time:");
        System.out.println(collection.getInitTime());
        System.out.println("Collection size:");
        System.out.println(collection.getSize());
        history.push("info");
    }

    public void show() {
        System.out.println(collection.toString());
        history.push("show");
    }

    public void exit() {
        history.push("exit");
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        try {
            Matcher matcher;
            System.out.println("Enter group name:");
            String groupName = sc.nextLine();
            matcher = groupNamePattern.matcher(groupName);
            if (!matcher.matches()) throw new IncorrectInputException();
            System.out.println("Enter x:");
            float x = Float.parseFloat(sc.nextLine());
            System.out.println("Enter y:");
            Float y = Float.parseFloat(sc.nextLine());
            System.out.println("Enter students count:");
            Long studentsCount = Long.parseLong(sc.nextLine());
            System.out.println("Choose form of education (DISTANCE_EDUCATION/FULL_TIME_EDUCATION/EVENING_CLASSES):");
            String formOfEducation = sc.nextLine();
            matcher = formOfEducationPattern.matcher(formOfEducation);
            if (!matcher.matches()) throw new IncorrectInputException();
            System.out.println("Choose semester (FIRST/SECOND/THIRD/FIFTH/SEVENTH):");
            String semester = sc.nextLine();
            matcher = semesterPattern.matcher(semester);
            if (!matcher.matches()) throw new IncorrectInputException();
            System.out.println("Enter admin's name:");
            String adminName = sc.nextLine();
            matcher = namePattern.matcher(adminName);
            if (!matcher.matches()) throw new IncorrectInputException();
            System.out.println("Enter admin's birthday:");
            String adminBirthday = sc.nextLine();
            System.out.println("Enter admin's height:");
            String height = sc.nextLine();
            System.out.println("Enter admin's weight:");
            String weight = sc.nextLine();
            System.out.println("Enter admin's passport ID:");
            String adminPassportID = sc.nextLine();
            collection.addElement(groupName, x, y, studentsCount, formOfEducation, semester, adminName, adminBirthday, height, weight, adminPassportID);
            System.out.println("Element added.");
            history.push("add {" + String.join(";", groupName, Float.toString(x), Float.toString(y), Long.toString(studentsCount), formOfEducation, semester, adminName, adminBirthday, height, weight, adminPassportID) + "}");
        } catch (NumberFormatException | IncorrectInputException e) {
            System.out.println("Enter correct data!");
        }

    }

    public void updateId(int id) {
        collection.removeById(id);
        Scanner sc = new Scanner(System.in);
        try {
            Matcher matcher;
            System.out.println("Enter group name:");
            String groupName = sc.nextLine();
            matcher = groupNamePattern.matcher(groupName);
            if (!matcher.matches()) throw new IncorrectInputException();
            System.out.println("Enter x:");
            float x = Float.parseFloat(sc.nextLine());
            System.out.println("Enter y:");
            Float y = Float.parseFloat(sc.nextLine());
            System.out.println("Enter students count:");
            Long studentsCount = Long.parseLong(sc.nextLine());
            System.out.println("Choose form of education (DISTANCE_EDUCATION/FULL_TIME_EDUCATION/EVENING_CLASSES):");
            String formOfEducation = sc.nextLine();
            matcher = formOfEducationPattern.matcher(formOfEducation);
            if (!matcher.matches()) throw new IncorrectInputException();
            System.out.println("Choose semester (FIRST/SECOND/THIRD/FIFTH/SEVENTH):");
            String semester = sc.nextLine();
            matcher = semesterPattern.matcher(semester);
            if (!matcher.matches()) throw new IncorrectInputException();
            System.out.println("Enter admin's name:");
            String adminName = sc.nextLine();
            matcher = namePattern.matcher(adminName);
            if (!matcher.matches()) throw new IncorrectInputException();
            System.out.println("Enter admin's birthday:");
            String adminBirthday = sc.nextLine();
            System.out.println("Enter admin's height:");
            String height = sc.nextLine();
            System.out.println("Enter admin's weight:");
            String weight = sc.nextLine();
            System.out.println("Enter admin's passport ID:");
            String adminPassportID = sc.nextLine();
            collection.addElementWithId(id, groupName, x, y, studentsCount, formOfEducation, semester, adminName, adminBirthday, height, weight, adminPassportID);
            System.out.println("Element " + Integer.toString(id) + " updated.");
            history.push("update " + Integer.toString(id));
        } catch (NumberFormatException | IncorrectInputException e) {
            System.out.println("Enter correct data!");
        }

    }

    public void removeById(int id) {
        collection.removeById(id);
        System.out.println("Element " + Integer.toString(id) + " deleted.");
        history.push("remove_by_id " + Integer.toString(id));
    }

    public void clear() {
        collection.clear();
        System.out.println("Collection cleared.");
        history.push("clear");
    }

    public void save() {
        String file = System.getenv().get(collection.getEnvVariable());
        String outputFile = file.substring(0, file.length() - 4) + "_out.txt";
        //String file = System.getenv().get(collection.getEnvVariable());
        try {
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(outputFile));
            System.out.println("Buffered output stream created.");
            String text = collection.toString();
            System.out.println(text);
            byte[] buffer = text.getBytes();
            System.out.println();
            System.out.println("Byte array created.");
            stream.write(buffer, 0, buffer.length);
            System.out.println("Collection saved!");
            history.push("save");
        } catch (IOException e) {
            System.out.println("Err while saving!");
        }
    }

    public void removeFirst() {
        collection.removeFirst();
        System.out.println("First element deleted.");
        history.push("remove_first");
    }

    public void removeHead() {
        collection.showAndRemoveFirst();
        history.push("remove_head");
    }

    public void removeAllByStudentsCount(Long count) {
        collection.removeByCount(count);
        System.out.println("Groups with " + Long.toString(count) + " students removed.");
        history.push("remove_all_by_students_count " + Long.toString(count));
    }

    public void history() {
        Stack<String> lastCommands = history;
        for (int i = 0; i < 12; i++) {
            System.out.println(lastCommands.pop());
        }
        history.push("history");
    }

    public void executeScript(String filename) {
        try {
            Scanner sc = new Scanner(filename);
            CommandsConfig commandsconfig = new CommandsConfig(collection);
            Console console = new Console(
                    new HelpCommand(commandsconfig), new InfoCommand(commandsconfig), new ShowCommand(commandsconfig), new ExitCommand(commandsconfig), new AddCommand(commandsconfig), new UpdateIdCommand(commandsconfig), new SaveCommand(commandsconfig), new ClearCommand(commandsconfig), new RemoveByIdCommand(commandsconfig), new RemoveFirstCommand(commandsconfig), new RemoveHeadCommand(commandsconfig), new RemoveAllByStudentsCountCommand(commandsconfig), new HistoryCommand(commandsconfig), new ExecuteScriptCommand(commandsconfig), new PrintAscendingCommand(commandsconfig), new CountByStudentsCount(commandsconfig));
            int flag = 0;
            while (flag == 0) {
                String line = sc.nextLine();
                flag = console.execute(line);
            }
            history.push("execute_script " + filename);
        } catch (Exception e) {
            System.out.println("Failed to execute script.");
        }
    }

    public void printAscending() {
        collection.printAscending();
        history.push("print_ascending");
    }

    public void countByStudentsCount(Long studentsCount) {
        Long k = collection.countGroupsByStudentsCount(studentsCount);
        System.out.println(k);
        history.push("count_by_students_count " + Long.toString(studentsCount));
    }
}
