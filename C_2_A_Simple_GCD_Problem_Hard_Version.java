import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class C_2_A_Simple_GCD_Problem_Hard_Version {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        
        String line = br.readLine();
        if(line == null) return;
        int t = Integer.parseInt(line.trim());
        
        test: 
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            List<Long> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Long.parseLong(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            List<Long> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                b.add(Long.parseLong(st.nextToken()));
            }

            long[] c = new long[n];
            
            for(int i = 0; i < n; i++) {
                if(i == 0) c[i] = gcd(a.get(i), a.get(i + 1));
                else if(i == n - 1) c[i] = gcd(a.get(i - 1), a.get(i));
                else c[i] = lcm(gcd(a.get(i), a.get(i - 1)), gcd(a.get(i), a.get(i + 1)));
                
                if(c[i] > b.get(i)) c[i] = a.get(i); 
            }

            long[] primes = new long[] {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73};
            int psize = primes.length;

            long[][] dp = new long[n][psize];
            
            
            // base cases
            for (int i = 0; i < psize; i++) {
                if (i == 0) {
                    if(c[0] == a.get(0)) dp[0][0] = 0;
                    else dp[0][0] = 1;
                    continue;
                }

                long val = c[0] * primes[i];

                if(val <= b.get(0) && gcd(val, c[1]) == gcd(a.get(0), a.get(1)) && val != a.get(0)) {
                    dp[0][i] = 1;
                }
            }

            // transitions
            for (int i = 1; i < n; i++) {
                long currentA = a.get(i);
                long prevA = a.get(i - 1);
                long maxB = b.get(i);
                long reqGcdPrev = gcd(currentA, prevA);
                long reqGcdNext = (i < n - 1) ? gcd(currentA, a.get(i + 1)) : 0;
                long currentC = c[i];
                long prevC = c[i - 1];
                long nextC = (i < n - 1) ? c[i + 1] : 0;

                for (int j = 0; j < psize; j++) {
                    if (j == 0) {
                        boolean isSame = (currentC == currentA);
                        for (int k = 0; k < psize; k++) {
                            if (isSame) {
                                dp[i][j] = Math.max(dp[i - 1][k], dp[i][j]);
                            } else {
                                dp[i][j] = Math.max(dp[i - 1][k] + 1, dp[i][j]);
                            }
                        }
                        continue;
                    }

                    long val1 = currentC * primes[j];

                    if (val1 > maxB || val1 == currentA) continue;
                    if (i < n - 1 && gcd(val1, nextC) != reqGcdNext) continue;

                    for (int k = 0; k < psize; k++) {
                        long val2 = prevC * primes[k];

                        if (gcd(val1, val2) == reqGcdPrev) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + 1);
                        }
                    }
                }
            } 
            
            long ans = 0;
            for (int j = 0; j < psize; j++) {
                ans = Math.max(ans, dp[n - 1][j]);
            }
            pw.println(ans);
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