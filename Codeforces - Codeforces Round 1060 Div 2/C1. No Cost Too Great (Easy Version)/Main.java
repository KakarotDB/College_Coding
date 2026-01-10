//  C1. No Cost Too Great (Easy Version)

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    static final int MAX = 200005;
    static int[] sp = new int[MAX];
    static void sieve() {
        for (int i = 2; i < MAX; i++) {
            if (sp[i] == 0) {
                for (int j = i; j < MAX; j += i) {
                    if (sp[j] == 0) sp[j] = i; //sp[x] gives smallest prime factor of x
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        sieve();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            br.readLine();
            Set<Integer> seen = new HashSet<>();
            boolean zero = false, one = false;

            for (int i = 0; i < n && !zero; i++) {
                int x = (int) a[i];
                while(x > 1) {
                    int p = sp[x];
                    while (x % p == 0) x /= p;
                    if (seen.contains(p)) zero = true;
                    seen.add(p); //this finds unique prime factors and checks if a previous prime factor has been found
                }
            }
            if (!zero) {
                Set<Integer> all = new HashSet<>(seen);
                for (int i = 0; i < n && !one; i++) {
                    int x = (int) a[i] + 1;
                    while(x > 1) {
                        int p = sp[x];
                        while(x % p == 0) x /= p;
                        if (all.contains(p)) {
                            one = true;
                            break;
                        }
                    }
                }
            }

            if (zero) pw.println(0);
            else if (one) pw.println(1);
            else pw.println(2);

        }
        pw.flush();
        pw.close();
        br.close();
    }
}