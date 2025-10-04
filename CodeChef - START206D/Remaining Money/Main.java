//  Remaining Money

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
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

        }
        pw.flush();
        pw.close();
        br.close();
    }
     public static boolean isPrime(int n) {
             if (n < 2)
                 return false;
             if (n < 4)
                 return true;
             if ((n & 1) == 0)
                 return false;
             for (int i = 3; i * i <= n; i++)
                 if (n % i == 0)
                     return false;
             return true;
     }
}