import java.util.ArrayList;
import java.util.List;

public class Subsets02 {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // input array
        int check_sum = 50;

        List<int[]> result = new ArrayList<>();

        for (int sz = 1; sz <= arr.length; sz++) {

            List<int[]> subsets = getCombinations(arr, sz);

            for (int[] item : subsets) {
                if (checkSum(item, check_sum))
                    result.add(item);
            }

        }

        for (int[] item : result) {
            for (int i = 0; i < item.length; i++) {
                System.out.print(item[i] + " ");
            }
            System.out.println();
        }

    }

    private static List<int[]> getCombinations(int[] arr, int size) {

        List<int[]> subsets = new ArrayList<>();

        int[] indices = new int[size]; // here we'll keep indices pointing to elements in input array

        if (size <= arr.length) {
            // first index sequence: 0, 1, 2, ...
            //for (int i = 0; (indices[i] = i) < size - 1; i++); 
            for (int i = 0; i < size; i++)
                indices[i] = i;

            subsets.add(getSubset(arr, indices));

            while (true) {
                int i;
                // find position of item that can be incremented
                for (i = size - 1; i >= 0 && indices[i] == arr.length - size + i; i--)
                    ;

                if (i < 0)
                    break;

                indices[i]++; // increment this item
                for (++i; i < size; i++) { // fill up remaining items
                    indices[i] = indices[i - 1] + 1;
                }

                subsets.add(getSubset(arr, indices));

            }
        }
        return subsets;
    }

    // generate actual subset by index sequence
    public static int[] getSubset(int[] input, int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++)
            result[i] = input[subset[i]];
        return result;
    }

    /**
     * проверяем сумму элементов массива на соответствие требуемой
     * 
     * @param list   - the combination (subset) to check
     * @param chkSum - target sum value
     * @return true if matches or false - if not
     */
    private static boolean checkSum(int[] arr, int chkSum) {
        boolean res = false;
        int summ = 0;
        for (int i = 0; i < arr.length; i++) {
            summ += arr[i];
        }
        if (summ == chkSum)
            res = true;

        return res;
    }
}
