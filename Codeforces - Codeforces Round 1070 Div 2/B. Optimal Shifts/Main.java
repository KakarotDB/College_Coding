// B. Optimal Shifts

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
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int count1 = (int) s.chars().filter(ch -> ch == '1').count();
            if (count1 == n) {
                pw.println(0);
                continue;
            }
//            if (count1 == 1) {
//                int idx1 = -1;
//                for (int i = 0; i < n; i++) {
//                    if (s.charAt(i) == '1') idx1 = i;
//                }d
//                pw.println(idx1 + abs(n - idx1));
//                continue;
//            }
            /*
            So covered cases : all 1's and single 1
            Case 1 :
            Starting index has a 1 :
            1010101010 -> max consecutive zeroes = 1 = answer
            1001001001 -> max consecutive zeroes = 2 = answer
            1010010010000100 -> ans = max consecutive zeroes
             */
            if (s.charAt(0) == '1' || s.charAt(n - 1) == '1') {
                int max = 0;
                int current = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') {
                        current++;
                        max = max(current, max);
                    } else {
                        current = 0;
                    }
                }
                pw.println(max);
                continue;
            }
            /*
            Case 2 : Starting index does NOT have a 1 but ending index does
            000101001001
            same answer
            Case 3 : Neither starting nor ending index has a 1
            0010010100010
            max(0s back + 0s front, consecutive zeroes in between)
             */
            int count_front = 0;
            int count_back = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') break;
                count_front++;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == '1') break;
                count_back++;
            }
            int max = 0; int current = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    current++;
                    max = max(current, max);
                }
                else current = 0;
            }
            pw.println(max(max, (count_front + count_back)));
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