//  D. Black and White Stripe

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
            int k = Integer.parseInt(st.nextToken());
            StringBuilder strip = new StringBuilder(br.readLine());
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (strip.charAt(i) == 'W')
                    count++;
            }
            int ans = count;
            for (int i = k; i < n; i++) {
                if (strip.charAt(i - k) == 'W') count--;
                if (strip.charAt(i) == 'W') count++;
                ans = min(ans, count);
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}