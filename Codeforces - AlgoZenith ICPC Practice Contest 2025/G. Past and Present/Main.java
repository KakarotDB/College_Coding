//  G. Past and Present

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long dp0 = 0, dp1 = 0, dp2 = 0, dp3 = 0;
        long[] max_ending_left = new long[n];
        long[] max_overall_let = new long[n];

        long ldp0 = 0, ldp1 = 0, ldp2 = 0;
        long lMaxTilNow = 0;

        for (int i = 0; i < n; i++) {
            long ai = a[i];
            long aiX = a[i] * x;

            ldp2 = max(ldp1, ldp2) + ai;
            ldp1 = max(ldp0, ldp1) + aiX;
            ldp0 = max(ldp0, 0) + ai;

            max_ending_left[i] = max(ldp1, ldp2);
            lMaxTilNow = max(lMaxTilNow, max(ldp0, max_ending_left[i]));
            max_overall_let[i] = lMaxTilNow;
        }

        long[] max_starting_right = new long[n];

        long rdp0 = 0, rdp1 = 0, rdp2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            long ai = a[i];
            long aiX = a[i] * x;
            rdp2 = max(rdp1, rdp2) + ai;
            rdp1 = max(rdp0, rdp1) + aiX;
            rdp0 = max(rdp0, 0) + ai;
            max_starting_right[i] = max(rdp1, rdp2);
        }

        long max = max_overall_let[n - 1];
        for (int i = 0; i < n - 1; i++) {
            max = max(max, max_ending_left[i] + max_starting_right[i + 1]);
        }
        pw.println(max(0, max));
        pw.flush();
        pw.close();
        br.close();
    }
}
