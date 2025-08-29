//  C1. The Cunning Seller (easy version)

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
            long cost = 0;
            long x = 0;
            while (n > 0) {
                long remainder = n % 3;
                if (remainder != 0) {
                    cost += remainder * ((long) pow(3, x + 1) + x * (long) pow(3, x - 1));
                }
                x++;
                n /= 3;
            }
            pw.println(cost);
        }
        pw.flush();
        pw.close();
        br.close();
    }

}