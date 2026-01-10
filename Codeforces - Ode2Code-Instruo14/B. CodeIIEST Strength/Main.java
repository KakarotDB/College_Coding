//  B. CodeIIEST Strength

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

            long[] prefOr = new long[n + 2];
            long[] sufOr = new long[n + 2];

            for (int i = 1; i <= n ; i++) {
                prefOr[i] = prefOr[i - 1] | a[i - 1];
            }

            for (int i = n; i >= 1; i--) {
                sufOr[i] = sufOr[i + 1] | a[i - 1];
            }

            long totalStrength = prefOr[n];
            long special = 0;

            for (int i = 1; i <= n; i++) {
                long strengthwo = prefOr[i - 1] | sufOr[i + 1];

                if (strengthwo != totalStrength)
                    special++;
            }
            pw.println(special);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}