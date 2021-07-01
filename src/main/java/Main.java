import collection.*;
import command.Command;
import command.CommandManager;
import command.Parameters;
import command.Receiver;
import lombok.Builder;
import util.ClientOutput;
import util.CommandParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CollectionWrapper collectionWrapper = new CollectionWrapper("DATA");
        Receiver receiver = new CommandManager(collectionWrapper);
        App app = new App(collectionWrapper, receiver, new CommandParser(receiver));
        app.start();

    }
}
