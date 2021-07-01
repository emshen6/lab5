package command;

import collection.*;
import util.ClientOutput;
import util.CommandParser;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

//Receiver class
public class CommandManager implements Receiver {

    private static final ArrayList<String> usedScriptFiles = new ArrayList<>();
    private final Stack<String> history = new Stack<>();
    private final CollectionWrapper collection;

    public CommandManager(CollectionWrapper collection) {
        this.collection = collection;
    }

    public void help() {
        history.push("help");
    }

    public void info() {
        ClientOutput.print("Collection type:");
        ClientOutput.print(collection.getType());
        ClientOutput.print("Init time:");
        ClientOutput.print(collection.getInitTime().toString());
        ClientOutput.print("Collection size:");
        ClientOutput.print(Integer.toString(collection.getSize()));
        history.push("info");
    }

    public void show() {
        ClientOutput.print(collection.toString());
        history.push("show");
    }

    public void exit() {
        history.push("exit");
    }

    public void add(StudyGroup studyGroup) {
        history.push("add");
        boolean result = collection.addElement(studyGroup);
    }

    public void updateId(StudyGroup studyGroup, int id) {
        collection.setElement(studyGroup, id);
    }

    public void removeById(int id) {
        collection.removeById(id);
        ClientOutput.print("Element " + id + " deleted.");
        history.push("remove_by_id " + id);
    }

    public void clear() {
        collection.clear();
        ClientOutput.print("Collection cleared.");
        history.push("clear");
    }

    public void save() {
        String file = System.getenv().get(collection.getEnvVariable());
        try {
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
            ClientOutput.print("Buffered ClientOutput stream created.");
            String text = collection.toString();
            ClientOutput.print(file);
            byte[] buffer = text.getBytes();
            ClientOutput.print("Byte array created.");
            stream.write(buffer);
            ClientOutput.print("Collection saved!");
            history.push("save");
            stream.close();
        } catch (IOException e) {
            ClientOutput.print("Err while saving!");
        }
    }

    public void removeFirst() {
        collection.removeFirst();
        ClientOutput.print("First element deleted.");
        history.push("remove_first");
    }

    public void removeHead() {
        collection.showAndRemoveFirst();
        history.push("remove_head");
    }

    public void removeAllByStudentsCount(Long count) {
        collection.removeByCount(count);
        ClientOutput.print("Groups with " + count + " students removed.");
        history.push("remove_all_by_students_count " + count);
    }

    public void history() {
        try {
            for (int i = 0; i < 12; i++) {
                ClientOutput.print(history.pop());
            }
            history.push("history");
        } catch (EmptyStackException e) {
            ClientOutput.print();
        }
    }

    public void executeScript(String filename) {
        if (usedScriptFiles.contains(filename)) {
            ClientOutput.print("Recursion found!");
        } else {
            usedScriptFiles.add(filename);
            try {
                CommandManager receiver = new CommandManager(collection);
                CommandParser commandParser = new CommandParser(receiver);
                Scanner sc = new Scanner(new File(filename));
                int flag = 0;
                List<String> noArgCommands = Arrays.asList("help", "info", "show", "clear", "save", "exit", "remove_first", "remove_head", "history", "print_ascending");
                List<String> intArgCommands = Arrays.asList("remove_by_id", "remove_all_by_students_count", "count_by_students_count");
                List<String> longArgCommands = Arrays.asList("remove_all_by_students_count", "count_by_students_count");
                List<String> stringArgCommands = Arrays.asList("execute_script");
                List<String> newElementArgCommands = Arrays.asList("add");

                while (flag == 0) {
                    String[] line = sc.nextLine().split(" ");
                    if (line[0].equals("update")) {
                        int id = Integer.parseInt(line[1]);
                        StudyGroup studyGroup = readElement();
                        Parameters parameters = Parameters.builder().id(id).studyGroup(studyGroup).build();
                        flag = new UpdateIdCommand(receiver).execute(parameters);
                    } else if (newElementArgCommands.contains(line[0])) {
                        StudyGroup studyGroup = readElement();
                        Parameters parameters = Parameters.builder().studyGroup(studyGroup).build();
                        flag = commandParser.get(line[0]).execute(parameters);
                    } else if (intArgCommands.contains(line[0])) {
                        Parameters parameters = Parameters.builder().num(Integer.parseInt(line[1])).build();
                        flag = commandParser.get(line[0]).execute(parameters);
                    } else if (longArgCommands.contains(line[0])) {
                        Parameters parameters = Parameters.builder().count(Long.parseLong(line[1])).build();
                        flag = commandParser.get(line[0]).execute(parameters);
                    } else if (stringArgCommands.contains(line[0])) {
                        Parameters parameters = Parameters.builder().filename(line[1]).build();
                        flag = commandParser.get(line[0]).execute(parameters);
                    } else if (noArgCommands.contains(line[0])) {
                        flag = commandParser.get(line[0]).execute(Parameters.builder().build());
                    }
                }
                history.push("execute_script " + filename);
            } catch (FileNotFoundException e) {
                ClientOutput.print("File not found.");
            }
        }
    }

    public void printAscending() {
        collection.printAscending();
        history.push("print_ascending");
    }

    public void countByStudentsCount(Long count) {
        Long k = collection.countGroupsByStudentsCount(count);
        ClientOutput.print(Long.toString(k));
        history.push("count_by_students_count " + count);
    }

    public StudyGroup readElement() {
        Scanner sc = new Scanner(System.in);
        ClientOutput.print("Enter group name:");
        String name = sc.nextLine();
        ClientOutput.print("Enter x:");
        Float x = Float.parseFloat(sc.nextLine());
        ClientOutput.print("Enter y:");
        Float y = Float.parseFloat(sc.nextLine());
        ClientOutput.print("Enter students count:");
        Long studentsCount = Long.parseLong(sc.nextLine());
        ClientOutput.print("Choose form of education (DISTANCE_EDUCATION/FULL_TIME_EDUCATION/EVENING_CLASSES):");
        FormOfEducation formOfEducation = FormOfEducation.valueOf(sc.nextLine());
        ClientOutput.print("Choose semester (FIRST/SECOND/THIRD/FIFTH/SEVENTH):");
        Semester semester = Semester.valueOf(sc.nextLine());
        ClientOutput.print("Enter admin's name:");
        String adminName = sc.nextLine();
        ClientOutput.print("Enter admin's birthday (Example: 2005-06-07):");
        LocalDate adminBirthday = LocalDate.parse(sc.nextLine());
        ClientOutput.print("Enter admin's height:");
        Double height = Double.parseDouble(sc.nextLine());
        ClientOutput.print("Enter admin's weight:");
        Double weight = Double.parseDouble(sc.nextLine());
        ClientOutput.print("Enter admin's passport ID:");
        String adminPassportID = sc.nextLine();
        return StudyGroup.builder()
                .name(name)
                .coordinates(new Coordinates(x, y))
                .studentsCount(studentsCount)
                .formOfEducationEnum(formOfEducation)
                .semesterEnum(semester)
                .groupAdmin(new Person(name, adminBirthday, height, weight, adminPassportID))
                .build();
    }
}
