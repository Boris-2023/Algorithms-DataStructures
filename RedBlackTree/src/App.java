import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        int size = 50;
        int min = 1;
        int max = 100;
        int[] arr = getRandomArr(size, min, max);
        printArr(arr);

        RedBlackTree tree = new RedBlackTree();

        System.out.println();
        for (int i = 0; i < 50; i++) {
            if (tree.add(arr[i])) {
                System.out.println(arr[i] + " added to the tree");
                if (i >= 7)
                    System.out.println(tree);
            } else {
                System.out.println(arr[i] + " NOT added (already in the tree)");
            }

        }

    }

    /**
     * create pseudo-random int array
     * 
     * @param size - size of the array to form
     * @param min  - min value of array
     * @param max  - max value of array
     * @return - array created
     */
    protected static int[] getRandomArr(int size, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1) + min;
        }
        return arr;
    }

    /**
     * @apiNote print array into console
     * @param arr - array to print
     */
    protected static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
