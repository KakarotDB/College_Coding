import java.util.Scanner;

public class candies_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int k = 4;
            while (n%(k-1)!=0)
                k*=2;
            System.out.println(n/(k-1));
        }
    }
}
