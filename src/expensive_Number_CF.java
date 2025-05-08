import java.math.BigInteger;
import java.util.Scanner;

public class expensive_Number_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0)
        {
            String n = sc.next();
            int count_zero = 0;
            int mx = 0;
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i)!= '0')
                   mx = Math.max(mx, count_zero+1);
                else
                    count_zero++;
            }
            System.out.println(n.length()-mx);



        }
    }
}
