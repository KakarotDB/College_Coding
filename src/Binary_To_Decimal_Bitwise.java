import java.util.Scanner;

public class Binary_To_Decimal_Bitwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number : ");
        int n = sc.nextInt();
        for (int i = 31; i >=0 ; i--) {
            if((n & (1 << i)) != 0)
                System.out.print("1");
            else
                System.out.print("0");


        }
    }
}
