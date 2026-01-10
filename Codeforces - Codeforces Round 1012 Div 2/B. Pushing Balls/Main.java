//  B. Pushing Balls

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
            int m = Integer.parseInt(st.nextToken());
            int[][] a = new int[n][m];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                String row = br.readLine();
                for (int j = 0; j < m; j++) {
                    a[i][j] = row.charAt(j) - '0';
                }
            }

            int[][] left = new int[n][m];
            int[][] top = new int[n][m];

            for (int i = 0; i < n; i++) {
                left[i][0] = a[i][0];
            }
            for (int i = 0; i < m; i++) {
                top[0][i] = a[0][i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (a[i][j] == 1)
                        left[i][j] = left[i][j - 1];
                }   
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 1)
                        top[i][j] = top[i - 1][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(a[i][j] == 1 && left[i][j] == 0 && top[i][j] == 0) {
                        flag = false;
                        break;
                    }
                }
                if (!flag)
                    break;
            }

            if (flag)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}