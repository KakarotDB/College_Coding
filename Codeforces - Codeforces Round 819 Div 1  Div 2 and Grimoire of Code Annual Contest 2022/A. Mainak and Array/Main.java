//  A. Mainak and Array

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
            int answer = a[n - 1] - a[0];
            for (int i = 0; i < n; i++) {
                answer = max(answer, a[i] - a[0]);
            }
            for (int i = 0; i < n - 1; i++) {
                answer = max(answer, a[n - 1] - a[i]);
            }
            for (int i = 0; i < n - 1; i++) {
                answer = max(answer, a[i] - a[i+1]);
            }
            pw.println(answer);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}