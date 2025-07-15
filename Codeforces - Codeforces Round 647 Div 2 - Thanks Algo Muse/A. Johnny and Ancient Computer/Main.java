//  A. Johnny and Ancient Computer

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
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long ra = a;
            long rb = b;
            while (ra % 2 == 0) ra/=2;
            while (rb % 2 == 0) rb/=2;
            if (ra != rb)
                pw.println(-1);
            else {
                a /= ra;
                b /= rb;
                a = (long) (log(a) / log(2));
                b = (long) (log(b) / log(2));
                pw.println((abs(a - b) + 2) / 3);
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}