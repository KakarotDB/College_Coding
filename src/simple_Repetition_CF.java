import java.math.BigInteger;
import java.util.Scanner;

public class simple_Repetition_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            StringBuilder x = new StringBuilder(sc.next());
//            String x = sc.next();
            int k = sc.nextInt();
            StringBuilder ystr = new StringBuilder("");
            for (int i = 0; i < k; i++) {
                ystr.append(x);
            }

//            String x_in = x.repeat(k);
            BigInteger y = new BigInteger(ystr.toString());
//            System.out.println("x_out = " + x_out);
            if(y.isProbablePrime(10))
                System.out.println("YEs");
            else
                System.out.println("NO");

        }

    }
    public static boolean isPrime(Long n) {
        if (n < 2)
            return false;
        if (n < 4)
            return true;
        if ((n & 1) == 0)
            return false;
        for (long i = 3; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
