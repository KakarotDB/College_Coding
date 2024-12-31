import java.util.Arrays;
import java.util.Scanner;

public class EvenOdds_CF {
    public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            long n = sc.nextLong();
            long k = sc.nextLong();
            long oddc = (n + 1) / 2;
            long evenc = n / 2;
            if (k <= oddc) {
                System.out.println(2 * k - 1);
            }
            else {
                k = k - oddc;
                System.out.println(2 * k);
            }
    }
}
