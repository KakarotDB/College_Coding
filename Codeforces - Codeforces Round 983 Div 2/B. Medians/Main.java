//  B. Medians

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
            if (n == 1) {
                pw.println(1);
                pw.println(1);
            } else if (k == n || k == 1) {
                pw.println(-1);
            } else if (k % 2 == 0) {
                pw.println(3);
                pw.println(1 + " " + k + " " + (k + 1));
            } else {
                pw.println(3);
                pw.println(1 + " " + (k - 1) + " " + (k + 2));
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}