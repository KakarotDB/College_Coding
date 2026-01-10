// C. Odd Process

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
            List<Long> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Long.parseLong(st.nextToken()));
            }
            Collections.sort(a);
            Collections.reverse(a);
            List<Long> even = new ArrayList<>();
            List<Long> odd = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a.get(i) % 2 == 0) even.add(a.get(i));
                else odd.add(a.get(i));
            }
            int evenCount = even.size();
            int oddCount = odd.size();
            if (oddCount == 0) {
                for (int i = 0; i < n; i++) {
                    pw.print("0 ");
                }
                pw.println();
                continue;
            }
            if (oddCount == 1) {
                pw.print(odd.getFirst() + " ");
                long sum = odd.getFirst();
                for (Long l : even) {
                    pw.print((sum += l) + " ");
                }
                pw.println();
                continue;
            }
            if (oddCount == n) {
                int[] arr = new int[n];
                for (int i = 0; i < n; i += 2) {
                    arr[i] = odd.getFirst().intValue();
                }
                for (int i : arr) {
                    pw.print(i + " ");
                }
                pw.println();
                continue;
            }
            pw.print(odd.getFirst() + " ");
            long sum = odd.getFirst();
            for (Long aLong : even) {
                pw.print((sum += aLong) + " "); //processed up to the maximum score we could get
            }
            if (oddCount % 2 != 0) {
                for (int i = 0; i < oddCount - 1; i++) {
                    pw.print(((i & 1) == 0 ? sum - even.getLast() : sum) + " ");
                }
            } else {
                for (int i = 0; i < oddCount - 2; i++) {
                    pw.print(((i & 1) == 0 ? sum - even.getLast() : sum) + " ");
                }
                pw.print("0");
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