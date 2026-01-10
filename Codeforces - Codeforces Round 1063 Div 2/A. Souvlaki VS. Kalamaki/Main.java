//  A. Souvlaki VS. Kalamaki

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
            Arrays.sort(a);
            boolean win = true;
            for (int i = 1; i < n - 1 && win; i+=2) {
                if (a[i] < a[i + 1]) {
                    win = false;
                    break;
                }
            }
            if (win) pw.println("YES");
            else pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}