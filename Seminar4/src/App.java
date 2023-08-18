public class App {
    public static void main(String[] args) throws Exception {
        HashTable hashTable = new HashTable<>();

        hashTable.add(1, 5);
        System.out.println(hashTable.find(1));
        hashTable.add(2, 23);
        hashTable.add(3, 17);
        hashTable.add(4, 3);
        hashTable.add(5, 4);
        System.out.println(hashTable.find(3));
    }
}

    
