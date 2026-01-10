//  A2: Snake Scales (Chapter 2)

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int c = 1;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long low = 0;
            long high = 1000000000;
            long ans = high;
            while(low <= high) {
                long mid = (low + high) / 2;
                if (check(mid, n, a)) {
                    ans = mid;
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            pw.println("Case #" + c + ": " + ans);
            c++;
        }
        pw.flush();
        pw.close();
        br.close();
    }
    public static boolean check(long h, int n, long[] a) {
        int i = 0;
        while(i < n) {
            int start = i;
            int end = start;

            while(end + 1 < n && abs(a[end] - a[end + 1]) <= h) {
                end++;
            }

            boolean check = false;

            for (int k = start; k <= end; k++) {
                if (a[k] <= h) {
                    check = true;
                    break;
                }
            }
            if(!check)
                return false;
            i = end + 1;
        }
        return true;
    }
}