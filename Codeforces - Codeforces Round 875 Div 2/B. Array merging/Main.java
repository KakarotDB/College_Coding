//  B. Array merging

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
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            int[] longest_SubArray_A = new int[2 * n + 1];
            int[] longest_SubArray_B = new int[2 * n + 1];
            int counter = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1])
                    counter++;
                else {
                    longest_SubArray_A[a[i - 1]] = max(longest_SubArray_A[a[i - 1]], counter);
                    counter = 1;
                }
            }
            longest_SubArray_A[a[n-1]] = max(longest_SubArray_A[a[n-1]], counter);
            counter = 1;
            for (int i = 1; i < n; i++) {
                if (b[i] == b[i - 1])
                    counter++;
                else {
                    longest_SubArray_B[b[i - 1]] = max(longest_SubArray_B[b[i - 1]], counter);
                    counter = 1;
                }
            }
            longest_SubArray_B[b[n-1]] = max(longest_SubArray_B[b[n-1]], counter);
            int max_freq = -1;
            for(int i = 1; i <= 2 * n; i++){
                max_freq = max(longest_SubArray_A[i] + longest_SubArray_B[i], max_freq);
            }
            pw.println(max_freq);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}