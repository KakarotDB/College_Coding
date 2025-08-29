//  A. Recycling Center

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
            int c = Integer.parseInt(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long ans = 0;
            Arrays.sort(a);
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] > c)
                    ans++;
                else {
                    for (int j = i - 1; j >= 0 ; j--) {
                        a[j] *= 2;
                    }
                }
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}