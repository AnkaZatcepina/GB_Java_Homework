package OopLesson3;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    int size = 0;
    Node<E> firstNode = null;
    //Node<E> currentNode = null;
    //Node<E> previousNode = null;

    public void add(int index, E element) throws IndexOutOfBoundsException{
        Node<E> currentNode = null;
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Некорректный индекс"); 
        }
        if(size == 0)
        {
            firstNode = new Node<E>(element);
        } else if (index == size) {
            Node<E> newNode = new Node<E>(element);
            currentNode = getByIndex(index-1);
            currentNode.setNextNode(newNode);
        } else if (index == 0){
            currentNode = getByIndex(index);
            firstNode = new Node<E>(element);
            firstNode.setNextNode(currentNode);
        } else {
            Node<E> newNode = new Node<E>(element);
            currentNode = getByIndex(index-1);
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }
        size++;
    }

    public void add(E element){
        add(size, element);
    }

    public void remove(int index) throws IndexOutOfBoundsException{
        Node<E> currentNode = null;
        Node<E> previousNode = null;
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Некорректный индекс"); 
        }
        currentNode = getByIndex(index);
        if (index == 0){
            firstNode = currentNode.getNextNode();
        } else if (index == (size-1)){
            previousNode = getByIndex(index-1);
            previousNode.setNextNode(null);
        } else {
            previousNode = getByIndex(index-1);
            previousNode.setNextNode(currentNode.getNextNode());
        }
        size--;
        
    }

    public void set(int index, E element) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Некорректный индекс"); 
        }
        getByIndex(index).setElement(element);;
        
    }

    public int size(){
        return this.size;
    }

    public Node<E> getFirst(){
        return firstNode;
    }


    public Node<E> getNext(Node<E> node){
        return node.getNextNode();
    }

    public Node<E> getByIndex(int index) throws IndexOutOfBoundsException{
        Node<E> currentNode = null;
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Некорректный индекс"); 
        }
        if(index == 0)
            return firstNode;     
        currentNode = firstNode;     
        for (int i = 1; i <= index; i++){
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public void printNode(Node<E> node){
        System.out.println(node.getElement().toString());
    }

    @Override
    public String toString(){
        Node<E> currentNode = null;
        currentNode = firstNode;
        String str = "{" + currentNode.getElement().toString();
        currentNode = currentNode.getNextNode();
        for (int i = 1; i < size; i++)
        {
            str += ", " + currentNode.getElement().toString();
            currentNode = currentNode.getNextNode();
        }
        str += "}";
        return str;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return getByIndex(index++).getElement();
            }
        };
    }

}
