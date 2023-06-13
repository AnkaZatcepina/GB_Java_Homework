/* 
 *  1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
    2. Если необходимо, исправьте данный код 
    3. Дан следующий код, исправьте его там, где требуется 
    4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/

package ExceptionsLesson2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        //System.out.println(floatInput());
        task2();
        task3();
        strInput();
    }

    //1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
    private static float floatInput(){
        boolean ok = false;
        float result = 0;
        String input = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!ok){
            try {
                System.out.println("Введите дробное число");               
                input = reader.readLine();
                result = Float.parseFloat(input);
                ok = true;
            } catch (IOException e) {
                System.out.println("Что-то пошло не так");
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }           
            
        }
        return result;
    }

    //2. Если необходимо, исправьте данный код 
    private static void task2(){
    try {
        int d = 0;
        int[] intArray = new int[7];
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
     } catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Array Index is incorrect: " + e);     
     } catch (ArithmeticException e) {
        System.out.println("Catching exception: " + e);
     }
    }

    //3. Дан следующий код, исправьте его там, где требуется
    public static void task3() {

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;

        } catch (FileNotFoundException ex) {
            System.out.println("Файла внутри нет, но на всякий случай словим ошибку");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");    
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    //4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    private static void strInput(){
        String input = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку");               
        try {
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
        if (input.isEmpty()) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        }        
    }

     
}
