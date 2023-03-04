package OopLesson7.model;

import java.util.List;

public interface IRepository {
    List<Note> readAll();
    Note createNote(String header, String text);
    void deleteNote(Note note);
    void updateNote(Note note);
}
