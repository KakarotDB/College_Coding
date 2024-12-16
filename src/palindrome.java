import java.util.Scanner;
public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        int palindrome=0;
        int temporary= number;
        while (number>0)
        {
            int digit = number%10;
            palindrome=palindrome*10+digit;
            number/=10;
        }

        if(palindrome == temporary)
            System.out.println("True");
        else
            System.out.println("false");
    }
}