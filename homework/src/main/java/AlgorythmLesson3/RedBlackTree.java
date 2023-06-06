/*
Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. И реализовать в нем метод добавления новых элементов с балансировкой.

Красно-черное дерево имеет следующие критерии:
• Каждая нода имеет цвет (красный или черный)
• Корень дерева всегда черный
• Новая нода всегда красная
• Красные ноды могут быть только левым ребенком
• У красной ноды все дети черного цвета

Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести балансировку, благодаря которой все критерии выше станут валидными. Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.

*/

package AlgorythmLesson3;

public class RedBlackTree {

    private Node root;

    private class Node {
        private int value;
        private Color color;
        private Node left;
        private Node right;

        @Override
        public String toString(){
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    "}";
        }
    }

    public boolean add(int value){
        if (root!= null) {
            boolean result = addNode(root,value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, int value){
        if (node.value == value) {
            return false;
        } 
        if (value < node.value) {
            if (node.left != null) {
                boolean result = addNode(node.left, value);
                node.left = rebalance(node.left);
                return result;
            } else {
                node.left = new Node();
                node.left.color = Color.RED;
                node.left.value = value;
                return true;
            }    
        } else {
            if (node.right != null) {
                boolean result = addNode(node.right, value);
                node.right = rebalance(node.right);
                return result;
            } else {
                node.right = new Node();
                node.right.color = Color.RED;
                node.right.value = value;
                return true;
            }    
        }
    }

    private Node rebalance(Node node){
        Node result = node;
        boolean needBalance;
        do{
            needBalance = false;
            if (result.right!=null && 
                result.right.color == Color.RED && 
                (result.left == null || result.left.color == Color.BLACK)) {
                    needBalance = true;
                    result = rightSwap(result);
            }
            if (result.left!=null && 
                result.left.color == Color.RED && 
                result.left.left != null &&
                result.left.left.color == Color.RED) {
                    needBalance = true;
                    result = leftSwap(result);
            }
            if (result.left != null &&
                result.left.color == Color.RED &&
                result.right != null &&
                result.right.color == Color.RED) {
                    needBalance = true;
                    colorSwap(result);
            }
        } while (needBalance);
        return result;
    }

    private void colorSwap(Node node){
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftSwap(Node node){
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private Node rightSwap(Node node){
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
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

    private enum Color{
        RED, BLACK
    }
}
