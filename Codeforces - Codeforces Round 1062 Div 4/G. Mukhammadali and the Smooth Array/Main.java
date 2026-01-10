//  G. Mukhammadali and the Smooth Array

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
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long[] c = new long[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                c[i] = Long.parseLong(st.nextToken());
            }

            long[] dp = new long[n + 1];

            if (isSorted(a)) {
                pw.println(0);
                continue;
            }

            for (int i = 1; i <= n; i++) {
                dp[i] = c[i];
                for (int j = 1; j < i; j++) {
                    if (a[i] >= a[j]) {
                        dp[i] = max(dp[i], dp[j] + c[i]);
                    }
                }
            }
            //dp[n] represents the max cost till the last element

            pw.println(Arrays.stream(c).sum() - Arrays.stream(dp).max().getAsLong());

        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static boolean isSorted(long[] array) {
        if(array.length == 1)
            return true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}