//  A. Homework

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
            StringBuilder a = new StringBuilder(br.readLine());
            int m = Integer.parseInt(br.readLine());
            String b = br.readLine();
            String c = br.readLine();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < m; i++) {
                if (c.charAt(i) == 'D') a.append(b.charAt(i));
                else a.insert(0, b.charAt(i));
            }
            pw.println(s.toString() + a.toString());
        }

        pw.flush();
        pw.close();
        br.close();
    }
}