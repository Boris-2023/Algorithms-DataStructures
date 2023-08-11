import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) throws Exception {
        // Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
        Scanner iScan = new Scanner(System.in);
        int n = iScan.nextInt();
        int sum = getSum(n);
        System.out.println("sum = " + sum);
    }

    /**
     * @apiNote алгоритм, считающий сумму всех чисел от 1 до N.
     * @param n - limit to calculate sum from 1
     * @return sum of elements 1 -> n
     */
    private static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
