import java.util.Scanner;

public class escapeTheLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            int[] a = new int[n + 1];
            int[] b = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                b[i] = sc.nextInt();
            }

            boolean escaped = false;
            int currentEra = x;
            for (int i = 1; i <= k; i++) {
                int movedSteps =0;
                int steps = k - i + 1;
                int tempEra = currentEra;
                while (movedSteps < steps && tempEra != -1) {
                    tempEra = a[tempEra];
                    movedSteps++;
                }
                if (tempEra == -1) {
                    escaped = true;
                    break;
                }
                // Teleport to b[tempEra]
                currentEra = b[tempEra];
            }
            System.out.println(escaped ? "YES" : "NO");

        }
    }
}
