//  C. Raspberries

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
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            int ans = Integer.MAX_VALUE;
            int even_count = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] % 2 == 0)
                    even_count++;
                if (a[i] % k == 0)
                    ans = 0;
                ans = min(ans, (k - a[i] % k));
            }
            if (k == 4) {
                if (even_count >= 2)
                    ans = min(ans, 0);
                else if (even_count == 1)
                    ans = min(ans, 1);
                else if (even_count == 0)
                    ans = min(ans, 2);
            }
            pw.println(ans);

        }
        pw.flush();
        pw.close();
        br.close();

    }
}