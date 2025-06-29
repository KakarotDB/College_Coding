//  B. Monsters

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
            long k = Long.parseLong(st.nextToken());
            ArrayList<Pair> health_points = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                health_points.add(new Pair(Integer.parseInt(st.nextToken()), i+1));
            }
            for (int i = 0; i < n; i++) {
                health_points.get(i).x = health_points.get(i).x % k;
                if (health_points.get(i).x == 0)
                    health_points.get(i).x = k;
            }
            Collections.sort(health_points);
            for (Pair healthPoint : health_points) {
                pw.print(healthPoint.y + " ");
            }
            pw.println();
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
            int cmpx = Long.compare(other.x, this.x);
            if (cmpx == 0)
                return Long.compare(this.y, other.y);
            return cmpx;
        }
    }
}