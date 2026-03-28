import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class C_Game_with_a_Fraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        /*
         * Note
         * If there is some cyclic shifts with a string s:
         * s += s can help in simplifying the problem
         * Suffix sum can be calculated using TotalSum - CurrentPrefixSum
         * Thinking in number lines can be helpful
         * If there is monoticity -> Binary Search may prove useful
         * 
         * Alice goes first
         * Alice and bob have two integers : p , q 
         * 
         * Eah turn, one of two actions : 
         * - p > 0 ? p-- : nothing
         * - q > 0 ? q-- : nothing 
         * 
         * if(p/q = 2/3) Bob wins 
         * else Alice wins  
         * 
         * So basically on each turn a player can 
         * choose to decrement p or q, depending on which one is 0, or 1 
         * if p is already 0, then cannot decrement further
         * so
         * min(p) = 0
         * min(q) = 1
         * 
         * We are given p and q, we need to find who wins 
         * 
         * 
         * Let's solve some examples 
         * 
         * p = 4, q = 6 
         * 4 6 p / q = 2 / 3 => Bob Wins 
         * 
         * 
         * 3p = 2q
         * 
         * p  q  3p 2q
         * ------------
         * 10 14 30 28 difference == 2  
         * 10 13 30 26 (Alice)
         * 9  13 27 26 (Bob)
         * 9  12 27 24 (Alice)
         * 8  12 24 24 (Bob) Alice loses!
         * 
         * 15 15 45 30 
         * 14 15 42 30 
         * 14 14 42 28
         * 
         * #Observation : Bob always wants to decrease the gap between 3p and 2q
         * But if the gap is too big initially, he cannot 
         * 
         * So let this gap G = 3p - 2q
         * Bob wants to make this 0 
         * Alice wants to make sure it doesn't become 0 
         * 
         * Let's see what happens on each action 
         * 
         * Decrementing p : G = 3p - 2q - 1 => G--
         * Decrementing q : G = 3p - 2(q - 1) => G+=2
         * 
         * G = 3p - 2q  
         * 
         * Transformation of problem: 
         * Bob wants to make G = 0, alice wants to make G != 0
         * So basically, alice wants to continue till p = 0, q = 1
         * G = - 2 * 1 = -2
         * G = -2
         * 
         * We need a mathematical formula
         * Even a log(n) answer works  (log(1e18) ~ 60)
         * 
         * G = 3p - 2q 
         * 
         * p = 15, q = 15 
         * G = 3 * 15 - 30 = 15 
         * G = 15 
         * p  q  G 
         * --------
         * 15 15 15 
         * 15 14 17 A
         * 14 14 14 B 
         * 14 13 16 A 
         * 13 13 13 B 
         * 13 12 15 A 
         * 12 12 12 B 
         * 12 11 14 A 
         * 11 11 11 B 
         * 11 10 13 A 
         * 10 10 10 B 
         *  
         * 
         *  
         *  
         *
         */
        test: 
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken());
            long q = Long.parseLong(st.nextToken());
            long gap = 3 * p - 2 * q;
            if (gap < 0) {
                pw.println("Alice");
                continue;
            }

            if (q > p) {
                pw.println("Bob");
            } else pw.println("Alice");
        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static class SegmentTree {
        int[] tree;
        int n;

        // Constructor 1: Supports int[]
        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 1, 0, n - 1);
        }

        // Constructor 2: Supports ArrayList
        public SegmentTree(List<Integer> list) {
            n = list.size();
            tree = new int[4 * n];
            build(list, 1, 0, n - 1);
        }

        // Build for int[]
        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(arr, 2 * node, start, mid);
                build(arr, 2 * node + 1, mid + 1, end);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        // Build for ArrayList (Overloaded)
        private void build(List<Integer> list, int node, int start, int end) {
            if (start == end) {
                tree[node] = list.get(start);
            } else {
                int mid = (start + end) / 2;
                build(list, 2 * node, start, mid);
                build(list, 2 * node + 1, mid + 1, end);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        // Update
        public void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
            } else {
                int mid = (start + end) / 2;
                if (start <= idx && idx <= mid) {
                    update(2 * node, start, mid, idx, val);
                } else {
                    update(2 * node + 1, mid + 1, end, idx, val);
                }
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        // Query
        public int query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }

        private int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return 0; // IDENTITY ELEMENT
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            int p1 = query(2 * node, start, mid, l, r);
            int p2 = query(2 * node + 1, mid + 1, end, l, r);

            return p1 + p2;
        }
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
        if (array == null || array.length <= 1)
            return true;

        for (int i = 0; i < array.length - 1; i++) {
            // compareTo returns > 0 if array[i] is greater than array[i+1]
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        if (list == null || list.size() <= 1)
            return true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(char[] array) {
        if (array == null || array.length <= 1)
            return true;

        for (int i = 0; i < array.length - 1; i++) {
            // Primitives use standard comparison operators
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}