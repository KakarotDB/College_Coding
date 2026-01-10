// B. Keep it Beautiful

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
        /* 
        Note
        If there is some cyclic shifts with a string s:
        s += s can help in simplifying the problem  
        */
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Long> x = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                x.add(Long.parseLong(st.nextToken()));
            }
            /*
            n queries
            x[i]th query :
               can we append x[i] to a to keep it beautiful
               otherwise do nothing
            output :
                string s[i] = 1 if ith index was appended
             */
            boolean isSorted = true;
            for (int i = 1; i < n; i++) {
                if (x.get(i - 1) > x.get(i)) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                pw.println("1".repeat(n));
                continue;
            }
            StringBuilder s = getStringBuilder(x, n);
            pw.println(s);
        }
        pw.flush();
        pw.close();
        br.close();
    }

    private static StringBuilder getStringBuilder(List<Long> x, int n) {
        long first = x.getFirst();
        long last = x.getFirst();
        boolean broken = false;
        StringBuilder s = new StringBuilder();
        s.append("1");
        for (int i = 1; i < n; i++) {
            long current = x.get(i);
            if (!broken) {
                if (current >= last) {
                    s.append("1");
                    last = current;
                } else if (current <= first) {
                    broken = true;
                    s.append("1");
                    last = current;
                } else s.append("0");
            } else {
                if (current >= last && current <= first) {
                    last = current;
                    s.append("1");
                } else s.append("0");
            }
        }
        return s;
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