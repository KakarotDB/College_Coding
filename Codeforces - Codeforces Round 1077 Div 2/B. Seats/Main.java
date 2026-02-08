// B. Seats

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
        Thinking in number lines can be helpful

        n seats
        students cannot sit next to each other

        0000100001000
        0000100101000

        0 0 0 0
        0 0 0 0 0 0 0
        1 0 0 1 0 0 1
        1 0 0 1


        Let's look at gaps

        Boundary gaps :
            0 0 0 0 0 ..... 0 0 0 0 0
            how many can we fit into the boundaries ?
            0 1 0 ..... 0 1 0 -> can't fit any
            gap_size = size till reaching first 1
            gap_size = 1 -> 0
            0 0 1
            gap_size = 2 -> 1
            0 0 0 1, gap_size = 3 -> 1
            0 0 0 0 1 gap_size = 4 -> 1
            0 0 0 0 0 1 gap_size = 5 -> 2
            0 0 0 0 0 0 0 0 1 gap_size = 8 -> 3
            so it's gap_size / 3
            add extra if gap_size % 3 == 2

            Similar for right gap
            ...1 0 0 0 0 0


        Now for internal gaps :
            1 0 1 => 0
            1 0 0 1 -> 0
            1 0 0 0 1 -> 1
            1 0 0 0 0 1 -> 1
            1 0 0 0 0 0 1 -> 1
            1 0 2 0 1 0 0 1 -> 2
            So just gapSize / 3 

        */
        test:
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            List<Integer> seatedIdx = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') seatedIdx.add(i);
            }

            int currentStudents = seatedIdx.size();

            if (currentStudents == 0) { //no students seated
                pw.println((n + 2) / 3);
                continue;
                //ceil (n / 3)
            }
            int add = 0;
            int leftGap = seatedIdx.getFirst(); //first 1 gives us length of leftGap
            add += leftGap / 3;
            if (leftGap % 3 == 2) add++;
            int rightGap = n - 1 - seatedIdx.getLast();
            add += rightGap / 3;
            if (rightGap % 3 == 2) add++;

            for (int i = 0; i < currentStudents - 1; i++) {
                int gap = seatedIdx.get(i + 1) - seatedIdx.get(i) - 1;
                add += gap / 3;
            }
            pw.println(currentStudents + add);
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