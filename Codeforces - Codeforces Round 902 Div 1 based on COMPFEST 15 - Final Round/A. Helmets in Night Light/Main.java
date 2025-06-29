//  A. Helmets in Night Light

import java.awt.*;
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
            int p = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Pair> resident = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                resident.add(new Pair(b[i], a[i]));
            }
            Collections.sort(resident);
            long minimum_cost = p;
            long shared = 1;
            for (Pair pair : resident) {
                long can_be_shared = pair.y;
                long sharing_cost = pair.x;
                if (sharing_cost >= p)
                    break;
                if (shared + can_be_shared > n){
                    minimum_cost += (n-shared) * sharing_cost;
                    shared = n;
                    break;
                }
                else {
                    minimum_cost += can_be_shared * sharing_cost;
                    shared += can_be_shared;
                }


            }
            minimum_cost += (n - shared) * p;
            pw.println(minimum_cost);
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