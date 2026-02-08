// D. Unfair Game

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
        int[][] nCr = new int[32][32];
        nCr[0][0] = 1;
        for (int i = 0; i < 32; i++) {
            nCr[i][0] = 1; // nC0 is always 1
            for (int j = 1; j <= i; j++) {
                nCr[i][j] = nCr[i - 1][j - 1] + nCr[i - 1][j];
            }
        }
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            /*
            Simplified problem :
            Given a number 'a', odd -> a -= 1, else a/=2
            f(a) is number of steps to reach 0
            How any numbers in between [1,n] such that f(a) > k

            Per step, we are removing a 0, or unsetting a set bit (binary representation)
            Number of moves = MSB(a) + SetBits(a) - 1
            Or, number of moves = 2 * (setbits) + (unsetbits) - 1
            1 step for MSB + 2 Steps for each 1 + 1 step for each zero
            [1,n], how many numbers take more than k steps

            Count total numbers alice can make 0 in <= k moves

            So totalMoves = msb(takes MSB position amount of moves to reduce to 0) + i(number of setbits) + 1(one more move for the msb itself)

            Now, if we have MSB position, and i extra bits, total numbers that can be built = (msb, i)
            

             */
            int d = Integer.numberOfTrailingZeros(n);
            int ans = 0;

//            pw.println(d);
            for (int msb = 0; msb < d; msb++) {
                for (int i = 0; i < msb + 1; i++) {
                    int totalMoves = msb + 1 + i;

                    if (totalMoves <= k) ans += nCr[msb][i];
                    else break;
                }
            }

            if (d + 1 <= k) ans++;
            pw.println(n - ans);
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
}