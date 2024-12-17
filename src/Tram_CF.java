import java.util.Scanner;

public class Tram_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tram =  new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                tram[i][j] = sc.nextInt();
            }
        }
        int min = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            counter=counter-tram[i][0]+tram[i][1];
            min = Math.max(counter,min);

        }
        System.out.println(min);
    }
}
