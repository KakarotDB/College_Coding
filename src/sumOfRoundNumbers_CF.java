import java.util.Scanner;

public class sumOfRoundNumbers_CF{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int k = 0;
            String input = sc.next();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i)!='0')
                    k++;

            }
            System.out.println(k);
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i)!='0')
                {
                    System.out.print(input.charAt(i)+"0".repeat(input.length()-i-1)+ " ");
                }

            }
            System.out.println("");
        }

    }
}
