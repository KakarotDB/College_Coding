//  B. Deja Vu

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
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long[] x = new long[q];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < q; i++) {
                x[i] = Long.parseLong(st.nextToken());
            }
            long prev = 31;
            for (int i = 0; i < q; i++) {
                if (x[i] >= prev) continue;
                long val = (long) pow(2, x[i]);
                for (int j = 0; j < n; j++) {
                    if (a[j] % val == 0)
                        a[j] += val / 2;
                }
                prev = x[i];
            }
            for (long l : a) {
                pw.print(l + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}