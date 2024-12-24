import java.util.Scanner;

public class Drinks_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float total_percentage = 0;
        int temp = n;
        while (n-->0)
        {
            float percentage = sc.nextFloat();
            total_percentage+=(percentage/100);
        }
        System.out.println((total_percentage/temp)*100);

    }
}
