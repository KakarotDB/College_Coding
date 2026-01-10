// B. WeirdSort

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        test:
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<Long> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Long.parseLong(st.nextToken()));
            }
            List<Long> p = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                p.add(Long.parseLong(st.nextToken()));
            }
            boolean[] allowed = new boolean[n];
            for (int i = 0; i < m; i++) {
                allowed[p.get(i).intValue() - 1] = true;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (a.get(j) > a.get(j + 1) && allowed[j]) {
                        long temp = a.get(j);
                        a.set(j, a.get(j + 1));
                        a.set(j + 1, temp);
                    }
                }
            }
            if (isSorted(a)) pw.println("YES");
            else pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static boolean isSorted(List<Long> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i + 1)) return false;
        }
        return true;
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