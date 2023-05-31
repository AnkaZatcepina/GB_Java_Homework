package AlgorythmLesson2;


public class Main {
    public static void main(String[] args) {

        MyLinkedList list1 = new MyLinkedList();
        list1.addTail(1);
        list1.addTail(2);
        list1.addTail(3);
        list1.addTail(4);
        System.out.println(list1);
        list1.reverseList();
        System.out.println(list1);

        MyDoublyLinkedList list2 = new MyDoublyLinkedList();
        list2.addTail(5);
        list2.addTail(6);
        list2.addTail(7);
        list2.addTail(8);
        System.out.println(list2);
        list2.reverseList();
        System.out.println(list2);
        
    }   
}