package collection;


import util.ClientOutput;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class CollectionWrapper {
    private final String envVariable;
    private final LocalDateTime initTime;
    private PriorityQueue<StudyGroup> collection = new PriorityQueue<>();
    private int currentId = 1;

    public CollectionWrapper(String envVariable) {
        this.envVariable = envVariable;
        this.initTime = LocalDateTime.now();
        readCollection();
    }

    public void readCollection() {
        String filename = System.getenv().get(envVariable);
        if (filename != null) {
            try (InputStreamReader in = new InputStreamReader(new FileInputStream(filename))) {
                int c = in.read();
                String[] dataPackage;
                while (c != -1) {
                    StringBuilder data = new StringBuilder();
                    while (((char) c != '\n') && (c != -1)) {
                        data.append((char) c);
                        c = in.read();
                    }
                    dataPackage = data.toString().split(";");

                    StudyGroupBuilder builder = new StudyGroupBuilder();
                    builder.setId(currentId);
                    currentId += 1;
                    builder.setGroupName(dataPackage[0]);
                    int i;
                    if (dataPackage.length == 11) {
                        i = 3;
                        builder.setCoordinates(dataPackage[1], dataPackage[2]);
                    } else {
                        i = 2;
                        builder.setCoordinates(dataPackage[1]);
                    }
                    builder.setCreationDate(LocalDate.now());
                    builder.setStudentsCount(dataPackage[i]);
                    builder.setFormOfEducation(dataPackage[i + 1]);
                    builder.setSemester(dataPackage[i + 2]);
                    builder.setAdmin(dataPackage[i + 3], dataPackage[i + 4], dataPackage[i + 5], dataPackage[i + 6], dataPackage[i + 7]);
                    StudyGroup element = builder.getResult();
                    if (Validation.validateStudyGroup(element)) {
                        collection.add(element);
                        ClientOutput.print("Element added.");
                    } else {
                        ClientOutput.print("Invalid element!");
                    }
                    c = in.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ClientOutput.print("no file");
        }
    }

    public void printCollection() {
        StudyGroupFormatter formatter = new StudyGroupFormatter();
        for (StudyGroup i : collection) {
            ClientOutput.print(i.toFormattedString(formatter));
            ClientOutput.print();
        }
    }

    public String getType() {
        return collection.getClass().getName();
    }

    public LocalDateTime getInitTime() {
        return initTime;
    }

    public int getSize() {
        return collection.size();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (StudyGroup item : collection) {
            result.append(item.toFormattedString(new StudyGroupFormatter()));
            result.append("\n");
        }
        return result.toString();
    }

    public boolean addElement(StudyGroupBuilder builder) {
        builder.setId(currentId);
        builder.setCreationDate(LocalDate.now());
        StudyGroup element = builder.getResult();
        if (Validation.validateStudyGroup(element)) {
            collection.add(element);
            ClientOutput.print("Element added.");
            currentId += 1;
            return true;
        } else {
            ClientOutput.print("Study group invalid!");
            return false;
        }
    }

    public void addElement(StudyGroup group) {
        collection.add(group);
        ClientOutput.print("Element added.");
    }

    public void removeById(int id) {
        collection.removeIf(group -> (group.getId() == id));
    }

    public void clear() {
        collection = new PriorityQueue<>();
    }

    public String getEnvVariable() {
        return envVariable;
    }

    public void removeFirst() {
        collection.poll();
    }

    public void showAndRemoveFirst() {
        ClientOutput.print(Objects.requireNonNull(collection.poll()).toFormattedString(new StudyGroupFormatter()));
    }

    public void removeByCount(Long count) {
        collection.removeIf(group -> (group.getStudentsCount().equals(count)));
    }

    public void printAscending() {
        PriorityQueue<StudyGroup> c = new PriorityQueue<>(new AscendingCompare());
        c.addAll(collection);
        for (StudyGroup i : c) {
            ClientOutput.print(i.toFormattedString(new StudyGroupFormatter()));
            ClientOutput.print();
        }
    }

    public Long countGroupsByStudentsCount(Long studentsCount) {
        long k = 0L;
        for (StudyGroup i : collection) {
            if (i.getStudentsCount().equals(studentsCount)) {
                k += 1;
            }
        }
        return k;
    }

    public StudyGroup getGroupById(int id) {
        for (StudyGroup item : collection) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    public static class AscendingCompare implements Comparator<StudyGroup> {
        public int compare(StudyGroup o1, StudyGroup o2) {
            return -o1.compareTo(o2);
        }
    }
}
