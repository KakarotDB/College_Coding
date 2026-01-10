// C. Kanade's Perfect Multiples

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
            int k = Integer.parseInt(st.nextToken());
            List<Long> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a.add(Long.parseLong(st.nextToken()));
                set.add(a.get(i));
            }
            Collections.sort(a);

            List<Long> b = new ArrayList<>();
            Set<Long> visited = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (visited.contains(a.get(i))) continue ;
                long temp = a.get(i);
                visited.add(a.get(i));
                while (temp <= k){
                    if (!set.contains(temp)) {
                        pw.println(-1);
                        continue test;
                    }
                    temp += a.get(i);
                    visited.add(temp);
                }
                b.add(a.get(i));
            }
            pw.println(b.size());
            for (Long l : b) {
                pw.print(l + " ");
            }
            pw.println();
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