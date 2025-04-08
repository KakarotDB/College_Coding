import java.util.Scanner;

public class CF_2gram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        int count = 0; String ans = null;
        for (int i = 0; i < n-1; i++) {
            int x = 0;
            for (int j = 0; j < n-1; j++) {
                if (input.charAt(i) == input.charAt(j) && input.charAt(i + 1) == input.charAt(j + 1))
                    x++;

                if (count<x)
                {
                    count = x;
                    ans = input.charAt(i)+""+input.charAt(i+1);
                }
            }
        }
        System.out.println(ans);
    }
}
