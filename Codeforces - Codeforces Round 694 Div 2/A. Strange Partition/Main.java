//  A. Strange Partition

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
            long x = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] a = new long[n];
            long max_beauty = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                max_beauty += (a[i] + x - 1) / x;
            }
            long min_beauty = (Arrays.stream(a).sum() + x - 1) / x;
            pw.println(min_beauty + " " + max_beauty);

        }
        pw.flush();
        pw.close();
        br.close();

    }
}