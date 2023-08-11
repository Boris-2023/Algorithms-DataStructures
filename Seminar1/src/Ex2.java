import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) throws Exception {
        Scanner iScan = new Scanner(System.in);
        int n = iScan.nextInt();

        List<Integer> result = new ArrayList<Integer>();
        findPrimeNumbers(n, result);
        System.out.println("result = " + result);
    }

    /**
     * Написать алгоритм поиска простых чисел (делятся только на себя и на 1) в диапазоне от 1 до N. В алгоритме будет использоваться вложенный for, что явно говорит о квадратичной сложности
     *
     * @param n      - пользовательский ввод значения с клавиатуры
     * @param result - вывод результата
     */

    private static void findPrimeNumbers(int n, List<Integer> result) {
        for (int i = 1; i <= n; i++) {
           if (isPrime(i)) {
                result.add(i);
            }

        }
    }

    private static boolean isPrime(int i) {
        boolean find = true;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                find = false;
                break;
            }
        }
        return find;
    }

}
