//  D. 1709

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            long[] b = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }
//            System.out.println("Arrays before sorting : ");
//            System.out.println("a = " + Arrays.toString(a));
//            System.out.println("b = " + Arrays.toString(b));
            ArrayList<Pair> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (a[j - 1] > a[j]) {
                        long temp = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = temp;
                        ans.add(new Pair(1, j ));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (b[j - 1] > b[j]) {
                        long temp = b[j];
                        b[j] = b[j - 1];
                        b[j - 1] = temp;
                        ans.add(new Pair(2, j));
                    }
                }
            }
//            System.out.println("Arrays after sorting : ");
//            System.out.println(Arrays.toString(a));
//            System.out.println(Arrays.toString(b));
            for (int i = 0; i < n; i++) {
                if (a[i] > b[i])
                    ans.add(new Pair(3, i + 1));
            }
            pw.println(ans.size());
            for (Pair an : ans) {
                pw.println(an.x + " " + an.y);
            }



        }
        pw.flush();
        pw.close();
        br.close();

    }
}