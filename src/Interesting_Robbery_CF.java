import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Interesting_Robbery_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int wealth[] = new int[n];
            int power_factor = 0;
            for (int i = 0; i < n; i++) {
                wealth[i]=sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                power_factor+=wealth[i];
            }
            if (power_factor==m)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
