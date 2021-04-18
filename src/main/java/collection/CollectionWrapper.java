package collection;

import execeptions.ExistingIDException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class CollectionWrapper {
    private final String envVariable;
    private PriorityQueue<StudyGroup> collection = new PriorityQueue<>();
    private final LocalDateTime initTime;
    private LocalDateTime lastSaveTime;
    private int currentId = 1;

    public CollectionWrapper(String envVariable) {
        this.envVariable = envVariable;
        System.out.println(envVariable);
        this.initTime = LocalDateTime.now();
        System.out.println(System.getenv().get(envVariable));
        //readCollection();
    }

    public void readCollection() {
        if (System.getenv().get(envVariable) != null) {
            try (InputStreamReader in = new InputStreamReader(new FileInputStream(System.getenv().get(envVariable)))) {
                int c = in.read();
                //System.out.println(c);
                String[] dataPackage;
                //String data = "";
                while (c != -1) {
                    StringBuilder data = new StringBuilder();
                    while (((char) c!='\n')&&(c != -1)){
                        //c = in.read();
                        data.append((char) c);
                        c = in.read();
                    }
                    dataPackage = data.toString().split(";");
                    collection.add(new StudyGroup(
                                    currentId,
                                    dataPackage[0],
                                    Float.parseFloat(dataPackage[1]),
                                    Float.parseFloat(dataPackage[2]),
                                    LocalDate.now(),
                                    Long.parseLong(dataPackage[3]),
                                    Visitor.visitFormOfEducation(dataPackage[4]),
                                    Visitor.visitSemester(dataPackage[5]),
                                    Visitor.visitPerson(dataPackage[6], dataPackage[7], dataPackage[8], dataPackage[9], dataPackage[10])
                            )
                    );
                    currentId += 1;
                    c = in.read();
                    System.out.println(c);
                }
                printCollection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("no file");
        }
    }

    public void printCollection() {
        for (StudyGroup i : collection) {
            System.out.println(i.getStudyGroup());
            System.out.println();
        }
    }

    public String getType(){
        return collection.getClass().getName();
    }

    public LocalDateTime getInitTime(){
        return initTime;
    }

    public int getSize(){
        return collection.size();
    }

    public String toString(){
        StringBuilder result = new StringBuilder();// Use StringBuilder
        for (StudyGroup item: collection){
            result.append(item.getStudyGroup());
            result.append("\n");
        }
        return result.toString();
    }

    public void addElement(String groupName,
                           Float x,
                           float y,
                           Long studentsCount,
                           String formOfEducation,
                           String semester,
                           String adminName,
                           String adminBirthday,
                           String adminHeight,
                           String adminWeight,
                           String adminPassportID
    ){
        collection.add(new StudyGroup(
                        currentId,
                        groupName,
                        x,
                        y,
                        LocalDate.now(),
                        studentsCount,
                        Visitor.visitFormOfEducation(formOfEducation),
                        Visitor.visitSemester(semester),
                        Visitor.visitPerson(adminName, adminBirthday, adminHeight, adminWeight, adminPassportID)
                )
        );
        currentId+=1;

    }

    public void addElementWithId(int id,
                                 String groupName,
                                 Float x,
                                 float y,
                                 Long studentsCount,
                                 String formOfEducation,
                                 String semester,
                                 String adminName,
                                 String adminBirthday,
                                 String adminHeight,
                                 String adminWeight,
                                 String adminPassportID
    )
    {
        try{
            for (StudyGroup element: collection){
                if (element.getId()==id){
                    throw new ExistingIDException();
                }
            }
            collection.add(new StudyGroup(
                            id,
                            groupName,
                            x,
                            y,
                            LocalDate.now(),
                            studentsCount,
                            Visitor.visitFormOfEducation(formOfEducation),
                            Visitor.visitSemester(semester),
                            Visitor.visitPerson(adminName, adminBirthday, adminHeight, adminWeight, adminPassportID)
                    )
            );
        } catch (ExistingIDException e){
            e.printStackTrace();
        }
    }

    public void removeById(int id){
        collection.removeIf(group -> (group.getId()==id));
    }

    public void clear(){
        collection = new PriorityQueue<>();
    }

    public String getEnvVariable(){
        return envVariable;
    }

    public void removeFirst(){
        collection.poll();
    }

    public void showAndRemoveFirst(){
        System.out.println(Objects.requireNonNull(collection.poll()).getStudyGroup());
    }

    public void removeByCount(Long count){
        collection.removeIf(group -> (group.getStudentsCount().equals(count)));
    }

    public void printAscending(){
        PriorityQueue<StudyGroup> c = new PriorityQueue<>(new AscendingCompare());
        c.addAll(collection);
        for (StudyGroup i : c) {
            System.out.println(i.getStudyGroup());
            System.out.println();
        }
    }


    public static class AscendingCompare implements Comparator<StudyGroup> {
        public int compare(StudyGroup o1, StudyGroup o2) {
            return -o1.compareTo(o2);
        }
    }

    public Long countGroupsByStudentsCount(Long studentsCount){
        long k = 0L;
        for (StudyGroup i: collection){
            if (i.getStudentsCount().equals(studentsCount)){
                k+=1;
            }
        }
        return k;
    }

    public void changeSaveTime(LocalDateTime newSaveTime){
        lastSaveTime = newSaveTime;
    }
}
