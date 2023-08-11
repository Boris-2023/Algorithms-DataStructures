import java.util.Scanner;

public class Ex5 {

    public static void main(String[] args) throws Exception {
        // Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
        Scanner iScan = new Scanner(System.in);
        int n = iScan.nextInt();
        iScan.close();

        System.out.println(fiboLoop(n));
    }

    /**
     * @apiNote Algorithm of Fibonacci by recursion
     * @param pos - position to find
     * @return value of the element
     */
    public static int fiboLoop(int pos) {

        int f0 = 1, f1 = 1, f2 = 1;

        for (int i = 2; i < pos; i++) {
            f0 = f1 + f2;
            f2 = f1;
            f1 = f0;
        }

        return f0;
    }
}
