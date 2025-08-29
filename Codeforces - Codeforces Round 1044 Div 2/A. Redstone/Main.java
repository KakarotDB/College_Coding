//  A. Redstone?

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
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int q = 0; q < n; q++) {
                a[q] = Integer.parseInt(st.nextToken());
            }
            int count_distinct = (int) Arrays.stream(a).distinct().count();
            if (n - count_distinct > 0)
                pw.println("YES");
            else
                pw.println("NO");

        }
        pw.flush();
        pw.close();
        br.close();
    }
}