import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class C1SeatingArrangementEasyVersion {
    
    //list of first 20 primes whose product > 1e18
    static long[] primes = new long[]  {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73};
    static final long MOD = 0;
    // Moved to static class level
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringTokenizer st = new StringTokenizer("");

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            solve();
        }
        
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
         * if  '(' = + 1 and ')' = -1
         * then prefix sum >= 0 at each point 
         * 
         * XOR -> prefix XOR
         * p[i] ^ p[i - 1] = XOR(i, j)
         * a ^ b = c, then
         * a ^ c = b2
         * 
         * x tables -> s seats each 
         * 
         * three personalities : 
         * - I ntroverts -> empty table 
         * - E xtroverts -> non empty table 
         * - A mbiverts  -> any table 
         * 
         * seating happens sequentially one by one 
         * 
         * either assign or kick out 
         * 
         * maximum number of friends that we can have at the party 
         * 
         * once friend is seated, they cannot move, so we have to make sure that they can sit
         * 
         * Extroverts and ambiverst don't care which table they sit on
         * just needs to be non empty 
         * 
         * so all the empty tables can be considered as a pool of empty seats 
         * 
         * 
         * let the number of empty tables be j 
         * total number of people seated so far be k 
         * 
         * then, number of non empty tables = (x - j) 
         * total capacity = (x - j) * s 
         * 
         * k people are sitting in these so 
         * available seats AvalSeats = (x - j) * s - k 
         * 
         * so let us use dp 
         * 
         * dp[i] represents the maximum number of people that can be seated given i empty tables remaining
         * 
         * dp[1] -> 1 empty table remaining 
         * dp[x] -> x empty tables remaining 
         * 
         * So now, for each friend in the line we look at every possible state dp[i] and decide 
         * - skip them, state remains same 
         * - I -> can only sit if i > 0. Uses 1 empty table 
         * - E -> AvalSeats > 0 0 empty tables used 
         * - A -> whichever valid 
         * 
         * 
         * 
         * 
         * 
         * 
         */
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String u = br.readLine();

        int[] dp = new int[x + 1];
        Arrays.fill(dp, -1);

        dp[x] = 0;

        for (int i = 0; i < n; i++) {
            char c = u.charAt(i);

            int[] nextdp = new int[x + 1];
            Arrays.fill(nextdp, -1);
            for (int j = 0; j <= x; j++) {
                if (dp[j] == -1) {
                    continue;
                }

                int k = dp[j];

                int avalSeats = (x - j) * s - k;

                nextdp[j] = Math.max(nextdp[j], k);

                if (c == 'I') {
                    if(j > 0) nextdp[j - 1] = Math.max(nextdp[j - 1], k + 1);
                } else if (c == 'E') {
                    if (avalSeats > 0) {
                        nextdp[j] = max(nextdp[j], k + 1);
                    }
                }
                else if (c == 'A') {
                    if(j > 0) nextdp[j - 1] = max(nextdp[j - 1], k + 1);
                    if(avalSeats > 0) nextdp[j] = max(nextdp[j], k + 1);
                }
            }
            dp = nextdp;
        }
        int max = 0;
        for (int i = 0; i <= x; i++) {
            max = max(max, dp[i]);
        }

        pw.println(max);
        
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