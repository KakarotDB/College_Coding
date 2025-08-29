//  B. SUMdamental Decomposition

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
            long n = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            if (n == 1) {
                if (x == 0) pw.println(-1);
                else pw.println(x);
                continue;
            }
            long sb = Long.bitCount(x);
            if (sb >= n) {
                pw.println(x);
                continue;
            }
            long ans = x + (n - sb);
            if ((n - sb) % 2 != 0) {
                if (x == 0 || x == 1)
                    ans += 3;
                else ans++;
            }

            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}