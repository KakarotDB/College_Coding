//  B. Line Segments

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            long px = Long.parseLong(st.nextToken());
            long py = Long.parseLong(st.nextToken());
            long qx = Long.parseLong(st.nextToken());
            long qy = Long.parseLong(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            long sum_distances = 0;
            for (int i = 0; i < n; i++) {
                sum_distances += a[i];
            }
            long max_distance = Arrays.stream(a).max().getAsLong();
            long distance = (px-qx) * (px - qx) + (py - qy) * (py - qy);
            if (sum_distances * sum_distances < distance) {
                pw.println("No");
                continue;
            }
            long minimum = max(2 * max_distance - sum_distances, 0);
            if (minimum * minimum > distance) {
                pw.println("No");
                continue;
            }
            pw.println("Yes");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}