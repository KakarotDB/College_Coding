//  C. Symmetrical Polygons

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

            Map<Long, Integer> fmap = new HashMap<>();
            Set<Long> unique_sticks = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                fmap.put(a[i], fmap.getOrDefault(a[i], 0) + 1);
                unique_sticks.add(a[i]);
            }

            int current_perimeter;
            
        }
        pw.flush();
        pw.close();
        br.close();
    }
}