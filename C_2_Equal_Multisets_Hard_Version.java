import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class C_2_Equal_Multisets_Hard_Version {
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
         * Same as previous problem, now arary is aribtrary instead, maybe sliding window still works(?)
         * 
         * So now it's no more a permutation :(((())))
         * 
         * Let us look at the sliding window once again 
         * 
         * let's say the one leaving the window and entering the window are different avlues 
         * ai != ai+k
         * 
         * Then the one leaving b's window, and entering b's window must also be the same to hold the property 
         * 
         * bi = ai, bi+k = ai+k (or -1 since it's flexible)
         * 
         * Array a still holds integers from 1 -> n, that's pretty neat 
         * 
         * now what if the entering and exiting values are the same ?? 
         * 
         * then bi == bi+k
         * 
         * 
         */
        test: 
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            List<Long> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                long val = Long.parseLong(st.nextToken());
                a.add(val);
            }
            List<Long> b = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                long val = Long.parseLong(st.nextToken());
                b.add(val);
            }

            boolean flag = true;

            //First checking which positions have the same value to make the chains
            for (int c = 0; c < k; c++) {
                boolean allSame = true;

                long firstVal = a.get(c);

                for (int i = c + k; i < n; i+=k) {
                    if (!a.get(i).equals(firstVal)) {
                        allSame = false;
                        break;
                    } 
                }

                if (!allSame) {
                    for (int i = c; i < n; i+=k) {
                        if (b.get(i) != -1L && !b.get(i).equals(a.get(i))) {
                            flag = false;
                            break;
                        } 
                        b.set(i, a.get(i));
                    }
                } else {
                    long reqB = -1;

                    for (int i = c; i < n; i+=k) {
                        if (b.get(i) != -1L) {
                            if (reqB == -1L) {
                                reqB = b.get(i);
                            } else if (reqB != b.get(i)) {
                                flag = false;
                                break;
                            }
                        } 
                    }

                    if (reqB != -1L) {
                        for (int i = c; i < n; i+=k) {
                            b.set(i, reqB); 
                        }
                    }

                }
            } 
            
            //secondly validating the first window 

            if(flag) {
                int[] freqA = new int[n + 1];

                for (int i = 0; i < k; i++) {
                    freqA[a.get(i).intValue()]++;
                }

                for (int i = 0; i < k; i++) {
                    if (b.get(i) != -1L) {
                        if (freqA[b.get(i).intValue()] == 0) {
                            flag = false;
                            break; 
                        }
                    freqA[b.get(i).intValue()]--;
                    }
                }
            }

            if (flag) {
                pw.println("YES");
            }
            else pw.println("NO");
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