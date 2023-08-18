import java.lang.reflect.Array;

public class HashTable<K, V> {

    public static final int INT_BASKET_SIZE = 16;
    public static final double LOAD_FACTOR = .75;

    private Basket[] baskets;
    private int size;

    public HashTable() {
        this(INT_BASKET_SIZE);
    }

    public HashTable(int initSize) {
        baskets = (Basket[]) Array.newInstance(Basket.class, initSize);
    }

    //
    private void resize() {
        int newSize = baskets.length * 2;
        Basket[] oldBaskets = baskets;
        baskets = (Basket[]) new Object[newSize];

        for (int i = 0; i < oldBaskets.length; i++) {
            Basket basket = oldBaskets[i];// to work with - convenient
            HashTable.Basket.Node node = basket.head;
            while (node != null) {
                add((K) node.value.key, (V) node.value.value);
            }
        }
    }

    private int calculateBasketIndex(K key) {
        return Math.abs(key.hashCode()) % baskets.length;
    }

    public V find(K key) {
        int index = calculateBasketIndex(key);
        return baskets[index].find(key);// in which basket is the key
    }

    public void add(K key, V value) {
        if (baskets != null) {
            int index = calculateBasketIndex(key);
            Basket basket = baskets[index];
            if (basket == null) {// init if not exists yet
                basket = new Basket();
                baskets[index] = basket;
            }
            basket.add(new Entry(key, value));

            size++;// number of items in the table
            // resizing if necessary
            if ((double) (size / baskets.length) >= LOAD_FACTOR) {
                resize();
            }
        }

    }

    /*
     * Реализуем метод поиска данных по ключу в хэш-таблице.
     * Теперь, когда у нас есть базовая структура нашей хэш-таблицы,
     * можно написать алгоритм поиска элементов, включающий в себя
     * поиск нужного бакета и поиск по бакету.
     */
    public void removeValue(K key) {
        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        basket.remove(key);
    }

    private class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private class Basket {

        private Node head;

        
        private class Node {
            private Node next;
            private Entry value;
        }

        // Реализуем метод поиска данных по ключу в хэш-таблице.
        // Теперь, когда у нас есть базовая структура нашей хэш-таблицы, можно написать
        // алгоритм поиска элементов, включающий в себя поиск нужного бакета и поиск по
        // бакету.
        public V find(K key) {
            Node curNode = head;
            while (curNode != null) {
                if (curNode.value.key.equals(key)) {
                    return curNode.value.value;
                }
                curNode = curNode.next;
            }
            return null;
        }

        // Необходимо реализовать методы добавления элементов в связный список, если там
        // еще нет пары с аналогичным ключом и удаления элемента с аналогичным ключом из
        // списка.
        public void add(Entry entry) {// the same as for LinkedList
            Node node = new Node();
            node.value = entry;

            if (head == null) {
                head = node;
            } else {// move the reference one cell right
                node.next = head;
                head = node;
            }

        }

        /*
         * Реализуем метод поиска данных по ключу в хэш-таблице.
         * Теперь, когда у нас есть базовая структура нашей хэш-таблицы,
         * можно написать алгоритм поиска элементов, включающий в себя
         * поиск нужного бакета и поиск по бакету.
         */
        public void remove(K key) {
            Node node = new Node();

            if (head == null) {
                return;
            } else {
                Node curNode = head;
                if (curNode.value.key.equals(key)) {
                    head = head.next;// it is definitely not null as we entered here
                    return;
                } else {
                    while (curNode.next != null) {
                        if (curNode.value.key.equals(key)) {
                            curNode.next = curNode.next.next;
                        } else {
                            curNode = curNode.next;
                        }
                    }

                }
                node.next = head;
                head = node;
            }
        }

    }
}
