//  B. The Secret Number

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
            long n = Long.parseLong(br.readLine());
            ArrayList<Long> x = new ArrayList<>();
            long p = 10;
            while (p <= n) {
                long denom = 1 + p;
                if (n % denom == 0) {
                    long X = n / denom;
                    x.add(X);
                }
                if (p > Long.MAX_VALUE / 10) break;
                p *= 10;
            }

            if (x.isEmpty())
                pw.println(0);
            else
            {
                Collections.sort(x);
                pw.println(x.size());
                for (Long l : x) {
                    pw.print(l + " ");
                }
                pw.println();
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}