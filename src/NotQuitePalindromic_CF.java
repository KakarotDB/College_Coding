import java.util.Scanner;

public class NotQuitePalindromic_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String input = sc.next();
            int count0 = 0, count1 = 0;
            for (int i = 0; i < n; i++) {
                if (input.charAt(i)=='0')
                    count0++;
                else count1++;
            }
            int k_max = count0/2 + count1/2;
            int k_min = k_max- (n/2);

        }
    }
}
