//  C. Flower City Fence

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
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            if (a[0] != n)
                pw.println("NO");
            else {
                List<Long> b = new ArrayList<>();
                for (int i = n - 1; i >= 0; i--) {
                    while (b.size() < a[i])
                        b.add((long) i + 1);
                }
                boolean check = true;
                for (int i = 0; i < n; i++) {
                    if (b.get(i) != a[i]) {
                        check = false;
                        break;
                    }
                }
                if (check)
                    pw.println("YES");
                else
                    pw.println("NO");
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}