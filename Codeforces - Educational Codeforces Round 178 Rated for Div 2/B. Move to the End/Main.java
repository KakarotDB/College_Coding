//  B. Move to the End

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
            for(int i = 1; i < n; i++)
                prefix_sum[i] = prefix_sum[i-1] + a[i];
            long[] prefix_max = new long[n];
            prefix_max[0] = a[0];
            for (int i = 1; i < n; i++) {
                prefix_max[i] = max(prefix_max[i - 1], a[i]);
            }
            for (int i = 1; i <= n; i++) {
                pw.print(prefix_max[n - i] + prefix_sum[n - 1] - prefix_sum[n - i]+ " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}