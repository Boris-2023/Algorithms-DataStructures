/**
 * простой односвязный список - только структура
 */

public class LinkedList {

    public Node head;

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
        if (head != null) {
            head = head.next;// head is always the most left => deletion == moving head right
            return true; // voluntary - w/o boolean return - usual
        } else {
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
        if (head == null) {// empty list
            head = newNode;
        } else { // list is not empty
            Node curNode = head;// to keep head
            while (curNode.next != null) {// we do not need to stay at null, but 1 node before
                curNode = curNode.next;
            }
            curNode.next = newNode;// add new node at the end
        }
    }

    /**
     * Task #4
     * Реализуем метод удаления элемента из конца списка и удаление
     * последнего элемента связного списка.
     * 
     * @param value - value to add to the end of list
     */
    public void removeLast() {
        if (head != null) {
            Node curNode = head;// to keep head
            while (curNode.next.next != null) {// we look two nodes ahead!
                curNode = curNode.next;
            }
            curNode.next = null;// delete the last
        } else { // if the list has only 1 element
            if (head.next == null) {
                head = null;
            }
        }

    }

    /**
     * private class Node
     */
    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

    }

    @Override
    /**
     * forming the list as a string
     */
    public String toString() {
        StringBuilder str = new StringBuilder();//better concatination than for String
        Node current = head;

        if (head != null) {
            while (current.next != null) {
                str.append(current.value + ", ");
                current = current.next;
            }
            str.append(current.value);//the last value (which .next is null)

        } else {//empty list
            str.append("null");
        }

        return "Linked list: {" + str + "}";
    }

}
