// C. Superultra's Favorite Permutation

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

        n = 2:
            1 2 -> prime sum -> -1
        n = 3:
            1 2 3, 1 3 2, 3 1 2, all combinations -> prime -> -1
        n = 4:
            1 2 3 4 -> all cyclic shifts -> -1
            -1
        n = 5:
            1 2 3 4 5 -> -1
            1 3 5 4 2
        n = 8:
            1 2 3 4 5 6 7 8
            1 3 5 7 2 4 6 8
        n = 9:
            1 2 3 4 5 6 7 8
        n = 10:
            1 3 5 7 9 6 2 4 8 10
        n = 11:
            11
        */
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Long> a = new ArrayList<>();
            if (n <= 4) pw.println(-1);
            else {
                for (int i = n % 2 == 0 ? n - 1: n; i >= 1; i -= 2) {
                    if (i == 5) continue;
                    pw.print(i + " ");
                }
                pw.print(5 + " ");
                pw.print(4 + " ");
                for (int i = n; i >= 1; i--) {
                    if (i == 4) continue;
                    if ((i & 1) == 0) pw.print(i + " ");

                }
            }

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
        } else if (array instanceof Collection<?>) {
            for (Object o : (Collection<?>) array) {
                pw.print(o + " ");
            }
            pw.println();
        } else
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