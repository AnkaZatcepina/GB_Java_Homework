package lesson4;

import java.util.*;
/*
    Пусть дан LinkedList с несколькими элементами. 
    Реализуйте метод, который вернет “перевернутый” список.
*/
public class ReverseLinkedList {
    public static void main( String[] args )
    {
        //Разворот с помощью вспомогательного списка
        LinkedList<String> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "первый", "второй", "третий", "четвертый");
        
        System.out.println(linkedList);
        System.out.println(reverseLinkedList(linkedList));

        //Разворот без вспомогательного списка
        LinkedList<String> linkedList2 = new LinkedList<>();
        Collections.addAll(linkedList2, "пятый", "шестой", "седьмой", "восьмой");
        System.out.println(linkedList2);
        System.out.println(reverseLinkedList2(linkedList2));

    }

    public static LinkedList<String> reverseLinkedList(LinkedList<String> linkedList)
    {
        LinkedList<String> reversedList = new LinkedList<>();
        for (int i = (linkedList.size() - 1); i >= 0; i--){
            reversedList.add(linkedList.get(i));
        }

        return reversedList;
    }

    public static LinkedList<String> reverseLinkedList2(LinkedList<String> linkedList)
    {
        for (int i = (linkedList.size() - 1); i >= 1; i--){
            linkedList.add(i, linkedList.pop());
        }

        return linkedList;
    }
}
