public class Ex04 {
    public static void main(String[] args) {
        int size = 100;
        int min = 0;
        int max = 100;
        int[] array = Ex01.getRandomArr(size, min, max);

        Ex01.printArr(array);

        Ex02.quickSort(array);

        Ex01.printArr(array);

        System.out.println(binSearch(array, 5, 0, array.length));

    }

    /**
     * @apiNote search for value in the sorted array by binary search
     * @param arr - array to look through
     * @param value - value to find
     * @param min - min index
     * @param max - max index
     * @return index of 1st element equal to requested value
     */
    public static int binSearch(int[] arr, int value, int min, int max) {
        int middle;
        if (max < min) {
            return -1;
        } else {
            middle = (max - min) / 2 + min;
        }
        if (arr[middle] < value) {
            return binSearch(arr, value, middle + 1, max);
        } else {
            if (arr[middle] > value) {
                return binSearch(arr, value, min, middle - 1);
            } else {
                return middle;
            }
        }
    }
}
