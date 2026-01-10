// F. Football

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

        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        if (n == 1) {
            pw.println(a == b ? 1 : 0);
            pw.println(a + ":" + b);
        } else if (a + b <= n) {
            int[] A = new int[n];
            int[] B = new int[n];
            for (int i = 0; i < a; i++) {
                A[i] = 1;
            }
            pw.println(n - (a + b));
            for (int i = a; i < n && b-- > 0; i++) {
                B[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                pw.println(A[i] + ":" + B[i]);
            }
        } else {
            int[] A = new int[n];
            int[] B = new int[n];
            pw.println(0);
            if (b == 0) {
                Arrays.fill(A, 1);
                A[0] += a - n;
            } else if (a == 0) {
                Arrays.fill(B, 1);
                B[0] += b - n;
            }
            else {
                int k = min(a, n - 1);
                for (int i = 0; i < k; i++) {
                    A[i] = 1;
                }
                for (int i = k; i < n; i++) {
                    B[i] = 1;
                }
                A[0] += a - k;
                B[n - 1] += b - (n - k);
            }
            for (int i = 0; i < n; i++) {
                pw.println(A[i] + ":" + B[i]);
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
}