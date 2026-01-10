//  B. Bitwise Reversion

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
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long z = Long.parseLong(st.nextToken());

            boolean c1 = ((y & z) | x) == x;
            boolean c2 = ((x & z) | y) == y;
            boolean c3 = ((x & y) | z) == z;

            if (c1 && c2 && c3)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}