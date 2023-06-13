package ExceptionsLesson3CW;

import java.io.IOException;


/*
1. Создайте метод doSomething(), который может быть источником одного из
типов checked exceptions (тело самого метода прописывать не обязательно).
Вызовите этот метод из main и обработайте в нем исключение, которое
вызвалметод doSomething().
2. Создайте класс Счетчик, у которого есть метод add(), увеличивающий
значение внутренней int переменной на 1.Сделайте так, чтобы с объектом
такого типа можно было работать в блоке try-with-resources. Нужно бросить
исключение, если работа с объектом типа счетчик была не в ресурсном try
и/или ресурс остался открыт.Подумайте какой тип исключения подойдет
лучше всего.
3. Создайте класс исключения, который будет выбрасываться при делении на 0.
    Исключение должно отображать понятное для пользователя сообщение
об ошибке.
    Создайте класс исключений, которое будет возникать при обращении к
пустому элементу в массиве ссылочного типа. Исключение должно
отображать понятное для пользователя сообщение об ошибке
    Создайте класс исключения, которое будет возникать при попытке открыть
несуществующий файл. Исключение должно отображать понятное для
пользователя сообщение об ошибке.
4. Напишите метод, на вход которого подаётся двумерный строковый массив
размером 4х4. При подаче массива другого размера необходимо бросить
исключение MyArraySizeException.
    Далее метод должен пройтись по всем элементам массива,преобразовать в
int и просуммировать. Если в каком-то элементе массива преобразование
не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в
какой именно ячейке лежат неверные данные.
    В методе main() вызвать полученный метод, обработать возможные
исключения MyArraySizeException и MyArrayDataException и вывести
результат расчета (сумму элементов,при условии что подали на вход
корректный массив).
*/
public class Main {
    public static void main(String[] args) throws Exception{
        //task1();
        //task2();
        //task3_2();
        task4();
    }

    //Задача 1
    public static void task1() {
        try {
            doSomething();
        }
        catch (IOException e){
            System.out.println("Исключение ввода-вывода");
        }
    }
    public static void doSomething() throws IOException {
        throw new IOException();
    }

    //Задача 2
    public static void task2() {
        try (MyCounter counter = new MyCounter(1)){
            counter.add();
            System.out.println(counter);
            counter.add();
            System.out.println(counter);
            counter.add();
            System.out.println(counter);
            counter.close();
            counter.add();
        } catch (IOException e) {
            throw new RuntimeException("Счётчик закрыт");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Задача 3
    public static void task3_1() throws MyZeroDividerException{
        throw new MyZeroDividerException();
    }
    public static void task3_2() throws MyFileNotFoundException{
        throw new MyFileNotFoundException();
    }

    public static class MyZeroDividerException extends Exception {
        public MyZeroDividerException () {
            super("Делить на ноль нельзя");
        }
    }

    public static class MyFileNotFoundException extends Exception {
        public MyFileNotFoundException(){
            System.err.println("Файла нет");
        }
    }

    //Задача 4
    public static void task4() {
        String[][] array = {{"1","1","1","a"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","2"}};
        try {
            int sum = calculateSum(array);
            System.out.println(sum);
        } catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        } catch (MyArraySizeException e){
            System.out.println(e.getMessage());
        }
    }
    public static int calculateSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if(array.length!=4 || array[0].length != 4){
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                try {
                    sum += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Ошибка преобразования в ячейке ["+i+ "]["+ j+"]");
                }
            }
        }
        return sum;
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException () {
            super("Должен быть подан массив размером 4x4!");
        }
    }
    public static class MyArrayDataException extends Exception {
        public MyArrayDataException (String message) {
            super(message);
        }
    }
}