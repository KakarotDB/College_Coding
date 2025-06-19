//  A. Forked!

import java.util.*;
import java.lang.*;

public class Main {
    public static class Pair {
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
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            long a = sc.nextLong();long b = sc.nextLong();
            long x_king = sc.nextLong();long y_king = sc.nextLong();
            long x_queen = sc.nextLong();long y_queen = sc.nextLong();
            long[] dx = {1,-1,-1,1}, dy = {1,1,-1,-1};
            Set<Pair> King_Hits = new HashSet<>();
            Set<Pair> Queen_Hits = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                King_Hits.add(new Pair(x_king + dx[i] * a , y_king + dy[i] * b));
                King_Hits.add(new Pair(x_king + dx[i] * b , y_king + dy[i] * a));

                Queen_Hits.add(new Pair(x_queen + dx[i] * a, y_queen + dy[i] * b));
                Queen_Hits.add(new Pair(x_queen + dx[i] * b, y_queen + dy[i] * a));
            }
            int answer = 0;
            for (Pair hits : King_Hits)
            {
                if (Queen_Hits.contains(hits))
                    answer++;
            }
            System.out.println(answer);

        }

    }
}