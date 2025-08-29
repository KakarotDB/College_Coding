//  C. Make it Equal

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
            long k = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] s = new long[n];
            for (int i = 0; i < n; i++) {
                s[i] = Long.parseLong(st.nextToken()) % k;
            }
            st = new StringTokenizer(br.readLine());
            long[] T = new long[n];
            for (int i = 0; i < n; i++) {
                T[i] = Long.parseLong(st.nextToken()) % k;
            }
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                long val = s[i] % k;
                a[i] = min(val, k - val);
            }
            for (int i = 0; i < n; i++) {
                long val = T[i] % k;
                b[i] = min(val, k - val);
            }
            Arrays.sort(a);
            Arrays.sort(b);
            boolean check = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    check = false;
                    break;
                }
            }
            if (check)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}