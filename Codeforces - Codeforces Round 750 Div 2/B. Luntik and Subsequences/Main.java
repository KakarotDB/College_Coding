//  B. Luntik and Subsequences

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
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            int count_1s = 0;
            int count_0s = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 1)
                    count_1s++;
                if (a[i] == 0)
                    count_0s++;
            }
            pw.println(count_1s * (long) pow(2, count_0s));


        }
        pw.flush();
        pw.close();
        br.close();

    }
}