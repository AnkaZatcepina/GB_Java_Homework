package OopLesson7;

import OopLesson7.controller.*;
import OopLesson7.model.IRepository;
import OopLesson7.model.RepositoryFolderTxt;
import OopLesson7.view.*;


public class Main {


    public static void main(String[] args) {
        IRepository repository = new RepositoryFolderTxt("source//notesTxt");
        NoteController controller = new NoteController(repository);
        IView view = new ViewConsole(controller);
        view.run();
    }
    
}
