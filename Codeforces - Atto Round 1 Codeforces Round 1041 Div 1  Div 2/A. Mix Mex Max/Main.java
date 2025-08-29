//  A. Mix Mex Max

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
            int targetVal = -1;
            boolean check = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != -1) {
                    if (a[i] == 0) {
                        check = false;
                        break;
                    }
                    if (targetVal == -1) targetVal = a[i];
                    else if (a[i] != targetVal) {
                        check = false;
                        break;
                    }
                }
            }
            if (check)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}