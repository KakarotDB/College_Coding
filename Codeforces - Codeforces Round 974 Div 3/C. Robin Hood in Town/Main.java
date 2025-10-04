//  C. Robin Hood in Town

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
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                sum += a[i];
            }
            Arrays.sort(a);
            long x = a[n / 2] * 2 * n - sum + 1;
            if (n <= 2) {
                pw.println(-1);
                continue;
            }
            if (x <= 0)
                pw.println(0);
            else
                pw.println(x);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}