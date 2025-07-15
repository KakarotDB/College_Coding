//  A. Reverse a Substring

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringBuilder s = new StringBuilder(br.readLine());
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                pw.println("YES");
                pw.println((i + 1) + " " + (i + 2));
                flag = true;
                break;
            }
        }
        if (!flag)
            pw.println("NO");
        pw.flush();
        pw.close();
        br.close();
    }
}