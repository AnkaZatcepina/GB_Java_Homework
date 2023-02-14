package OopLesson1;

import OopLesson1.Classes.Beer;
import OopLesson1.Classes.CursedProducts;
import OopLesson1.Classes.Milk;
import OopLesson1.Classes.Chokolate;
import OopLesson1.Classes.Product;
import OopLesson1.Classes.WendingMachine;


public class Main {


    public static void main(String[] args) {

        WendingMachine store = new WendingMachine();

        store.addProduct(new Product("Lays" , 123.45))
                .addProduct(new Product("fanta" , 98.76))
                .addProduct(new Product("fan" , 43.21))
                .addProduct(new Product("fan" , 43.21))
                .addProduct(new Beer("alcoholfree" , 67.89))
                .addProduct(new Beer("notbeer" , 67.89, 99))
                .addProduct(new CursedProducts("kefir" , 60.50, 7))
                .addProduct(new Milk("milk" , 56.65, 7, 3.2))
                .addProduct(new Chokolate("alyonka", 56.65, "milk"));

        System.out.println(store);

        System.out.println("searching for ay's");
        System.out.println(store.findProduct("ys"));


        System.out.println("buying Lay's" );
        store.buy("Lays", 123.45);
        System.out.println(store);

        System.out.println("buying fan's" );
        store.buy("fan", 43.21);
        System.out.println(store);
        System.out.println("buying a's" );
        store.buy("fan", 4.1);
        System.out.println(store);
        System.out.println("buying a's" );
        store.buy("milk", 56.65);
        System.out.println(store);




    }


}
