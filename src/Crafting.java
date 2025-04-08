import java.util.Arrays;
import java.util.Scanner;
public class Crafting
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Number of materials
            int n = sc.nextInt();

            // Arrays for current (a) and required (b) resources
            long[] a = new long[n];
            long[] b = new long[n];

            long sumA = 0, sumB = 0;

            // Read current resources (a)
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                sumA += a[i];
            }

            // Read required resources (b)
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
                sumB += b[i];
            }

            // Overall feasibility check
            if (sumA < sumB) {
                System.out.println("NO");
                continue; // Skip this test case
            }

            // Redistribution feasibility
            boolean possible = true;
            long extra = 0; // Excess resources from `a[i]` that can be redistributed
            for (int i = 0; i < n; i++) {
                if (a[i] >= b[i]) {
                    // Surplus from this material can be redistributed
                    extra += a[i] - b[i];
                }
                else {
                    // Deficit for this material; check if `extra` can cover it
                    long deficit = b[i] - a[i];
                    if (deficit > extra) {
                        possible = false;
                        break;
                    }
                    else
                    {
                        extra -= deficit; // Use extra resources to cover the deficit
                    }
                }
            }

            // Output result
            System.out.println(possible ? "YES" : "NO");
        }

    }
}
