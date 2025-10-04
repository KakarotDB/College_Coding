//  C. Count Good Numbers

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
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            pw.println(countGood(r) - countGood(l - 1));
        }
        pw.flush();
        pw.close();
        br.close();
    }
    public static long countGood(long n) {
        long sum = 0;
        sum += n/2 + n/3 + n/5 + n/7;
        sum -= (n/6 + n/15 + n/35 + n/14 + n/10 + n/21);
        sum += n/70 + n/30 + n/42 + n/105;
        sum -= n / 210;
        return n - sum;
    }
}