package lesson2;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main( String[] args )
    {
        //Задание 1 - палиндром
        String str1 = "Тест";
        System.out.println("Палиндром ли строка:" + str1);
        System.out.println("1й метод: " + isPalondrome(str1));
        System.out.println("2й метод: " + isPalondrome2(str1));
        String str2 = "А роза упала на лапу Азора";
        System.out.println("Палиндром ли строка:" + str2);
        System.out.println("1й метод: " + isPalondrome(str2));
        System.out.println("2й метод: " + isPalondrome2(str2));

        //Задание 2 - повтор слова и запись в файл
        String multiplyStr = multiplyString("TEST",100);
        System.out.println(multiplyStr);
        writeStringToFile(multiplyStr);
        writeStringToFileBufferedWriter(multiplyStr);
    }
    /*
        Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).
    */
    //метод перебором символов
    private static boolean isPalondrome(String str) 
    {
        String lowerString = str.toLowerCase().replaceAll(" ", "");
        int length = lowerString.length();
        for (int i = 0; i < length / 2; i++) {
            if (lowerString.charAt(i) != lowerString.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;       
    }   
    //метод с помощью разворота строки с использованием StringBuilder
    private static boolean isPalondrome2(String str) 
    {
        String lowerString = str.toLowerCase().replaceAll(" ", "");
        int length = lowerString.length();
        int middle = length / 2 + ((length % 2 > 0) ? 1 : 0);
        StringBuilder sb=new StringBuilder(lowerString.substring(middle,length));  
        sb.reverse();  
        String revertedStringEnd = sb.toString(); 
        return lowerString.substring(0,length / 2).equals(revertedStringEnd);     
    }
    /*
        Напишите метод, который составит строку, состоящую из 100 повторений слова TEST 
        и метод, который запишет эту строку в простой текстовый файл, обработайте исключения.
    */
    private static String multiplyString(String str, int amount) 
    {
        if (amount <= 0) return "";

        StringBuilder sb=new StringBuilder(str);
        for (int i = 0; i < amount - 1; i++){
            sb.append(str);
        }  
        return sb.toString();     
    }
    public static void writeStringToFile(String str) 
    {
        try {
            Files.write(Paths.get("../../resources/lesson2/stringToFile.txt"), str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeStringToFileBufferedWriter(String str) 
    {
        File file = new File("../../resources/lesson2/stringToFileBufferedWriter.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            br.write(str);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
