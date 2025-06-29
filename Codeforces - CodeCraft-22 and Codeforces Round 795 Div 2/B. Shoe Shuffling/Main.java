//  B. Shoe Shuffling

import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            int i = 0;
            boolean possible = true;
            while (i < n) {
                int start = i;
                while (i < n - 1 && a[i] == a[i + 1]) i++;
                if (start != i) {
                    a[start] = i + 1;
                    for (int j = start + 1; j <= i; j++) {
                        a[j] = j;
                    }
                }
                else {
                    possible = false;
                    break;
                }
                i++;
            }
            if (possible) {
                for (int j = 0; j < n; j++) {
                    pw.print(a[j]+ " ");
                }
                pw.println();
            }
            else
                pw.println(-1);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}