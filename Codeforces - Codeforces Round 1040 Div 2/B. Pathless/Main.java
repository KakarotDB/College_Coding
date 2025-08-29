//  B. Pathless

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
            int s = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int count_0 = 0, count_1 = 0, count_2 = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
                if (a[i] == 0)
                    count_0++;
                if (a[i] == 1) count_1++;
                if (a[i] == 2) count_2++;
            }
            if (s < sum || s - sum == 1) {
                for (int i = 0; i < count_0; i++) {
                pw.print(0 + " ");
            }
            for (int i = 0; i < count_2; i++) {
                pw.print(2 + " ");
            }
            for (int i = 0; i < count_1; i++) {
                pw.print(1 + " ");
            }
            pw.println();
            }
            else
                pw.println(-1);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}