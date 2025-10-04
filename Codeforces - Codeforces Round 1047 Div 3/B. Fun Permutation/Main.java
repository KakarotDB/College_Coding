//  B. Fun Permutation

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
            long[] p = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p[i] = Long.parseLong(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                pw.print(n + 1 - p[i] + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();

    }
}