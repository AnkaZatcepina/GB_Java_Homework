package ExceptionsLesson1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/*
    1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    2. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
    3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
*/
public class Main {
    public static void main(String[] args) {
        //int value = stringToInt("test");
        //int division = divide(1,0);
        //String file = readFile("test.txt");
        int[] array1 = new int[]{ 1,2,3 };
        int[] array2 = new int[]{ 3,2,1 };
        System.out.println(Arrays.toString(calcArrayDiff(array1, array2)));
        int[] array3 = new int[]{ 3,2 };
        //System.out.println(Arrays.toString(calcArrayDiff(array1, array3)));
        //System.out.println(Arrays.toString(calcArrayDiff(array1, null )));
        System.out.println(Arrays.toString(calcArrayDivision(array1, array2)));
        int[] array4 = new int[]{ 3,2,0 };
        System.out.println(Arrays.toString(calcArrayDivision(array1, array4)));
    }

    //1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    //NumberFormatException
    private static int stringToInt(String value){
        int intValue = Integer.parseInt(value);
        return intValue;
    }
    //ArithmeticException
    private static int divide(int val1, int val2){
        return val1 / val2;
    }
    //FileNotFoundException
    //IOException
    private static String readFile(String filePath){
        FileReader file = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(file);
        String s = reader.readLine();
        return s;
    }

    //2. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
    private static int[] calcArrayDiff(int[] array1, int[] array2){
        if (array1 == null || array2 == null) {
            throw new RuntimeException("Пришёл пустой массив");
        }
        if (array1.length != array2.length) {
            throw new RuntimeException("Количество элементов массивов не совпадает");
        }
        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++)
        {
            result[i] = array1[i] - array2[i];
        }
        return result;
        
    }

    //3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
    private static int[] calcArrayDivision(int[] array1, int[] array2){
        if (array1 == null || array2 == null) {
            throw new RuntimeException("Пришёл пустой массив");
        }
        if (array1.length != array2.length) {
            throw new RuntimeException("Количество элементов массивов не совпадает");
        }
        int[] result = new int[array1.length];
        try {
            for (int i = 0; i < array1.length; i++)
            {
                result[i] = array1[i]  / array2[i];
            }
        } catch (ArithmeticException e) {
            throw new RuntimeException("Деление на ноль невозможно");
        }
        
        return result;
        
    }
}
