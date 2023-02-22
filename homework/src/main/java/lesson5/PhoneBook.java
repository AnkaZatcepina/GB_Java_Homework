package lesson5;
/*
    Реализуйте структуру телефонной книги с помощью HashMap, 
    учитывая, что 1 человек может иметь несколько телефонов.
*/

import java.util.*;

public class PhoneBook {
    public static HashMap<String, List<String>> phoneBook = new HashMap<>();

    public static void main( String[] args )
    {
        addPhone("Катя", "+79111223344");
        addPhone("Вера", "+79111223355");
        addPhone("Катя", "+79111223366");
        addPhone("Катя", "+79111223377");
        System.out.println(phoneBook); 
        deletePhone("Катя", "+79111223366");
        deletePhone("Вера", "+79111223355");
        System.out.println(phoneBook); 
    }

    //Добавление контакта / добавление телефона в контакт, если такой контакт уже есть
    private static void addPhone(String name, String phoneNumber) 
    {
        if (!phoneBook.containsKey(name)) 
        {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.putIfAbsent(name, phoneNumbers);
        } else {
            phoneBook.get(name).add(phoneNumber);
        } 
         
    }  

    //Удаление телефона из контакта   
    private static void deletePhone(String name, String phoneNumber) 
    {
        if (phoneBook.containsKey(name)) 
        {
            phoneBook.get(name).removeIf(n -> (n.equals(phoneNumber)));
        } 
    }  
    
}
