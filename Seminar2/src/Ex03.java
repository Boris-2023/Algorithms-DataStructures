import java.util.Arrays;
import java.util.Date;

public class Ex03 {

    public static void main(String[] args) {

        int size = 100000;
        int min = 0;
        int max = 100;
        int[] array = Ex01.getRandomArr(size, min, max);

        long t1 = new Date().getTime();

        Ex01.bubbleSort(array.clone());

        long  t2 = new Date().getTime();

        Ex02.quickSort(array.clone());

        long  t3 = new Date().getTime();

        Arrays.sort(array);

        long  t4 = new Date().getTime();

        System.out.println((t2-t1) + "\n");
        System.out.println((t3-t2) + "\n");
        System.out.println((t4-t3) + "\n");
    }

}
