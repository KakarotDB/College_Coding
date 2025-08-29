//  C. Yarik and Array

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
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            long ans = a[0];
            long current_Sum = a[0];
            for (int i = 1; i < n; i++) {
                if (((a[i - 1] ^ a[i]) & 1) == 1) {
                    current_Sum = Math.max(a[i], current_Sum + a[i]);
//                    ans = max(current_Sum, ans);
                } else {
                    current_Sum = a[i];
//                    ans = max(current_Sum, ans);
                }
                ans = max(current_Sum, ans);
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}