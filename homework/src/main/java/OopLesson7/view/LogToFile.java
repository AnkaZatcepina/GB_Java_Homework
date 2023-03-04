package OopLesson7.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogToFile implements ILog{
    String fileName;
    public LogToFile(String fileName){
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void writeLog(String log) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(new Date().toString());
            writer.write("   "+ log);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
