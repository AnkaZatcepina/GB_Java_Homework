package OopLesson7.controller;
import java.util.List;

import OopLesson7.model.IRepository;
import OopLesson7.model.Note;
import OopLesson7.view.ILog;

public class NoteControllerLogDecorated extends AbstractNoteController{
    private ILog logger;

    public NoteControllerLogDecorated(IRepository repository, ILog logger){
        super(repository);
        this.logger = logger;
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
        Note note = repository.createNote(header, text);
        logger.writeLog("Note created: " + note.getId() + ".txt");
        return note;
    }

    public void deleteNote(String id) throws Exception {
        for (Note note : readAll()) {
            if (note.getId().equals(id))
            {
                repository.deleteNote(note);
                logger.writeLog("Note deleted: " + id + ".txt");
                return;
            }
        }
        throw new Exception("нет такого индекса");
        
    }

    public Note updateNote(Note note, String header, String text) throws Exception {
        note.setHeader(header);
        note.setText(text);
        repository.updateNote(note);
        
        logger.writeLog("Note updated: " + note.getId() + ".txt");
        return note;
    }

    public List<Note> readAll(){
        return repository.readAll();
    } 
}
