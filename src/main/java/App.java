import collection.*;
import command.AddCommand;
import command.Parameters;
import command.Receiver;
import command.UpdateIdCommand;
import util.ClientOutput;
import util.CommandParser;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    private CollectionWrapper collectionWrapper;
    private Receiver receiver;
    private CommandParser commandParser;

    public App(CollectionWrapper collectionWrapper, Receiver receiver, CommandParser commandParser) {
        this.collectionWrapper = collectionWrapper;
        this.receiver = receiver;
        this.commandParser = commandParser;
    }

    public void start(){
        Id.last = 1;
        Scanner sc = new Scanner(System.in);
        int flag=0;
        List<String> noArgCommands = Arrays.asList("help", "info", "show", "clear", "save", "exit", "remove_first", "remove_head", "history", "print_ascending");
        List<String> intArgCommands = Arrays.asList("remove_by_id", "remove_all_by_students_count", "count_by_students_count");
        List<String> longArgCommands = Arrays.asList("remove_all_by_students_count", "count_by_students_count");
        List<String> stringArgCommands = Arrays.asList("execute_script");
        List<String> newElementArgCommands = Arrays.asList("add");

        while (flag == 0) {
            String[] line = sc.nextLine().split(" ");
            if (line[0].equals("update")){
                int id=Integer.parseInt(line[1]);
                StudyGroup studyGroup = receiver.readElement();
                Parameters parameters= Parameters.builder().id(id).studyGroup(studyGroup).build();
                flag = new UpdateIdCommand(receiver).execute(parameters);
            } else if (newElementArgCommands.contains(line[0])){
                StudyGroup studyGroup = receiver.readElement();
                Parameters parameters= Parameters.builder().studyGroup(studyGroup).build();
                flag = commandParser.get(line[0]).execute(parameters);
            } else if (intArgCommands.contains(line[0])){
                Parameters parameters= Parameters.builder().num(Integer.parseInt(line[1])).build();
                flag = commandParser.get(line[0]).execute(parameters);}
            else if (longArgCommands.contains(line[0])){
                Parameters parameters= Parameters.builder().count(Long.parseLong(line[1])).build();
                flag = commandParser.get(line[0]).execute(parameters);
            } else if (stringArgCommands.contains(line[0])){
                Parameters parameters= Parameters.builder().filename(line[1]).build();
                flag = commandParser.get(line[0]).execute(parameters);
            } else if (noArgCommands.contains(line[0])){
                flag = commandParser.get(line[0]).execute(Parameters.builder().build());
            }
        }
    }

}
