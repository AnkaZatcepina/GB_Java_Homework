package OopLesson7.view;

import java.util.List;
import java.util.Scanner;
import OopLesson7.controller.AbstractNoteController;
import OopLesson7.model.Note;

public class ViewConsole implements IView{
    private AbstractNoteController controller;

    public ViewConsole(AbstractNoteController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        Commands com = Commands.NONE;
        while (true) {
            try {
                System.out.println("Для вывода информации по командам введите команду HELP.");
                String command = prompt("Введите команду:");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case HELP:
                        commandHelp();
                        break;
                    case CREATE:
                        commandCreate();
                        break;
                    case READ:
                        commandRead();
                        break;
                    case LIST:
                        commandList();
                        break;
                    case DELETE:
                        commandDelete();
                        break;
                    case UPDATE:
                        commandUpdate();
                        break;
                }
            } catch (Exception ee) {
                System.out.printf("Ошибка: %s\n", ee.getMessage());
            }
        }
    }

    public void commandUpdate() {
        String index = prompt("Введите номер заметки:");
        try {
            try {
                Note note = controller.readNote(index);
                String header = prompt("Заголовок:");
                String text = prompt("Текст:");
                controller.updateNote(note, header, text);
                System.out.println("Заметка сохранена");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void commandDelete() {
        String index = prompt("Введите номер заметки:");
        try {
            controller.deleteNote(index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void commandList() {
        List<Note> notes = controller.readAll();
        for (Note note : notes) {
            System.out.println(note);
            System.out.println();
        }
    }

    public void commandRead() {
        String index = prompt("Введите номер заметки:");
        try {
            System.out.println(controller.readNote(index));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void commandCreate() {
        String header = prompt("Введите заголовок заметки:");
        String text = prompt("Введите текст заметки:");
        controller.createNote(header, text);
    }

    public void commandHelp() {
        System.out.println("Список команд:");                  
        for (Commands command : Commands.values()) {
            System.out.println(command); 
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    
}
