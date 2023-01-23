package lesson1;

import java.util.Arrays;
import java.util.Random;

public class Main 
{
    public static void main( String[] args )
    {    
        //Задание 1 
        System.out.println();
        getMinMaxInArray();

        //Задание 2
        System.out.println();
        System.out.println("Високосный год:");
        System.out.println("2000 - " + isLeapYear(2000));
        System.out.println("2023 - " + isLeapYear(2023));
        System.out.println("2024 - " + isLeapYear(2024));
        System.out.println("2100 - " + isLeapYear(2100));
        System.out.println();

        //Задание 3
        int[] intArray = new int[] {3, 2, 2, 3};
        int[] newArray = moveValueToEndOfArray(intArray, 3);
        int[] intArray2 = new int[] {1, 1, 4, 5, 6, 1, 7, 8, 1};
        int[] newArray2 = moveValueToEndOfArray(intArray2, 1);
    
    }


    /*
        Задать одномерный массив и найти в нем минимальный и максимальный элементы
    */
    private static void getMinMaxInArray()
    {
        int[] intArray = new int[10];
        Random random = new Random();

        for (int i = 0; i<intArray.length; i++){
            intArray[i] = random.nextInt(100);
        }

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(intArray));
        System.out.println("Максимум = " + Arrays.stream(intArray).max().getAsInt());     
        System.out.println("Минимум = " + Arrays.stream(intArray).min().getAsInt());
    }


    /*
        Написать метод, который определяет, является ли год високосным, 
        и возвращает boolean (високосный - true, не високосный - false). 
        Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    */
    private static boolean isLeapYear(int year)
    {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }   
        return false;       
    }

    /*
        Дан массив nums = [3,2,2,3] и число val = 3.
        Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
        Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
    */
    private static int[] moveValueToEndOfArray(int[] intArray, int value)
    {
        int[] newIntArray = new int[intArray.length];
        int count = 0;
        
        for (int i = 0; i<intArray.length; i++){
            if (intArray[i] != value) {
                newIntArray[count]=intArray[i];
                count++;
            }
        }
        for (int i = count; i<newIntArray.length; i++){
            newIntArray[i] = value;
        }

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(intArray));
        System.out.println("Новый массив:");
        System.out.println(Arrays.toString(newIntArray));
        return newIntArray;
    }
}
