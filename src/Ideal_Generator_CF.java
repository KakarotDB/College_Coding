import java.util.Scanner;

public class Ideal_Generator_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int k = sc.nextInt();
            if (k%2==0)
                System.out.println("no");
            else
                System.out.println("Yes");
        }
    }
}
