package lesson6;
/*
 1. Подумать над структурой класса Ноутбук для магазина техники 
    - выделить поля и методы. Реализовать в java.
 2. Создать множество ноутбуков (ArrayList).
 3. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. 
    Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет. 
    Выводить только те ноутбуки, что соответствуют условию
*/

import lesson6.Laptop;

import java.util.List;
import java.util.ArrayList;

public class Main {
    private static List<Laptop> laptopList = new ArrayList<Laptop>();
        
    public static void main( String[] args )
    {
        fillLaptopList();

        //Show all Laptops
        System.out.print("All laptops:");
        for (Laptop item: laptopList){
            System.out.println(item.getInfo());
        }
        System.out.println();

        //Show black Laptops
        System.out.print("Black laptops:");
        for (Laptop item: laptopList){
            if (item.getColor() == "black")
                System.out.println(item.getInfo());
        }
        System.out.println();

        //Show Laptops cheaper than 50000
        System.out.print("Price < 50000:");
        for (Laptop item: laptopList){
            if (item.getPrice() < 50000.0)
                System.out.println(item.getInfo());
        }
        System.out.println();

        //Sell laptops
        for (Laptop item: laptopList){
            if (item.getId() == 1 | item.getId() == 3 )
                item.sellLaptop();
        }
        //Show Laptops In Stock
        System.out.print("Laptops In Stock:");
        for (Laptop item: laptopList){
            if (item.getInStock() == true)
                System.out.println(item.getInfo());
        }
        System.out.println();


    }

    public static void fillLaptopList(){

        Laptop laptop = new Laptop( 1, 
                                    "Apple", 
                                    "MacBook Air", 
                                    13.3, 
                                    "gold", 
                                    1.29, 
                                    "Apple M1", 
                                    1.8, 
                                    8, 
                                    8, 
                                    256,
                                    80999.00);
        laptopList.add(laptop);
        laptop = new Laptop(        2, 
                                    "ASUS", 
                                    "11 E210MA-GJ204T", 
                                    11.6, 
                                    "black", 
                                    2.0, 
                                    "Intel Celeron N4020", 
                                    1.1, 
                                    2, 
                                    8, 
                                    256,
                                    22999);
        laptopList.add(laptop);
        laptop = new Laptop(        3, 
                                    "HP", 
                                    "G8");
        laptop.setColor("black");
        laptop.setPrice(23000.00);
        laptop = new Laptop(        4, 
                                    "HP", 
                                    "G8");
        laptop.setColor("white");
        laptop.setPrice(25000.00);
        laptopList.add(laptop);      
    }
}
