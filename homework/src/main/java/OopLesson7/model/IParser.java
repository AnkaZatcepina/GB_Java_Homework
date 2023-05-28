package OopLesson7.model;

import java.text.ParseException;
import java.util.List;

public interface IParser {
    Note parseFileToNote(List<String> lines, Note note) throws ParseException;
    List<String> parseNoteToFile(Note note);
}
