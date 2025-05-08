import java.util.Scanner;

public class Optimized_Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter n : ");
        n = sc.nextInt();
        if (n == 2) {
            System.out.println("Prime number ");
            System.exit(0);
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n%i == 0) {
                    System.out.println("Not a prime number");
                    System.exit(0);
                }
        }
        System.out.println("Prime number");
    }
}
