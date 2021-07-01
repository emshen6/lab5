package collection;


import util.ClientOutput;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class CollectionWrapper {
    private final String envVariable;
    private final LocalDateTime initTime;
    private PriorityQueue<StudyGroup> collection = new PriorityQueue<>();
    private CollectionReader collectionReader;

    public CollectionWrapper(String envVariable) {
        this.envVariable = envVariable;
        this.initTime = LocalDateTime.now();
        CollectionReader collectionReader = new CollectionReader();
        collection.addAll(collectionReader.readCollection(envVariable));
    }


    public void printCollection() {
        for (StudyGroup i : collection) {
            ClientOutput.print(i.toString());
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
            result.append(item.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public boolean addElement(StudyGroup studyGroup) {
        collection.add(studyGroup);
        ClientOutput.print("Element added.");
        Id.last += 1;
        return true;
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
        ClientOutput.print(Objects.requireNonNull(collection.poll()).toString());
    }

    public void removeByCount(Long count) {
        collection.removeIf(group -> (group.getStudentsCount().equals(count)));
    }

    public void printAscending() {
        PriorityQueue<StudyGroup> c = new PriorityQueue<>(new AscendingCompare());
        c.addAll(collection);
        for (StudyGroup i : c) {
            ClientOutput.print(i.toString());
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

    public void setElement(StudyGroup studyGroup, int id) {
        Id.last -= 1;
        studyGroup = studyGroup.toBuilder().id(id).build();
        removeById(id);
        addElement(studyGroup);
    }

    public static class AscendingCompare implements Comparator<StudyGroup> {
        public int compare(StudyGroup o1, StudyGroup o2) {
            return -o1.compareTo(o2);
        }
    }
}
