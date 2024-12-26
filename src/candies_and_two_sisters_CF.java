import java.util.Scanner;

public class candies_and_two_sisters_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            long n = sc.nextLong();
            System.out.println(n-(n/2+1));

        }

    }
}
