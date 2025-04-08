import java.math.BigInteger;
import java.util.Scanner;

public class expensive_Number_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0)
        {
            String n = sc.next();
            if(n.length()>1)
            System.out.println(n.length()-1);
            else
                System.out.println("1");



        }
    }
}
