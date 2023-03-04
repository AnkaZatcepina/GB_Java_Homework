package OopLesson7.controller;
import java.util.List;

import OopLesson7.model.IRepository;
import OopLesson7.model.Note;

public abstract class AbstractNoteController {
    protected IRepository repository;
    public AbstractNoteController(IRepository repository){
        this.repository = repository;
    }
    public abstract Note readNote(String id) throws Exception;
    public abstract Note createNote(String header, String text);
    public abstract void deleteNote(String id) throws Exception;
    public abstract Note updateNote(Note note, String header, String text) throws Exception;
    public abstract List<Note> readAll();
}
