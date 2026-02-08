// B. Tanya and Candies

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int n = Integer.parseInt(br.readLine());
        /* 
        Note
        If there is some cyclic shifts with a string s:
        s += s can help in simplifying the problem

        ith candy has weight ai
        Eat exactly n-1 candies and give the remaining to dad
        Tanya eats exactly one candy per day in order of increasing their numbers

        Find good candies i such that :
            if dad gets ith candy, then the sum of weights of candies tanya eats
            in even days will be equal to sum of candies tanya eats in odd days
            At first, she will give the candy, then eat.

            So:
            odd weight sum = even weight sum


        Example:
            n = 4, candy weights : [1, 4, 3, 3]

            dad = 1, odd = 4 + 3 = 7, even = 3, no good
            dad = 4, odd = 1 + 3 = 4, even = 3, no good
            dad = 3, odd = 1 + 3 = 4, even = 4, good
            dad = 3, good
            two candies -> ans = 2

        [1 2 3 4 5 6 7]
        all distinct == no good

        [1 1 1 1 1]
        dad = 1, 4 candies are good cuz they are all same

        [1 1 1 1 1 1]
        dad = 1, no good candy

        We can try directly calculating sums

        [a1 a2 a3 a4 a5 a6]
        maintain suffix and prefix sums for odd indices

        */

        List<Long> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Long.parseLong(st.nextToken()));
        }
        long[] odd = new long[n];
        long[] even = new long[n];
        odd[0] = 0;
        even[0] = a.getFirst();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            odd[i] = odd[i - 1];
            even[i] = even[i - 1];

            if (i % 2 != 0) odd[i] += a.get(i);
            else even[i] += a.get(i);
        }

        long totalOdd = odd[n - 1];
        long totalEven = even[n - 1];

        for (int i = 0; i < n; i++) {
            long oddLeft = (i == 0) ? 0: odd[i - 1];
            long evenLeft = (i == 0) ? 0: even[i - 1];

            long oddRight = totalOdd - odd[i];
            long evenRight = totalEven - even[i];

            long newOddSum = oddLeft + evenRight;
            long newEvenSum = evenLeft + oddRight;

            if (newOddSum == newEvenSum) ans++;
        }
        pw.println(ans);
        /*
        When choosing certain index i = dad index
        all elements to the left of i remain the same
        all elements to the right of i shift by one place
        so NewOddSum = Sum_Odd_before_i + sum_even_after_i
           newEvenSum = sum_even_before_i + sum_odd_after_i
         */

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