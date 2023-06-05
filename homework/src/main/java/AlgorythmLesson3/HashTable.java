/*
    @1. Начинаем реализацию хэш-таблицы с подготовки структуры и
    необходимых классов.
    @2. Давайте напишем реализацию односвязного списка, в котором мы
    и будем хранить пары ключ-значение. 
    @3. Добавляем массив связных списков с фиксированным размером (массив
    бакетов), либо передаваемым в конструкторе. 
    @4. Реализуем метод вычисления индекса на основании хэш-кода
    ключа.
    @5. Реализуем метод поиска данных по ключу в хэш-таблице.
    @6. Необходимо реализовать методы добавления элементов в связный
список, если там еще нет пары с аналогичным ключом и удаления
элемента с аналогичным ключом из списка.
    @7. Реализуем алгоритм добавления и удаления элементов из хэш-таблицы
по ключу. 
    @8. Добавляем информацию о размере хэш-таблицы, а также алгоритм
увеличения количества бакетов при достижении количества элементов до
определенного размера относительно количества бакетов (load factor). 
*/


package AlgorythmLesson3;


public class HashTable<K,V> {
    

    private static final int INIT_BASKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int size = 0;
    private Basket[] baskets;

    public HashTable(){
        this(INIT_BASKET_COUNT);
    }

    //@3
    public HashTable(int initSize){
        this.baskets = (Basket[]) new Object[initSize];
        //this.baskets = new Basket[initSize];
    }

    //@4
    private int calculateBasketIndex(K key){
        return key.hashCode() % this.baskets.length;
    }

    //@5    
    public V getBasket(K key){

        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        if (basket != null) {
            return basket.getBasket(key); 
        }
        return null;
    }

    //@7
    public boolean put(K key, V value){
        //@8
        if (baskets.length * LOAD_FACTOR < size) {
            recalculate();
        }

        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        if (basket == null) {
            basket = new Basket();
            baskets[index] = basket;
        }

        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        boolean add = basket.put(entity);
        if (add) {
            size++;
        }
        return add;
        
    }

    //@7
    public boolean remove(K key){

        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        if (basket == null) {
            return false;
        }      
        
        boolean remove = basket.remove(key);
        if (remove) {
            size--;
        }
        return remove;
    }

    //@8
    private void recalculate(){
        Basket[] old = baskets[];
        this.baskets = (Basket[]) new Object[old.length * 2];
        for (Basket basket : old) {
            Basket.Node newNode = basket.head;
            while (newNode!=null) {
                put(newNode.value.key, newNode.value.value);
                newNode = newNode.next;
                
            }
            basket = null;
        }
    }

    //@1
    private class Entity{
        private K key;
        private V value;
    }

    private class Basket{
        private Node head;

        //@2
        private class Node{
            private Entity value;
            private Node next;
        }

        //@5
        public V getBasket(K key){
            Node currentNode = head;
            while (currentNode != null) {
                if (currentNode.value.key.equals(key)) {
                    return currentNode.value.value;
                }
                currentNode = currentNode.next;               
            }
            return null;
        }

        //@6
        public boolean put(Entity entity){
            Node newNode = new Node();
            newNode.value = entity;

            Node currentNode = head;
            if (currentNode != null) {
                while (true) {
                    if (currentNode.value.key.equals(entity.key)) {
                        return false;
                    }
                    if (currentNode.next == null) {
                        currentNode.next = newNode;
                        return true;
                    }
                    currentNode = currentNode.next;               
                }         
            } else {
                head = newNode;
                return true;
            }
        }

        //@6
        public boolean remove(K key){
            if (head == null){
                return false;
            }
            if (head.value.key.equals(key)){
                head = head.next;
                return true;
            }


            Node currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.next.value.key.equals(key)) {
                    currentNode.next = currentNode.next.next;
                    return true;
                }
                currentNode = currentNode.next;               
            }

            return false;

        }
    }

}
