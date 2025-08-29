//  B. Slice to Survive

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
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (m - b + 1 < b) b = m - b + 1;
            if (n - a + 1 < a) a = n - a + 1;
            pw.println(min(1 + ans(n) + ans(b), 1 + ans(a) + ans(m) )); //treating each dimension independently
        }
        pw.flush();
        pw.close();
        br.close();
    }
    public static long ans(long n) {
        long count = 0;
        while (n > 1) {
            n = (n + 1) / 2;
            count++;
        }
        return count;
    }
}