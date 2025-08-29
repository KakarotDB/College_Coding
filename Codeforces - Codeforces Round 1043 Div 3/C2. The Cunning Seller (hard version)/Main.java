//  C2. The Cunning Seller (hard version)

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
            long k = Long.parseLong(st.nextToken());
            long initial_cost = 0;
            ArrayList <Long> base3= new ArrayList<>();
            int x = 0;
            while (n > 0) {
                long remainder = n % 3;
                if (remainder != 0) {
                    initial_cost += remainder * ((long) pow(3, x + 1) + x * (long) pow(3, x - 1));
                }
                base3.add(remainder);
                k -= remainder;
                x++;
                n /= 3;
            }
//            Collections.reverse(base3);
//            pw.println(Arrays.toString(base3.toArray()));
            if (k < 0) {
                pw.println(-1);
                continue;
            }
            long[] p = new long[30];
            p[0] = 1;
            for (int i = 1; i < 30; i++) {
                p[i] = p[i - 1] * 3;
            }
            long reduction = 0;
            for (int i = base3.size() - 1; i >= 1; i--) {
                if (k > 1 && base3.get(i) != 0) {
                    long times = min(k / 2, base3.get(i));
                    k -= times * 2;
                    base3.set(i, base3.get(i) - times);
                    base3.set(i - 1, 3 * times + base3.get(i - 1));
                    reduction += times * p[i - 1];

                }
            }
            pw.println(initial_cost - reduction);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}