// C. Needle in a Haystack

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int T = Integer.parseInt(br.readLine());
        test:
        while (T-- > 0) {
            String s = br.readLine();
            String t = br.readLine();
            int n = s.length();
            int m = t.length();
            int[] smap = new int[26];
            int[] tmap = new int[26];

            for (int i = 0; i < n; i++) {
                smap[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < m; i++) {
                tmap[t.charAt(i) -'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (smap[i] > tmap[i]) {
                    pw.println("Impossible");
                    continue test;
                }
            }

            for (int i = 0; i < n; i++) {
                tmap[s.charAt(i) - 'a']--;
            }
            List<Character> ch = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < tmap[i]; j++) {
                    ch.add((char) (i + 'a'));
                }
            }
            Collections.sort(ch);
//            pw.println(Arrays.toString(ch.toArray()));
            StringBuilder ans = getAns(n, ch, s);
            pw.println(ans.toString());
        }
        pw.flush();
        pw.close();
        br.close();

    }

    private static StringBuilder getAns(int n, List<Character> ch, String s) {
        StringBuilder ans = new StringBuilder();
        int l = 0, r = 0;
        while (l < n && r < ch.size()) {
            if (s.charAt(l) <= ch.get(r)) {
                ans.append(s.charAt(l));
                l++;
            }
            else {
                ans.append(ch.get(r));
                r++;
            }
        }
        while (l < n) {
            ans.append(s.charAt(l));
            l++;
        }
        while (r < ch.size()) {
            ans.append(ch.get(r));
            r++;
        }
        return ans;
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
}