//  B. Beautiful Array

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); long k = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken()), s = Long.parseLong(st.nextToken());
            long minimum_sum = k * b;
            long maximum_sum = (k * b) + (long) (k - 1) * n;
            if (s < minimum_sum || s > maximum_sum)
                pw.println(-1);
            else {
                long[] a = new long[n];
                a[0] = minimum_sum;
                s -= minimum_sum;
                for (int i = 0; i < n; i++) {
                    long add = min(s, k - 1);
                    a[i] += add;
                    s -= add;
                }
                for (int i = 0; i < n; i++) {
                    pw.print(a[i] + " ");
                }
                pw.println();
            }

        }
        pw.flush();
        pw.close();
        br.close();
    }
}