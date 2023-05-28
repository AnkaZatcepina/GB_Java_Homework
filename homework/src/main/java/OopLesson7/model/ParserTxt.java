package OopLesson7.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ParserTxt implements IParser{
    SimpleDateFormat formatter;
    public ParserTxt(SimpleDateFormat formatter){
        this.formatter = formatter;
    }

    @Override
    public Note parseFileToNote(List<String> lines, Note note) throws ParseException {
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
    public List<String> parseNoteToFile(Note note) {
        List<String> lines = new ArrayList<>();
        lines.add(note.getHeader());
        lines.add(formatter.format(note.getDate()));
        lines.add(note.getText());
        return lines;
    }
    
}
