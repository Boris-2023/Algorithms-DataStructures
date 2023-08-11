import java.util.Scanner;

public class Ex3 {
      public static void main(String[] args) throws Exception {
        // Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать количество) для 4 кубиков с количеством граней N. 
        //Данное решение имеет сложность O(n4), но если количество кубиков сделать переменной, то она трансформируется в O(nk), что будет представлять собой экспоненциальную сложность.
        
        Scanner iScan = new Scanner(System.in);
        int facet = iScan.nextInt();
        
        System.out.println("sum = " + getCnt(facet));
    }

    /**
     * алгоритм поиска всех доступных комбинаций (посчитать количество) для 4 кубиков с количеством граней N
     * @param facet - количество граней
     * @return - количество комбинаций
     */
    private static int getCnt(int facet) {
        int cnt = 0;
        for (int i = 0; i < facet; i++) {
            for (int j = 0; j < facet; j++) {
                for (int k = 0; k < facet; k++) {
                   for (int x = 0; x < facet; x++) {
                    cnt++;
                   } 
                }
            }
        }
        return cnt;
    }
  
}
