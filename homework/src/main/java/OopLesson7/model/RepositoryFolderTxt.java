package OopLesson7.model;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositoryFolderTxt implements IRepository{
    private String path = "";
    private IParser parser;                

    public RepositoryFolderTxt(String path, IParser parser){
        this.path = path;     
        this.parser = parser;    
    }

    @Override
    public List<Note> readAll() {
        List<Note> notes = new ArrayList<>();
        File folderPath = new File(this.path);
        File filesList[] = folderPath.listFiles();
        if (filesList == null)
        {
            System.out.println("Не найдены файлы.");
            return null;
        }    

        Arrays.sort(filesList);
        for(File file : filesList) {
            try { 
                String fileName = file.getName();
                Note note = fillFile(fileName);
                notes.add(note);
            } catch (Exception ee) {
                System.out.printf("Ошибка чтения файла: %s\n", ee.getMessage());
            }
        }
        return notes;
    }

    private Note fillFile(String fileName) throws ParseException {
        String noteId = fileName.split("\\.(?=[^\\.]+$)")[0];
        Note note = new Note(noteId);  
        IFileOperation fileOperation = new FileOperation(getFilePath(note));        
        List<String> lines = fileOperation.readAllLines();
        return parser.parseFileToNote(lines, note);
    }

    @Override
    public Note createNote(String header, String text) {
        List<Note> notes = readAll();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);

        Note note = new Note(id, header, text);
        IFileOperation fileOperation = new FileOperation(getFilePath(note));
        fileOperation.saveAllLines(parser.parseNoteToFile(note));
        return note;
    }

    @Override
    public void deleteNote(Note note) {
        IFileOperation fileOperation = new FileOperation(getFilePath(note));
        fileOperation.deleteFile();
    }

    @Override
    public void updateNote(Note note) {
        IFileOperation fileOperation = new FileOperation(getFilePath(note));
        fileOperation.deleteFile();
        fileOperation.saveAllLines(parser.parseNoteToFile(note));
    }

    private String getFilePath(Note note){
        return this.path + "/" + note.getId() + ".txt";
    }

}