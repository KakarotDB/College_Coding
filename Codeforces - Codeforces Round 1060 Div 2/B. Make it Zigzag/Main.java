//  B. Make it Zigzag

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
            long[] prefixMax = new long[n];
            prefixMax[0] = a[0];
            for (int i = 1; i < n; i++) {
                prefixMax[i] = max(a[i], prefixMax[i - 1]);
            }
            long cost = 0;

            for (int i = 1; i < n; i++) {
                if (i % 2 == 1) {
                    if (a[i] <= a[i - 1]) {
                        a[i] = prefixMax[i];
                        if (a[i -1] == a[i])
                            cost++;
                    }
                    if (i + 1 < n) {
                        if (a[i] <= a[i + 1]) {
                            a[i] = prefixMax[i];
                            if (a[i] <= a[i + 1]){
                                cost += a[i + 1] - a[i] + 1;
                                a[i + 1] = a[i + 1] - cost;
                            }
                        }
                    }
                }
            }
            pw.println(cost);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}