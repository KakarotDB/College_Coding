//  B. Alternating Series

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
            if (n == 2)
                pw.println("-1 2");
            else if (n % 2 != 0) {
                for (int i = 0; i < n; i++) {
                    pw.print(i % 2 == 0? "-1 " : "3 ");
                    if (i == n - 1)
                        pw.println();
                }
            } else if (n % 2 == 0) {
                for (int i = 0; i < n - 1; i++) {
                    pw.print(i % 2 == 0? "-1 " : "3 ");
                }
                pw.print("2");
                pw.println();
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}