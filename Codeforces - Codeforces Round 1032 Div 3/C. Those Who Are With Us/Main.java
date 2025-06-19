//  C. Those Who Are With Us

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
            int m = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][m];
            int max_num = matrix[0][0];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    max_num = max(max_num, matrix[i][j]);
                }
            }
            int[] row = new int[n]; //array for storing frequency of max values in each row
            int[] col = new int[m]; //same as above but for each column
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == max_num) {
                        count++;
                        row[i]++; //ith row position frequency increases
                        col[j]++;
                    }
                }
            }
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int c = row[i] + col[j];
                    if (matrix[i][j] == max_num) //if the current Aij element has max, then c = 2 ( but should be 1)
                        c--;                     //so c--
                    if (c == count) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag)
                pw.println(max_num - 1);
            else
                pw.println(max_num);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}