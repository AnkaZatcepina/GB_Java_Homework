package OopLesson7;

import java.text.SimpleDateFormat;

import OopLesson7.controller.*;
import OopLesson7.model.IRepository;
import OopLesson7.model.ParserTxt;
import OopLesson7.model.RepositoryFolderTxt;
import OopLesson7.view.*;


public class Main {


    public static void main(String[] args) {
        IRepository repository = new RepositoryFolderTxt("source//notesTxt", new ParserTxt(new SimpleDateFormat("dd.MM.yyyy")));
        //AbstractNoteController controller = new NoteController(repository);
        AbstractNoteController controller = new NoteControllerLogDecorated(repository, new LogToFile("source//log.txt"));
        
        IView view = new ViewConsole(controller);
        view.run();
    }
    
}
