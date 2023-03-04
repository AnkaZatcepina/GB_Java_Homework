package OopLesson7.controller;

import java.util.List;

public interface IFileOperation {
    List<String> readAllLines();
    void saveAllLines(List<String> lines);
    void deleteFile();
}
