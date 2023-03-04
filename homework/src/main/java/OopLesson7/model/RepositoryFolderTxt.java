package OopLesson7.model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositoryFolderTxt implements IRepository{
    String path = "";
    SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
                    

    public RepositoryFolderTxt(String path){
        this.path = path;     
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
                Note note = parseFile(fileName);
                notes.add(note);
            } catch (Exception ee) {
                System.out.printf("Ошибка чтения файла: %s\n", ee.getMessage());
            }
        }
        return notes;
    }

    private Note parseFile(String fileName) throws ParseException {
        String noteId = fileName.split("\\.(?=[^\\.]+$)")[0];
        Note note = new Note(noteId);  
        IFileOperation fileOperation = new FileOperation(getFilePath(note));        
        List<String> lines = fileOperation.readAllLines();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            switch (i) {
                case 0:
                    note.setHeader(line);
                    break;
                case 1:
                    note.setDate(formatter.parse(line));
                    break;                  
                case 2:
                    note.setText(line);
                    break;    
            }    
        
        }
        return note;
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
        fileOperation.saveAllLines(fillLines(note));
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
        fileOperation.saveAllLines(fillLines(note));
    }

    private List<String> fillLines(Note note){
        List<String> lines = new ArrayList<>();
        lines.add(note.getHeader());
        lines.add(formatter.format(note.getDate()));
        lines.add(note.getText());
        return lines;
    }

    private String getFilePath(Note note){
        return this.path + "/" + note.getId() + ".txt";
    }

}