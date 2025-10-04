//  D. Destruction of the Dandelion Fields

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            List<Long> odd = new ArrayList<>();
            List<Long> even = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 0)
                    even.add(a[i]);
                else
                    odd.add(a[i]);
            }
            if (odd.isEmpty()) {
                pw.println(0);
                continue;
            }
            long ans = 0;
            for (int i = 0; i < even.size(); i++) {
                ans += even.get(i);
            }
            odd.sort(Collections.reverseOrder());
            int take = (odd.size() + 1 )/ 2;
            for (int i = 0; i < take; i++) {
                ans += odd.get(i);
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}