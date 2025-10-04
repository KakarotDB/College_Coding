//  A. Be Positive

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
            StringTokenizer st = new StringTokenizer("");
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            int ans = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == -1) count++;
                if (a[i] == 0) ans+=1;
            }
            if (count % 2 == 0)
                pw.println(ans);
            else
                pw.println(ans + 2);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}