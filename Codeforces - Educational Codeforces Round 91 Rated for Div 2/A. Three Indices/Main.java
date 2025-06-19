//  A. Three Indices

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
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            boolean flag = false;
            int index1 = 0, index2 = 0, index3 = 0;
            for (int i = 0; i < n - 2; i++) {
                if (a[i] < a[i + 1]) {
                    if (a[i + 1] > a[i + 2]) {
                        index1 = i;
                        index2 = i + 1;
                        index3 = i + 2;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                pw.println("YES");
                pw.println((index1 + 1) + " " + (index2 + 1) + " " + (1 + index3));
            } else
                pw.println("NO");


        }
        pw.flush();
        pw.close();
        br.close();

    }
}