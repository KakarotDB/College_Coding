//  C. Double Sort

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
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

//            int aDistinct = (int) Arrays.stream(a).distinct().count();
//            int bDistinct = (int) Arrays.stream(a).distinct().count();
            List<Pair> pairs = new ArrayList<>();
            BubbleSort(a, b, pairs);
            if (!isSorted(b)) {
                BubbleSort(b, a, pairs);
                if (isSorted(a)) {
                    pw.println(pairs.size());
                    for (Pair pair : pairs) {
                        pw.println(pair.x + " " + pair.y);
                    }
                }
                else
                    pw.println(-1);
            }
            else {
                pw.println(pairs.size());
                for (Pair pair : pairs) {
                    pw.println(pair.x + " " + pair.y);
                }
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static void BubbleSort(int[] array, int[] b, List<Pair> list) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                    list.add(new Pair(j + 1, j + 2));
                }
            }
        }
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

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}