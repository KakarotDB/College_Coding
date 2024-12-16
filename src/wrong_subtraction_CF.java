import java.util.Scanner;

public class wrong_subtraction_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        while (k>0)
        {
            if ((n%10)!=0)
            {
                n--;
                k--;
            }
            else {
                n/=10;
                k--;
            }
        }
        System.out.println(n);

    }
}
