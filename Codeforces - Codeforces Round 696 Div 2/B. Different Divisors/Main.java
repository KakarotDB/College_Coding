//  B. Different Divisors

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
            long d = Long.parseLong(br.readLine());
            long p = nextPrime(d + 1);
            long q = nextPrime(p + d);
            pw.println(min(p * p * p, p * q));
        }
        pw.flush();
        pw.close();
        br.close();
    }
    public static long nextPrime(long n) {
        for (long i = n; ; i++) {
            boolean isPrime = true;
            for (long j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                return i;
        }
    }
}