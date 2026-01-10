//  E. khba Loves to Sleep!

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
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            int low = 0, high = x, T_optimal = 0;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (check(mid, n, k, x, a)) {
                    T_optimal = mid;
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }
            pw.println(T_optimal);
        }
        pw.flush();
        pw.close();
        br.close();
    }
    static boolean check(int T, int n, int k, int x, int[] a) {
        int tp_needed = 0;
        int last_covered = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] > last_covered) {
                tp_needed++;
                last_covered = a[i] + 2 * T;
                if (tp_needed > k)
                    return  false;
            }
        }
        return true;
    }
}