import java.util.Scanner;

public class Binomial_CoEfficient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of 'n' and 'r': ");
        int n = sc.nextInt();
        int r = sc.nextInt();
        double coefficient = (factorial(n))/(factorial(r)*factorial(n-r));
        System.out.println("Binomial co efficient is : " + coefficient);


    }

    public static int factorial(int n)
    {
        if(n == 0)
            return 1;
        if (n == 1)
            return 1;
        return n*factorial(n-1);
    }
}
