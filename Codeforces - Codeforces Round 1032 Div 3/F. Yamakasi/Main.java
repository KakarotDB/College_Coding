//  F. Yamakasi

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
            long s = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
//            System.out.println(Arrays.toString(a));
            long[] prefix_sum = new long[n+1];
            for(int i = 1; i < n + 1; i++)
                prefix_sum[i] = prefix_sum[i-1] + a[i-1];
            
        }
        pw.flush();
        pw.close();
        br.close();

    }
}