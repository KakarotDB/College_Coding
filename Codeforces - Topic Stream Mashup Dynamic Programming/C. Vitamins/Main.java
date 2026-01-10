//  C. Vitamins

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[8];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            long cost = Long.parseLong(st.nextToken());
            String s = st.nextToken();

            int juice_mask = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'A')
                    juice_mask += 1 << 2;
                else if (s.charAt(j) == 'B') {
                    juice_mask += 1 << 1;
                }
                else
                    juice_mask += 1;
            }

            for (int prev_mask = 0; prev_mask < 8; prev_mask++) {
                if (dp[prev_mask] != Long.MAX_VALUE) {
                    int new_mask = prev_mask | juice_mask;
                    dp[new_mask] = min(dp[new_mask], dp[prev_mask] + cost);
                }
            }
        }
        pw.println(dp[7] != Long.MAX_VALUE ? dp[7] : -1);
        pw.flush();
        pw.close();
        br.close();
    }
}