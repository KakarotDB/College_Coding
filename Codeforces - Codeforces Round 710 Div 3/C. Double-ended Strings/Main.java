//  C. Double-ended Strings

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
            StringBuilder a = new StringBuilder(br.readLine());
            StringBuilder b = new StringBuilder(br.readLine());
            int m = a.length();
            int n = b.length();
            int ans = m + n;
            for (int i = 0; i < m; i++) {
                for (int j = 1; j <= m - i; j++) {
                    String s = a.substring(i, i + j);
                    if (b.toString().contains(s)) {
                        int o = m + n - 2 * j;
                        ans = min(o, ans);
                    }
                }
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}