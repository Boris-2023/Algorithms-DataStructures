public class Ex02 {
    public static void main(String[] args) {
        int size = 100;
        int min = 0;
        int max = 100;
        int[] array = Ex01.getRandomArr(size, min, max);
        
        Ex01.printArr(array);
        
        quickSort(array);
        
        Ex01.printArr(array);

    }

    /**
     * @param array - исходный массив
     * @apiNote Перегрузка метода быстрой сортировки
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * @param array         - исходный массив
     * @param startPosition - начало массива
     * @param endPosition   - конец массива
     * @apiNote Метод реализующий быструю сортировку, принимающий на вход три
     *          аргумента
     */
    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int pivot = array[(startPosition + endPosition) / 2];
        int i = startPosition, j = endPosition;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
                j--;
            }
        }
        if (i < endPosition) {
            quickSort(array, i, endPosition);
        }
        if (j > startPosition) {
            quickSort(array, startPosition, j);
        }
    }
}