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
            StringBuilder Ystr = new StringBuilder();
            String ystr = Ystr.toString().repeat(k);

//            String x_in = x.repeat(k);
            BigInteger y = new BigInteger(ystr);
//            System.out.println("x_out = " + x_out);
            if(y.isProbablePrime(10))
                System.out.println("YEs");
            else
                System.out.println("NO");

        }

    }
}
