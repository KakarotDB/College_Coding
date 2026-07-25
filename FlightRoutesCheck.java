import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class FlightRoutesCheck {

    // list of first 20 primes whose product > 1e18
    static long[] primes = new long[] { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73 };
    static final long MOD = 0;
    // Moved to static class level
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringTokenizer st = new StringTokenizer("");

    public static void main(String[] args) throws IOException {
            solve();

        pw.flush();
        pw.close();
        br.close();
    }

    public static void solve() throws IOException {
        /*
         * Note
         * If there is some cyclic shifts with a string s:
         * s += s can help in simplifying the problem
         * Suffix sum can be calculated using TotalSum - CurrentPrefixSum
         * Thinking in number lines can be helpful
         * If there is monoticity -> Binary Search may prove useful
         * For any RBS (Regular Bracket Sequence) of length n
         * Thre has to be n/2 '(' and ')'
         * if '(' = + 1 and ')' = -1
         * then prefix sum >= 0 at each point
         * To reduce the longest subequence of matched pairs of rbs 
         * we can reduce the maximum matched pairs 
         * now
         * Let maximum matched pairs be M
         * M = min (count of '(' in s[0, i -1] + count of ')' in s[i, n])
         * across all [1, n]
         * 
         * XOR -> prefix XOR
         * p[i] ^ p[i - 1] = XOR(i, j)
         * a ^ b = c, then
         * a ^ c = b
         */
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);  
            revAdj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(adj, visited, 1);

        for (int i = 1; i < n + 1; i++) {
            if(!visited[i]) {
                pw.println("NO");
                pw.println("1 " + i);
                return;
            }
        }

        visited = new boolean[n + 1];
        dfs(revAdj, visited, 1);

        for (int i = 1; i < n + 1; i++) {
            if(!visited[i]) {
                pw.println("NO");
                pw.println(i + " 1");
                return;
            }
        }

        pw.println("YES");
    }

    public static void dfs(List<List<Integer>> adj, boolean[] vis, int vertex) {
        vis[vertex] = true;

        for(int neighbour : adj.get(vertex)) {
            if(!vis[neighbour]) {
                dfs(adj, vis, neighbour);
            }
        }
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

    public static class InversionCounter {

        private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
            int i = left; // Pointer for left subarray
            int j = mid + 1; // Pointer for right subarray
            int k = left; // Pointer for merged array
            long invCount = 0;

            // Merge the two halves while counting inversions
            while (i <= mid && j <= right) {
                if (arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    // The core logic: arr[i] > arr[j]
                    // Everything from i to mid is strictly greater than arr[j]
                    temp[k++] = arr[j++];
                    invCount += (mid - i + 1);
                }
            }

            // Copy any remaining elements from the left subarray
            while (i <= mid) {
                temp[k++] = arr[i++];
            }

            // Copy any remaining elements from the right subarray
            while (j <= right) {
                temp[k++] = arr[j++];
            }

            // Transfer the sorted elements back to the original array
            for (i = left; i <= right; i++) {
                arr[i] = temp[i];
            }

            return invCount;
        }

        // Recursive merge sort function
        private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
            long invCount = 0;
            if (left < right) {
                int mid = left + (right - left) / 2;

                invCount += mergeSortAndCount(arr, temp, left, mid);
                invCount += mergeSortAndCount(arr, temp, mid + 1, right);
                invCount += mergeAndCount(arr, temp, left, mid, right);
            }
            return invCount;
        }

        // Wrapper function to initialize the temporary array
        public static long countInversions(int[] arr) {
            // initializing temp here ONCE to save memory and time
            int[] temp = new int[arr.length];
            return mergeSortAndCount(arr, temp, 0, arr.length - 1);
        }
    }

    // Fast exponentiation to calculate (base^exp) % mod
    public static long power(long base, long exp) {
        long res = 1;
        base = base % MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    // Finds the modular inverse using Fermat's Little Theorem
    public static long modInverse(long n) {
        return power(n, MOD - 2);
    }

    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
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

}
//    public static class Pair implements Comparable<Pair> {
//        long x, y;
//
//        Pair(long x, long y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public boolean equals(Object object) {
//            if (this == object)
//                return true;
//            if (!(object instanceof Pair pair))
//                return false;
//            return x == pair.x && y == pair.y;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
//
//        @Override
//        public int compareTo(Pair other) {
//            return Long.compare(this.x, other.x);
//        }
//    }
//
//    public static boolean isPrime(int n) {
//        if (n < 2)
//            return false;
//        if (n < 4)
//            return true;
//        if ((n & 1) == 0)
//            return false;
//        for (int i = 3; i * i <= n; i++)
//            if (n % i == 0)
//                return false;
//        return true;
//    }
//
//    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
//        if (array == null || array.length <= 1)
//            return true;
//
//        for (int i = 0; i < array.length - 1; i++) {
//            // compareTo returns > 0 if array[i] is greater than array[i+1]
//            if (array[i].compareTo(array[i + 1]) > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
//        if (list == null || list.size() <= 1)
//            return true;
//
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean isSorted(char[] array) {
//        if (array == null || array.length <= 1)
//            return true;
//
//        for (int i = 0; i < array.length - 1; i++) {
//            // Primitives use standard comparison operators
//            if (array[i] > array[i + 1]) {
//                return false;
//            }
//        }
//        return true;
//    }
//}