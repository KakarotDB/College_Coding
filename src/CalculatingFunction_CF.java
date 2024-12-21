import java.util.Scanner;

public class CalculatingFunction_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n =sc.nextLong();
        System.out.println(n%2==0?n/2:-(n/2+1));
    }
}
