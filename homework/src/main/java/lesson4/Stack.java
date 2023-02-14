package lesson4;
/*
    Реализовать консольное приложение, которое:
    Принимает от пользователя и “запоминает” строки.
    Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
    Если введено revert, удаляет предыдущую введенную строку из памяти.
*/
import java.util.*;


public class Stack {

   

    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        ArrayDeque<String> wordsList = new ArrayDeque<>();

        while (true) {
            System.out.println();
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();

            if (inputString.length() == 0) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }

            switch (inputString) {
                case "stop":
                    System.exit(0);
                    break;
                case "print":
                    Iterator iterator = wordsList.descendingIterator();
                    while(iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;
                case "revert":                   
                    if (wordsList.size() > 0) {
                        wordsList.removeLast();
                    } else {
                        System.out.println("Стек уже пуст");
                    }
                    break;
                default:             
                    wordsList.add(inputString);
                    break;
            }   
        }

    }
}
