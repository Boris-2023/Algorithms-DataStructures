/**
 * простой односвязный список - только структура
 */

public class TwoLinkedList {

    private Node head;
    private Node tail;

    /**
     * Task #3
     * Реализуем метод поиска элемента в односвязном списке для проверки наличия
     * элемента внутри списка.
     * 
     * @return the node with value, which is equal to target
     */
    public Node contain(int target) {
        while (head != null) {
            if (head.value == target) {
                return head;
            }
            head = head.next;// moves pointer rigthwards
        }
        return null;
    }

    public boolean isContain(int value) {
        return contain(value) != null ? true : false;// true/false is added just for interst
    }

    /**
     * Task #2
     * Реализуем метод добавления новых элементов в начало списка и удаление
     * первого элемента связного списка - добавление в начало
     */
    public void addFirst(int value) {
        Node newNode = new Node(value);// assign value via Node's constructor
        if (head != null) {
            newNode.next = head;// head is always the most left!
            head.prev = newNode; // DIFFERENCE from one-ref Linked list
        } else {
            tail = newNode;// DIFF from 1-ref list
        }
        head = newNode;// new head is assigned

    }

    /**
     * Task #2
     * Реализуем метод удаления элемента из начала списка
     * первого элемента связного списка - добавление в начало
     */
    public boolean removeFirst() {
        // TODO look if the condition is necessary
        if (head != null && head.prev != null) {
            head.next.prev = null; // DIFF from 1-ref list
            head = head.next;// head is always the most left => deletion == moving head right
            return true; // voluntary - w/o boolean return - usual
        } else {
            head = null;// DIFF from 1-ref list
            tail = null;// DIFF from 1-ref list
            return false; // voluntary - w/o boolean return - usual
        }
    }

    /**
     * Task #4
     * Реализуем метод добавления новых элементов в конец списка и удаление
     * последнего элемента связного списка.
     * 
     * @param value - value to add to the end of list
     */
    public void addLast(int value) {
        Node newNode = new Node(value);// assign value via Node's constructor
        if (tail == null) {// empty list - DIFF from 1-ref List
            tail = newNode; // DIFF from 1-ref List
        } else { // list is not empty
            Node curNode = tail;// to keep tail - DIFF from 1-ref List
            tail.next = newNode;// add new node at the end
            newNode.prev = curNode;
        }
        tail = newNode;
    }

    /**
     * Task #4
     * Реализуем метод удаления элемента из конца списка и удаление
     * последнего элемента связного списка.
     * 
     * @param value - value to add to the end of list
     */
    public boolean removeLast() {
        // TODO look if the condition is necessary
        if (tail != null && tail.prev != null) {
            tail.prev.next = null; // DIFF from 1-ref list
            tail = tail.prev;// head is always the most left => deletion == moving head right
            return true; // voluntary - w/o boolean return - usual
        } else {
            head = null;// DIFF from 1-ref list
            tail = null;// DIFF from 1-ref list
            return false; // voluntary - w/o boolean return - usual
        }

    }

    /**
     * private class Node
     */
    private class Node {

        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

    }

    // DRAW the references as circles for better understanding
    public void sort() {
        boolean flag = true;
        do {
            flag = false;
            Node node = head;
            while (node != null && node.next != null) {
                if (node.value > node.next.value) {
                    // needs to change references
                    Node before = node.prev;
                    Node after = node.next.next;
                    Node current = node;
                    Node next = node.next;

                    // current node change references
                    current.next = after;
                    current.prev = next;

                    // next node change references
                    next.next = current;
                    next.prev = before;

                    //left side of the list
                    if (before != null) {
                        before.next = next;
                    } else {
                        head = next;
                    }

                    // right sid of the list
                    if (after != null) {
                        after.prev = current;
                    } else {
                        tail = current;
                    }

                    flag = true;
                }
                //goes through all nodes o-b-o
                node = node.next;
            }
        } while (flag);
    }

    @Override
    /**
     * forming the list as a string
     */
    public String toString() {
        StringBuilder str = new StringBuilder();// better concatination than for String
        Node current = head;

        if (head != null) {
            while (current.next != null) {
                str.append(current.value + ", ");
                current = current.next;
            }
            str.append(current.value);// the last value (which .next is null)

        } else {// empty list
            str.append("null");
        }

        return "Linked list: {" + str + "}";
    }

}
