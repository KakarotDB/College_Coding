// B. Prefix Sum Addicts

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
            int k = Integer.parseInt(st.nextToken());
            List<Long> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                a.add(Long.parseLong(st.nextToken()));
            }
            /*
            We are given the last k terms of the prefix sum
            we have to determine if the last k terms are possible given the number of terms
            in the original array = n
            yes/no
            validation problem
            The original sequence must also be sorted
            n = 3, k = 3
            5 6 7
            5 1 1 -> no

            n = 6, k = 3
            5 6 7

            n = 5, k = 5
            1 2 3 4 5
            1 1 1 1 1 -> yes

            n == k:
                n = 3, k = 3
                1 3 5
                1 2 2 -> yes

                2 3 4
                2 1 1 -> no

                2 6 11
                2 4 5 -> yes

                #Observation : Add first element -> check abs diff between next and prev -> build
                if sorted -> yes

            n = 3, k = 2
            3 4
            1 2 1
             */
            if (k == 1) {
                pw.println("Yes");
                continue;
            }
            List<Long> seq = new ArrayList<>();
//            seq.add(a.getFirst());
            for (int i = 1; i < k; i++) {
                seq.add((a.get(i) - a.get(i - 1)));
            }
            if (!isSorted(seq)) {
                pw.println("No");
                continue;
            }
            /*
            Now we have a sorted array with prefix sums
            We have to see if the first element is possible as all the other elements are possible
            seq.getFirst()
            last k elements, so first elements are n - k in no.

            n = 7, k = 4
            -6 1 2 3
            -6 -> n - k = 7 - 4 = 3
            a1 + a2 + a3 + a4 = -6
            Sn-k+1 = seq.getFirst()

            Sum of first n - k + 1 terms = seq.getFirst()
            It is also sorted
            a1<=a2<=a3<=a4<=a5
            a5 = 1, a6 = 2, a7 = 3
            maximum possible sum = (n - k + 1) * (seq.get(1)

             */
            Long sum = a.getFirst();
            if (sum > (n - k + 1) * seq.getFirst()) pw.println("No");
            else pw.println("Yes");
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