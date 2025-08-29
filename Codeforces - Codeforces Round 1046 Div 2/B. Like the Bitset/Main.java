//  B. Like the Bitset

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
            String s = br.readLine();
            int consecutive_count = 0;
            int curr_count = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    curr_count++;
                    consecutive_count = max(curr_count, consecutive_count);
                }
                else {
                    curr_count = 0;
                }
            }
            if (consecutive_count >= k) {
                pw.println("NO");
                continue;
            }
            pw.println("YES");
            int[] p = new int[n];
            int e = 1;
            int num = n;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1')
                    p[i] = e++;
                else
                    p[i] = num--;
            }
            for (int i : p) {
                pw.print(i + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();

    }
}