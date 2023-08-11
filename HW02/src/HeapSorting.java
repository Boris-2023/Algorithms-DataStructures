import java.util.Date;
import java.util.Random;

public class HeapSorting {
    public static void main(String[] args) throws Exception {

        int size = 50000;
        int min = 0;
        int max = 100;

        int[] arr = getRandomArr(size, min, max);

        // printArr(arr);

        long t1 = new Date().getTime();
        heapSort(arr.clone());
        long t2 = new Date().getTime();

        // printArr(arr);

        long t3 = new Date().getTime();
        bubbleSort(arr.clone());
        long t4 = new Date().getTime();

        // printArr(arr);

        System.out.println("\nHeap sort took:\t\t" + (t2 - t1) + " ms" + "\nBubble sort took:\t" + (t4 - t3) + " ms");

    }

    /**
     * Sorting by the Heap
     * @param arr - array to sort
     */
    public static void heapSort(int[] arr) {

        int length = arr.length;
        if (length == 0)
            return;

        //построение кучи - перегруппировка массива    
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }

        // извлечение элементов из кучи - один за другим
        for (int i = length - 1; i >= 0; i--) {
            //перестановка значений родителя и потомка
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            // вызов метода на уменьшенной куче
            heapify(arr, i, 0);
        }

    }

    /**
     * form a heap of the array (using indexes) & shift bigger values by the heap up (children -> parents)
     * @param array - working array to heapify
     * @param length - length of the working array
     * @param i - index of the parent element
     */
    private static void heapify(int[] array, int length, int i) {
        // индексы потомков
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // установка максимального на родителя
        int largest = i;

        // если левый больше текущего корня
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        // если правый больше текущего корня
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        // если самый большой элемент - не корень
        if (largest != i) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            // рекурсивно преобразуем затронутое дерево в бинарную кучу
            heapify(array, length, largest);
        }
    }


    /**
     * @apiNote bubble sort method
     * @param arr - array to sort
     */
    protected static void bubbleSort(int[] arr) {
        boolean fin;
        do {
            fin = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {

                    arr[i] += arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                    arr[i] -= arr[i + 1];

                    fin = false;
                }
            }
        } while (!fin);
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

    /**
     * creating pseudo-random integer array
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
}
