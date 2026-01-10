//  B. Abraham's Great Escape

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
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (k == n * n - 1) {
                pw.println("NO");
                continue;
            }
            pw.println("YES");
            char[][] ans = new char[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    ans[i][j] = 'R';
                }
                ans[i][n - 1] = 'D';
            }
            ans[n -1][n - 1] = 'L';

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (k > 0) {
                        ans[i][j] = 'U';
                        k--;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pw.print(ans[i][j]);
                }
                pw.println();
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}