import java.util.Scanner;

public class IlyaandBankaccount_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n>0)
        {
            System.out.println(n);

        }
        else {
            int one = n / 10;
            int two = n / 100 * 10 + n % 10;
            if (one > two)
                System.out.println(one);
            else
                System.out.println(two);
        }
        
        
    }
}
