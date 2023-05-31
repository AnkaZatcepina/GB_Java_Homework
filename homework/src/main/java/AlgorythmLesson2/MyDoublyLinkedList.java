package AlgorythmLesson2;
/*  Задание
    1. Реализовать двухсвязный список. 
    2. Добавить метод сортировки для связного списка. 
    3. Реализовать метод разворота связного списка
*/

public class MyDoublyLinkedList {

    private Node head;
    private Node tail;

    private class Node{
        private int value;
        private Node next;
        private Node previous;
    }

    public void addHead(int value){
        Node newNode = new Node();
        newNode.value = value;
        if (head != null){
            newNode.next = head;
            head.previous = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    public void deleteHead(){
        if (head != null && head.next != null ){
            head = head.next;
            head.previous = null;
        }  else {
            head = null;
            tail = null;
        }
    }
    
    public boolean existValue(int value){
        Node currentNode = head;
        while (currentNode.next != null ) {
            if (currentNode.value == value){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }


    public void addTail(int value){
        Node newNode = new Node();
        newNode.value = value;
        if (tail != null){
            newNode.previous = tail;
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
    }

    public void deleteTail(){
        if (tail != null && tail.previous != null ){
            tail = tail.previous;
            tail.next = null;
        }  else {
            tail = null;
            head = null;
        }
    }

    public void bubbleSort(){
        Node currentNode = head;
        int temp = 0;
        boolean needSort = true;
        while needSort {
            needSort = false;
            while (currentNode != null && currentNode.next != null) {
                if (currentNode.value > currentNode.next.value){
                    temp = currentNode.value;
                    currentNode.value = currentNode.next.value;
                    currentNode.next.value = temp;

                    needSort = true;
                }
            }
            currentNode = currentNode.next;
        }
    }

    public void reverseList(){
        Node currentNode = head;
        Node temp = head;
        head = tail;
        tail = temp;
        if (currentNode != null && currentNode.next != null){
            while (currentNode != null) {
                temp = currentNode.next;
                currentNode.next = currentNode.previous;
                currentNode.previous = temp;
                currentNode = currentNode.previous;
            };
        }
    }

    @Override
    public String toString(){
        Node currentNode = head;
        String str = "{" +  currentNode.value;
        while (currentNode.next != null ) {
            str += ", " + currentNode.next.value;
            currentNode = currentNode.next;
        }
        str += "}";
        return str;
    }
}