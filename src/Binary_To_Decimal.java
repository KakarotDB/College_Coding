import java.util.Scanner;

public class Binary_To_Decimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive binary number : ");
        String binary = sc.next();
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            int extracted = (int) (binary.charAt(i)-48);
            decimal += (int) (extracted*Math.pow(2,i));
        }
        System.out.println("Decimal equivalent is : " + decimal);

    }
}
