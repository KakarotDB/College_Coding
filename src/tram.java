import java.util.Scanner;

public class tram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] passenger_entry_exit = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                passenger_entry_exit[i][j] = sc.nextInt();
            }
        }

    }
}
