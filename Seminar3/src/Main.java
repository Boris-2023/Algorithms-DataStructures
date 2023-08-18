public class Main {
    public static void main(String[] args) {
        //one-ref list
        LinkedList list = new LinkedList();
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(7);
        list.addFirst(25);
        System.out.println(list);

        list.addLast(5);
        list.addLast(5);
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        //two-ref list
        System.out.println("");
        TwoLinkedList list2 = new TwoLinkedList();
        list2.addFirst(3);
        list2.addFirst(5);
        list2.addLast(7);
        list2.addLast(22);
        list2.addFirst(25);
        System.out.println(list2);

        list2.sort();
        System.out.println(list2);
    }
}
