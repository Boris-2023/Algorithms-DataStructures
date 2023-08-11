public class Ex6 {

    public static void main(String[] args) throws Exception {
        // сравнить алгоритмы вычисления числа Фибоначчи по номеру позиции
     
        for (int i = 5; i < 50; i += 5) {
            long t1 = System.currentTimeMillis();
            System.out.println(Ex5.fiboLoop(i));
            long t2 = System.currentTimeMillis();
            System.out.println(Ex4.fiboRecursion(i));
            long t3 = System.currentTimeMillis();

            System.out.println("Loop took: " + i + " -> " + (t2 - t1) + " ms");
            System.out.println("Fibo took: " + i + " -> " + (t3 - t2) + " ms");
        }

    }

}
