//  A. Game of Division

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
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            boolean res = false;
            if (n == 1) {
                pw.println("YES\n1");
                continue;
            }
            for (int i = 0; i < n; i++) {
                boolean check = true;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (abs(a[i] - a[j]) % k == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    pw.println("YES\n" + (i + 1));
                    res = true;
                    break;
                }
            }
            if (!res)
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();

    }
}