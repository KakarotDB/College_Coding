//  B. Collecting Game

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
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
            if (Long.compare(this.x, other.x) == 0)
                return Long.compare(this.y, other.y);
            return Long.compare(this.x, other.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Pair> a = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(new Pair(Long.parseLong(st.nextToken()), i));
            }
            long[] prefixSum = new long[n]; 
            Collections.sort(a);
            prefixSum[0] = a.getFirst().x;
            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + a.get(i).x;
            }
            long[] ans = new long[n];
            for (int i = 0; i < n; i++) {
                int j = i;
                int found = i;
                while (j < n) {
                    Pair temp = new Pair(prefixSum[j] + 1, Integer.MIN_VALUE);
                    int result = Collections.binarySearch(a, temp);
                    int index = result >= 0 ? result : (-(result + 1));
                    index--;
                    if (index == j)
                        break;
                    found += index - j;
                    j = index;
                }
                ans[(int) a.get(i).y] = found;
            }
            for (long an : ans) {
                pw.print(an + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}