//  B. Luke is a Foodie

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            ArrayList <Pair> segments = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                segments.add(new Pair(a[i] - x, a[i] + x));
            }
            long ans = 0;
            long l = segments.getFirst().x;
            long r = segments.getFirst().y;
            for (int i = 1; i < n; i++) {
                l = max(l, segments.get(i).x);
                r = min(r, segments.get(i).y);
                if (l > r){
                    ans++;
                    l = segments.get(i).x;
                    r = segments.get(i).y;
                }
            }
//            for (Pair segment : segments) {
//                pw.println("Pair : " + segment.x + " " + segment.y);
//            }
            pw.println(ans);


        }
        pw.flush();
        pw.close();
        br.close();
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
}