//  B. 250 Thousand Tons of TNT

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long[] prefix_sum = new long[n];
            prefix_sum[0] = a[0];
            for (int i = 1; i < n; i++)
                prefix_sum[i] = prefix_sum[i - 1] + a[i];
            long ans = 0;
            for (int k = 1; k <= n; k++) {
                if (n % k != 0) continue;
                long start = k - 1;
                long result = 0;
                long max = prefix_sum[(int) start];
                long min = prefix_sum[(int) start];
                for (int i = (int) start + k; i < n; i+=k) {
                    long current = prefix_sum[i] - prefix_sum[i - k];
                    max = max(current, max);
                    min = min(current, min);
                }
                ans = max(ans, max - min);
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}