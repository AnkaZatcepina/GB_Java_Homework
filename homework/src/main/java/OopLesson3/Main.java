package OopLesson3;
/*Создать список по аналогии LinkedList (список связанных элементов), 
реализовать в нем iterable интерфейс. 
Список должен содержать элементы со ссылкой на следующий элемент */

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> strList = new MyLinkedList<>();
        
        System.out.println("Добавление элементов");
        strList.add("а");
        strList.add("б");
        strList.add("в");
        System.out.println(strList.toString());

        System.out.println("Добавление элементов по индексу");
        strList.add(1, "г");
        System.out.println(strList.toString());
        strList.add(0, "д");
        System.out.println(strList.toString());
        strList.add(5, "е");
        System.out.println(strList.toString());

        System.out.println("Замена значения по индексу");
        strList.set(4,"новое");
        System.out.println(strList.toString());

        System.out.println("Удаление элементов по индексу");
        strList.remove(0);
        System.out.println(strList.toString());
        strList.remove(3);
        System.out.println(strList.toString());
        strList.remove(3);
        System.out.println(strList.toString());

        

        System.out.println("Итератор:");
        for (String str: strList) {
            System.out.println(str);
        }
    }       
}