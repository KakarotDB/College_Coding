//  Maximum Subarray Sum

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        long maxSubSum = a[0];
        long runningPrefSum = 0;
        long minPrefSum = 0;
        for (long l : a) {
            runningPrefSum += l;
            maxSubSum = max(maxSubSum, runningPrefSum - minPrefSum);
            minPrefSum = min(minPrefSum, runningPrefSum);
        }
        pw.println(maxSubSum);
        long[] prefix_sum = new long[n+1];
        for(int i = 1; i < n + 1; i++)
            prefix_sum[i] = prefix_sum[i-1] + a[i-1];
        pw.println(Arrays.toString(prefix_sum));


        pw.flush();
        pw.close();
        br.close();

    }

}