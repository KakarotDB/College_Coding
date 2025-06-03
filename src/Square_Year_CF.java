import java.util.Scanner;

public class Square_Year_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            String input = sc.next();
            int inputt = Integer.parseInt(input);
            if (inputt ==0)
                System.out.println("0 0");
            else if (isPerfectSquare(inputt))
            {
                System.out.println((int)Math.sqrt(inputt)-1 + " 1");
            }
            else
                System.out.println("-1");
        }
    }
    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int sqrt = (int) Math.floor(Math.sqrt(num));
        return sqrt * sqrt == num;
    }
}
