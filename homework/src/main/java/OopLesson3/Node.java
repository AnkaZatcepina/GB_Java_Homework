package OopLesson3;

public class Node<E> {
    private E element;
    private Node<E> nextNode = null;

    public Node(E element) {
        this.element = element;
    }
    public E getElement() {
        return this.element;
    }
    public void setElement(E element) {
        this.element = element;
    }
    public Node<E> getNextNode() {
        return this.nextNode;
    }
    public void setNextNode(Node<E> node) {
        this.nextNode = node;
    }

}
