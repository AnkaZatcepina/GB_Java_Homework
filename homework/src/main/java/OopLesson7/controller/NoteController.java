package OopLesson7.controller;

import java.util.List;

import OopLesson7.model.IRepository;
import OopLesson7.model.Note;


public class NoteController {
    private IRepository repository;
    public NoteController(IRepository repository){
        this.repository = repository;
    }

    public Note readNote(String id) throws Exception {
        for (Note note : readAll()) {
            if (note.getId().equals(id))
            {
                return note;
            }
        }
        throw new Exception("нет такого индекса");
    }

    public Note createNote(String header, String text){
        return repository.createNote(header, text);
    }

    public void deleteNote(String id) throws Exception {
        for (Note note : readAll()) {
            if (note.getId().equals(id))
            {
                repository.deleteNote(note);
                return;
            }
        }
        throw new Exception("нет такого индекса");
    }

    public Note updateNote(Note note, String header, String text) throws Exception {
        note.setHeader(header);
        note.setText(text);
        repository.updateNote(note);
        return note;
    }

    public List<Note> readAll(){
        return repository.readAll();
    }
}
