//  A. Square of Rectangles

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            long l1 = Long.parseLong(st.nextToken());
            long b1 = Long.parseLong(st.nextToken());
            long l2 = Long.parseLong(st.nextToken());
            long b2 = Long.parseLong(st.nextToken());
            long l3 = Long.parseLong(st.nextToken());
            long b3 = Long.parseLong(st.nextToken());
            long area = (l1 * b1) + (l2 * b2) + (l3 * b3);
            long s = max(l1,b1);
            if (s * s != area)
                pw.println("NO");
            else if ((l1 == l2 && l2 == l3  && (b1 + b2 + b3) == l1) || (b1 == b2 && b2 == b3 && (l1 + l2 + l3 == b1)) )
                pw.println("YES");
            else if (l1 == l2 + l3 && b1 + b2 == l1 && b3 == b2)
                pw.println("YES");
            else if (b1 == b2 + b3 && l1 + l2 == b1 && l2 == l3) {
                pw.println("YES");
            }
            else
                pw.println("NO");


        }
        pw.flush();
        pw.close();
        br.close();
    }
}