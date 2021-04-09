package command;

//Receiver interface
public interface Receiver {
    void help();

    void info();

    void show();

    void exit();

    void add();

    void updateId(int id);

    void removeById(int id);

    void clear();

    void save();

    void removeFirst();

    void removeHead();

    void removeAllByStudentsCount(Long count);

    void history();

    void executeScript(String filename);

    void printAscending();

    void countByStudentsCount(Long studentCount);
}
