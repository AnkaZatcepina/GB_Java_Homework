package ExceptionsLesson3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения><номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

 * 
 */
public class Main {
    
    public static void main(String[] args) throws Exception{
        System.out.println("Введите данные в формате 'Фамилия Имя Отчество датарождения номертелефона пол':");
        String input = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine();
        String[] splited = input.split(" ");
        try {
            checkInput(splited);
        } catch (IncorrectInput e) {
            throw e;
        }
        writeToFile(splited);

    }

    private static void checkInput(String[] splitedInput) throws IncorrectInput{
        final int INPUT_AMOUNT = 6;
        if (splitedInput == null) {
            throw new IncorrectInput("Ничего не введено");                
        }
        if (splitedInput.length != INPUT_AMOUNT) {
            throw new IncorrectInput("Ожидается "+INPUT_AMOUNT+" значений разделённых пробелом");
        }

        //датарождения
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        try {
            dateFormat.parse(splitedInput[3]);
        } catch (ParseException e) {
            throw new IncorrectInput("Некорректный формат даты, ожидается dd.mm.yyyy");
        }

        //номертелефона
        boolean isNumeric = splitedInput[4].chars().allMatch( Character::isDigit );
        if (!isNumeric) {
            throw new IncorrectInput("Некорректный телефон, ожидается положительное число");                
        }
        

        //пол
        try {
            Sex sex = Sex.valueOf(splitedInput[5]);
        } catch (IllegalArgumentException e) {
            throw new IncorrectInput("Некорректно введён пол, ожидается f или m");
        
        }
    }

    public static void writeToFile(String[] splitedInput) 
    {
        String path = "java/GB/GB_Java_Homework/homework/src/main/java/ExceptionsLesson3/"+splitedInput[0];
        //String path = "./" + splitedInput[0];
        File file = new File(path);
        try (FileWriter fr = new FileWriter(file,true);
             BufferedWriter br = new BufferedWriter(fr))
        {
            br.append("<"+splitedInput[0]+">"
                    +"<"+splitedInput[1]+">"
                    +"<"+splitedInput[2]+">"
                    +"<"+splitedInput[3]+">"
                    +"<"+splitedInput[4]+">"
                    +"<"+splitedInput[5]+">"
                    +"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public enum Sex{
        f,m
    }

    public static class IncorrectInput extends Exception {
        public IncorrectInput (String message) {
            super(message);
        }
    }
}
