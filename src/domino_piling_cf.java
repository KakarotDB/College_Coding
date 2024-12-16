import java.util.Scanner;

public class domino_piling_cf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[\\s,]+");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int product = m*n;
        int answer = product/2;
        System.out.println(answer);
    }
}
