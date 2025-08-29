//  B. Apples in Boxes

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
            long k = Long.parseLong(st.nextToken());
            long[] a = new long[n];
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                sum += a[i];
            }
            Arrays.sort(a);
            a[n - 1]--;
            Arrays.sort(a);
            if (a[n - 1] - a[0] > k || sum % 2 == 0)
                pw.println("Jerry");
            else
                pw.println("Tom");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}