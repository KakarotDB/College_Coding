// D. Robert Hood and Mrs Hood

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
        Suffix sum can be calculated using TotalSum - CurrentPrefixSum

        1 -> n : numbered days
        Robin has 'k' risky jobs planned
        ith job takes place between days li and ri inclusive
        for all i belonging to [1, k], if a job takes place on any of the d days
        the visit overlaps with this job (don't care about length of overlap)

        Robin wants his brother's visit to overlap with maximum number of distinct jobs
        and his mother's the minimum

        Goal : Find suitable days for visits for mom and brother
        Choose the earliest suitable day

        Example:
            n = 5, d = 2, k = 2
            Job 1 : [1, 2]
            Job 2: [2, 3]

            Start day 1:
                Overlaps with job1, and job2 : Score = 2

        Basically we have to choose a starting day for brother and mother
        Brother : Make sure max overlap
        Mother : Make sure min overlap

        Naive solution : Check every day manually -> O(n*k)

        Example :
            n = 7, d = 2, k = 3
            Job 1 : [1, 2]
            Job 2 : [1, 3]
            Job 3 : [6, 7]

            Days: 1 2 3 4 5 6 7
            d = 2 days duration of visit for brother and mother
            If we choose visiting day = 1, we get two overlapping jobs, Job 1 and Job 2
            If we choos day = 4, we got no overlapping jobs

                Job 2
              |-----|
              |Job 1|          Job 3
              |---  |         ---
            --|--|--|--|--|--|--|--
              1  2  3  4  5  6  7

              We need segments of length d-1 which :
              Have max overlap, have min overlap

        */
        test:
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<Pair> jobs = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                jobs.add(new Pair(l, r));
            }
            int max = 0, min = Integer.MAX_VALUE, b = -1, m = -1;
            int j = 0;
            Collections.sort(jobs);
            Queue<Long> pq = new PriorityQueue<>();
            for (int i = 1; i < n - d + 2; i++) {
                int currEnd = i + d - 1;

                while (j < k && jobs.get(j).x <= currEnd) {
                    pq.add(jobs.get(j).y); j++;
                }
                while (!pq.isEmpty() && pq.peek() < i) pq.poll();

                int count = pq.size();
                if (count > max) {
                    max = count;
                    b = i;
                }
                if (count < min) {
                    min = count;
                    m = i;
                }
            }
            pw.println(b + " " + m);
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