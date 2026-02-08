// D. Shortest Statement Ever

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
        Suffix sum can be calculated using TotalSum - CurrentPrefixSum
        Thinking in number lines can be helpful

        given two integers : (x, y)

        We have to find (p, q)
        p & q == 0 -> no bits which are 1 line up
        msb cannot be same

        We can try performing binary search ?
        Don't think it would work that well

        Maybe we could try focusing on the first bit in which x & y == 1

        so we need to find the first bit where x & y == 1

        x = 7, y = 11
        111 1011
         111
        1011
          ^
          this is where they match
        x & y = 0010
        let's reserve all the bits above this position for p
        p = 110 1
        q = 1000 3

        Let's try putting p = x
        and then at each conflict position set q bit to off


        */
        test:
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if ((x&y)==0) {
                pw.println(x + " " + y);
                continue;
            }

            long[] cost1 = solve(x, y);
            long[] cost2 = solve(y, x);
            if (cost1[0] < cost2[0]) {
                pw.println(x + " " + cost1[2]);
            } else pw.println(cost2[2] + " " + y);
        }
        pw.flush();
        pw.close();
        br.close();
    }
    public static long[] solve(long x, long y) {
        long p = x; long q = 0;
        long best = abs(y - q);
        for (long i = 0; i < 33; i++) {
            long test = 0;

            for (long j = 0; j < i; j++) {
                if ((p & 1L << j) == 0) test |= 1L << j;
            }
            for (long j = i + 1L; j < 33; j++) {
                if ((y & 1L << j) != 0 && (p & 1L << j) == 0) test |= 1L << j;
            }

            if (abs(test - y) < best) {
                q = test;
                best = abs(test - y);
            }

            if ((p & 1L << i) != 0) continue;

            test = 1L << i;

            for (long j = i + 1L; j < 33; j++) {
                if ((y & 1L << j) != 0 && (p & 1L << j) == 0) test |= 1L << j;
            }

            if (abs(test - y) < best) {
                q = test;
                best = abs(test - y);
            }
        }
        return new long[] {best, p , q};
    }
    static final int MAX = 200005;
    static int[] sp = new int[MAX];
    static void sieve() {
        for (int i = 2; i < MAX; i++) {
            if (sp[i] == 0) {
                for (int j = i; j < MAX; j += i) {
                    if (sp[j] == 0) sp[j] = i;
                }
            }
        }
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

    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        if (array == null || array.length <= 1) return true;

        for (int i = 0; i < array.length - 1; i++) {
            // compareTo returns > 0 if array[i] is greater than array[i+1]
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        if (list == null || list.size() <= 1) return true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(char[] array) {
        if (array == null || array.length <= 1) return true;

        for (int i = 0; i < array.length - 1; i++) {
            // Primitives use standard comparison operators
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}