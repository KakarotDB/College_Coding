//  E. Building an Aquarium

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long start_index = 1, end_index = Arrays.stream(a).max().getAsLong() + x, ans = -1;
            while (start_index <= end_index) {
                long mid = (start_index) + (end_index - start_index) / 2;
                if (check(mid, a, x)) {
                    ans = mid;
                    start_index = mid + 1;
                }
                else
                    end_index = mid - 1;
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
    public static boolean check(long mid, long[] array, long x) {
        long units = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] < mid)
                units += (mid - array[i]);
        }
        return units <= x;
    }
}