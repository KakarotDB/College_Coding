// D1. Sub-RBS (Easy Version)

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
        test:
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            /*
            n is even
            Given a regular bracket sequence

            a is better than b if :
                b is a prefix of a, but a != b
                OR
                i -> first position where ai != bi, then ai = (, bi = )
                So, where first positions differ, a! =(, bi = )

            We have been given string s which is a regular bracket sequence

            We have to determine whether there exists some subsequence t such that
            t better than s
            Maximum possible length of t

            s = ():
                only possible t = (), -1

            s = (()(())):
            t = ((())), length = 6
                  | ti = (, si = ), thus t better than s

            s = ()()()()
            t = (()())

            s = ((()))

            s = (())()

            Find the first index i such that s[i] = ), s[i+1] = (
            Then, see if we have an index later on after i + 1 such that we get another  (
            If these two satisfy -> ans  = n - 2
             */

            int index = -1;

            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == ')' && s.charAt(i + 1) == '(') {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                pw.println(-1);
                continue test;
            }
            int index1 = -1;
//            pw.println(index);
            for (int i = index + 2; i < n; i++) {
                if (s.charAt(i) == '(') {
                    pw.println(n - 2);
                    continue test;
                }
            }
            pw.println(-1);
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