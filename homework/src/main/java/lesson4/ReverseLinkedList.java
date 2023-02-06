package lesson4;

import java.util.*;
/*
    Пусть дан LinkedList с несколькими элементами. 
    Реализуйте метод, который вернет “перевернутый” список.
*/
public class ReverseLinkedList {
    public static void main( String[] args )
    {
        LinkedList<String> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "первый", "второй", "третий", "четвертый");
        
        System.out.println(linkedList);
        System.out.println(reverseLinkedList(linkedList));

    }

    public static LinkedList<String> reverseLinkedList(LinkedList<String> linkedList)
    {
        LinkedList<String> reversedList = new LinkedList<>();
        for (int i = (linkedList.size() - 1); i >= 0; i--){
            reversedList.add(linkedList.get(i));
        }

        return reversedList;
    }
}
