package OopLesson7.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
    private String id;
    private String header;
    private String text;
    private Date date;

    public Note(String id){
        this.id = id;
    }

    public Note(String id, String header, String text){
        this(id);
        this.header = header;
        this.text = text;
        this.date = new Date();
    }

    public Note(String id, String header, String text, Date date){
        this(id,header,text);
        this.date = date;
    }

    public String getId(){
        return this.id;
    }
    public String getHeader(){
        return this.header;
    }
    public String getText(){
        return this.text;
    }
    public Date getDate(){
        return this.date;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setHeader(String header){
        this.header = header;
    }
    public void setText(String text){
        this.text = text;
    }
    
    public void setDate(Date date){
        this.date = date;
    }

    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");  
        return String.format("Заметка: %s\nЗаголовок: %s\nДата: %s\nТекст: %s", id, header, dateFormat.format(date), text);    
    }

}
