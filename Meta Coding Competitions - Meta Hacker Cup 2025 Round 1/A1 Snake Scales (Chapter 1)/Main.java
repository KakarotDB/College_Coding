    //  A1: Snake Scales (Chapter 1)

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
        int c = 0;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long max_diff = 0;
            for (int i = 0; i < n - 1; i++) {
                max_diff = max(max_diff, abs(a[i] - a[i + 1]));
            }
            pw.println("Case #" + (c + 1) + ": " + max_diff);
            c++;
        }
        pw.flush();
        pw.close();
        br.close();
    }
}