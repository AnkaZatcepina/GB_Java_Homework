/*
    1. Реализуем структуру бинарного дерева. 
    2. Реализуем алгоритм поиска элементов по дереву (поиск в глубину). 
*/
package AlgorythmLesson3;

public class BinaryTree <V extends Comparable<V>>{

    private Node root;

    private class Node {
        private int value;
        private Node left;
        private Node right;
    }

    private boolean isExistDown(Node node, int value){
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        } 
        if (value < node.value) {
            return isExistDown(node.left, value);
        } else {
            return isExistDown(node.right, value);
        }

    }

    public boolean isExist(int value){
        if (root == null) {
            return false;
        }
        return isExistDown(root, value);
    }
}
