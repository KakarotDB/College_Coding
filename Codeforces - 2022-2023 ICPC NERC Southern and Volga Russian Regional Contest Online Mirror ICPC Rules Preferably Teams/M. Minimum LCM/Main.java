//  M. Minimum LCM

import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long min_lcm = Long.MAX_VALUE;
            long n = Long.parseLong(br.readLine());
            long ans1 = 1; long ans2 = n - 1;
            for (int i = 2; ((long) i * i) <= n; i++) {
                if (n % i == 0) {
                    ans1 = n / i;
                    ans2 = n - ans1;
                    break;
                }
            }
//            pw.println("LCM of 2 and 3 is : " + lcm(2,3));
            pw.println(ans1 + " " + ans2);

        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static long gcd(long a, long b) {
        if (a == 0 && b == 0)
            return 0;
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a < 0)
            a = -a;
        if (b < 0)
            b = -b;

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}