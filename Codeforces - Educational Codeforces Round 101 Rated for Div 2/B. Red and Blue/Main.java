//  B. Red and Blue

import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            int max_R = 0;
            int max_B = 0;
            long[] prefix_sum_R = new long[n+1];
            for(int i = 1; i < n + 1; i++) {
                prefix_sum_R[i] = prefix_sum_R[i - 1] + r[i - 1];
                max_R = max((int) prefix_sum_R[i], max_R);
            }
            long[] prefix_sum_B = new long[m+1];
            for(int i = 1; i < m + 1; i++) {
                prefix_sum_B[i] = prefix_sum_B[i - 1] + b[i - 1];
                max_B = max((int) prefix_sum_B[i], max_B);
            }
            if (max_R + max_B < 0)
                pw.println(0);
            else
                pw.println(max_R + max_B);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}