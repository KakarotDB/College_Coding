//  B. Add 0 or K

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
            StringBuilder out = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            if (n == 1) {
                pw.println(a[0] + k);
                continue;
            }
            long num = -1;
            int[] prime = {2, 3, 5, 7, 11, 13 , 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};
            for (int i : prime) {
                if (k % i != 0){
                    num = i;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                while (a[i] % num != 0) a[i] += k;
            }
            for (long l : a) {
                pw.print(l + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}