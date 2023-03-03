package OopLesson7.controller;

import java.util.List;

import OopLesson7.model.Note;

public interface IRepository {
    List<Note> readAll();
    Note createNote(String header, String text);
    void deleteNote(Note note);
    void updateNote(Note note);
}
