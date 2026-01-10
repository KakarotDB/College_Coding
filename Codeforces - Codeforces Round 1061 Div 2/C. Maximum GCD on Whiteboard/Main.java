//  C. Maximum GCD on Whiteboard

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] map = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                map[a[i]]++;
            }
            long[] prefix_sum = new long[n + 1];
            for(int i = 1; i < n + 1; i++)
                prefix_sum[i] = prefix_sum[i-1] + map[i];

            int ans = 1;
            for (int g = 1; g <= n; g++) {
                int min = min(n, 4 * g - 1);
                long good_count = n - prefix_sum[min];
                good_count += map[g];
                if (2 * g <= n) good_count += map[2 * g];
                if(3 * g <= n) good_count += map[3 * g];
                if (good_count >= n - k) ans = g;
            }
            pw.println(ans);

        }
        pw.flush();
        pw.close();
        br.close();
    }
}