import java.util.Scanner;

public class elepehant_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n =sc.nextLong();
        if(n%5==0)
            System.out.println(n/5);
        else
            System.out.println((n/5+1));
    }
}
