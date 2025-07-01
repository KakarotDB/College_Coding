//  B. Numbers Box

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
            int count_0 = 0;
            int count_negatives = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (matrix[i][j] == 0)
                        count_0++;
                    if (matrix[i][j] < 0)
                        count_negatives++;
                }
            }
            int total_count = count_negatives + count_0;
            if (total_count % 2 == 0){
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        sum+=abs(matrix[i][j]);
                    }
                }
                pw.println(sum);
            } else if (count_negatives % 2 == 0 ) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        sum+=abs(matrix[i][j]);
                    }
                }
                pw.println(sum);
            }
            else {
                int sum = 0;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        sum+=abs(matrix[i][j]);
                        min = min(min, abs(matrix[i][j]));
                    }
                }
                sum = sum - 2 * abs(min);
                pw.println(sum);
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}