package AlgorythmLesson2;
/*  Задание
    1. Реализовать простой односвязный список.  
    2. Реализовать метод добавления новых элементов в начало списка и удаление
первого элемента связного списка.
    3. Реализовать метод поиска элемента в односвязном списке для проверки наличия
элемента внутри списка. 
    4. Реализовать метод добавления новых элементов в конец списка и удаление
последнего элемента связного списка. 
    5. Реализовать метод разворота связного списка
*/

public class MyLinkedList {

    private Node head;

    private class Node{
        private int value;
        private Node next;
    }

    public void addHead(int value){
        Node newNode = new Node();
        newNode.value = value;
        if (head != null){
            newNode.next = head;
        }
        head = newNode;  
    }

    public void deleteHead(){
        if (head != null){
            head = head.next;
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
        if (head == null){
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null ) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void deleteTail(){
        if (head != null){
            Node currentNode = head;
            while (currentNode.next != null ) {
                if (currentNode.next.next == null){
                    currentNode.next = null;
                    return;
                }
                currentNode = currentNode.next;
            }   
            head = null;    
        }
    }

    public void reverseList(){
        if (head != null && head.next != null){
            reverseTwoNodes(head.next, head);
        }
    }

    private void reverseTwoNodes(Node currentNode, Node previousNode){
        if (currentNode.next == null){
            head = currentNode;
        } else {
            reverseTwoNodes(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
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