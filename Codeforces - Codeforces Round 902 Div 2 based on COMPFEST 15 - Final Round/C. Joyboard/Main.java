// C. Joyboard

import java.lang.reflect.Array;
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
        /* 
        Note
        If there is some cyclic shifts with a string s:
        s += s can help in simplifying the problem  
        */
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            /*
            given m,
            we have n + 1 slots labelled 1 -> n + 1
            We can only choose a number for An+1, and choose a number between [0,m]
            Then, ai-1 = ai mod i
            We need to assign An+1 such that there are exactly k distinct values across all slots
            Output number of valid ways

            Case 1 : An+1 < n
            Example : n = 5, An+1 = 3
            A5 = 3 mod 5 = 3
            A4 = 3 mod 3 = 0
            A3 = 0 mod 3 = 0...00
            slots : 3 3 0 0 0 0, so for An+1 = 0, k = 1, An+1 < n, k = 2
            Example : n = 5, An+1 = 4
            A6 =4
            A5 = 4 mod 6 = 4
            A4 = 4 mod 5 = 4
            A3 = 4 mod 4 = 0...
            4 4 0 0 0 0, same conclusion.

            Now,
            Case 2: An+1 >= n;
            Example: n = 5, An+1 = 5
            A6 = 5
            A5 = A6 mod 5 = 5 mod 5 = 0
            A4 = A5 mod 4 = 0 mod 4 = 0
            A3 = A4 mod 3 = 0 mod 3 = 0
            k = 2, An+1 = n
            Example : n = 5, An+1 = 10
            A6 = 10
            A5 = A6 mod 5 = 10 % 5 = 0
            A4 = A5 mod 4 = 0 % 4 = 0 ...
            10 0 0 0 0 0, k = 2

            Example: n = 5, An+1 = 11 (case An+1 > n && An+1 % n != 0)
            A6 = 11
            A5 = 11 % 5 = 1
            A4 = 1 % 4 = 1
            A3 = 1 % 3 = 1
            A2 = 1 % 2 = 1
            A1 = 1 % 1 = 0
            11 1 1 1 1 0, k = 3
            So we get, An+1, An+1 % n, 0, k = 3
             */
            if (k > 3) pw.println(0);
            else if (k == 1) pw.println(1);
            else if (k == 2) pw.println(min(m, n - 1) + m / n);
            else if (k == 3) pw.println(m > n ? (m - n) - (m / n - 1): 0);
        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static long gcd(long a, long b) {
        if (a == 0 && b == 0)
            return 0;
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a < 0)
            a = -a;
        if (b < 0)
            b = -b;

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void printArray(Object array, PrintWriter pw) {
        if (array.getClass().isArray()) {
            int n = Array.getLength(array);
            for (int i = 0; i < n; i++) {
                pw.print(Array.get(array, i) + " ");
            }
            pw.println();
        }
        else if (array instanceof Collection<?>) {
            for (Object o : (Collection<?>) array) {
                pw.print(o + " ");
            }
            pw.println();
        }
        else
            return;
    }

    public static class Pair implements Comparable<Pair> {
        long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object)
                return true;
            if (!(object instanceof Pair pair))
                return false;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Pair other) {
            return Long.compare(this.x, other.x);
        }
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