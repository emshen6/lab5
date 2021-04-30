package command;

import collection.CollectionWrapper;
import collection.StudyGroup;
import collection.StudyGroupBuilder;
import collection.Validation;
import util.ClientOutput;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

//Receiver class
public class ConsoleReceiver implements Receiver {

    private static final ArrayList<String> usedScriptFiles = new ArrayList<>();
    private final Stack<String> history = new Stack<>();
    private final CollectionWrapper collection;

    public ConsoleReceiver(CollectionWrapper collection) {
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

    public void add(StudyGroupBuilder builder) {
        history.push("add");
        boolean result = collection.addElement(builder);
        if (!result) builder.userInput();
    }

    public void updateId(StudyGroupBuilder builder, int id) {
        StudyGroup group = collection.getGroupById(id);
        LocalDate date = group.getCreationDate();
        builder.setCreationDate(date);
        StudyGroup newElement = builder.getResult();
        if (Validation.validateStudyGroup(newElement)) {
            collection.removeById(id);
            collection.addElement(newElement);
        }
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
            ClientOutput.print("Buffered output stream created.");
            String text = collection.getSavableView();
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
                Scanner sc = new Scanner(new File(filename));
                ConsoleReceiver consolereceiver = new ConsoleReceiver(collection);
                ConsoleBuilder builder = new ConsoleBuilder(consolereceiver);
                Director director = new Director();
                director.constructConsole(builder);
                ConsoleInvoker console = builder.getResult();
                int flag = 0;
                String line;
                while ((flag == 0) && (sc.hasNextLine())) {
                    line = sc.nextLine();
                    flag = console.execute(line);
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

    public void countByStudentsCount(Long studentsCount) {
        Long k = collection.countGroupsByStudentsCount(studentsCount);
        ClientOutput.print(Long.toString(k));
        history.push("count_by_students_count " + studentsCount);
    }
}
