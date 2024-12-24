import java.util.Scanner;

public class Hulk_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i < n; i++) {
            System.out.print((i%2==1)?"I hate that ":" I love that ");

        }
        System.out.print((n%2==1)?"I hate it ": "I love it ");

    }
}
