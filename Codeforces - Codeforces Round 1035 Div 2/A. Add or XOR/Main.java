//  A. Add or XOR

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
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            if (b < a - 1)
                pw.println(-1);
            else if (b == a - 1) {
                if (a % 2 != 0)
                    pw.println(y);
                else
                    pw.println(-1);
            }
            else {
                long ans = 0;
                while (a != b) {
                    if (a % 2 == 0) ans += min(x, y);
                    else ans += x;
                    a++;
                }
                pw.println(ans);
            }

        }
        pw.flush();
        pw.close();
        br.close();
    }
}