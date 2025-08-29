//  A. Lever

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            boolean check = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                pw.println(1);
                continue;
            }
            int max_difference = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] > b[i])
                    max_difference += a[i] - b[i];
            }
            pw.println(max_difference+1);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}