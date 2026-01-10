// C. A-B Palindrome

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
        int t = Integer.parseInt(br.readLine());
        /* 
        Note
        If there is some cyclic shifts with a string s:
        s += s can help in simplifying the problem  
        */
        test:
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            int count1 = (int) s.chars().filter(ch -> ch == '1').count();
            int count0 = (int) s.chars().filter(ch -> ch == '0').count();
            int countQ = (int) s.chars().filter(ch -> ch == '?').count();
            int n = a + b;
            int ac = a;
            int bc = b;
            StringBuilder ans = new StringBuilder(s);
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != '?' && s.charAt(n - i - 1) != '?' && s.charAt(i) != s.charAt(n - i - 1)) {
//                    pw.println(s);
                    pw.println(-1);
                    continue test;
                }
            }
            a-=count0;
            b-=count1;
            for (int i = 0; i < n; i++) {
                if (ans.charAt(i) != '?' && ans.charAt(n - i - 1) == '?') {
                    char val = ans.charAt(i);
                    ans.setCharAt(n - i - 1 , val);
                    if (val == '0') a--;
                    else b--;
                }
            }
            for (int i = 0; i < n; i++) {
                if (ans.charAt(i) == '?') {
                    if (a >= 2) {
                        ans.setCharAt(i, '0');
                        ans.setCharAt(n - i - 1, '0');
                        a -= 2;
                    }
                    else if (b >= 2) {
                        ans.setCharAt(i, '1');
                        ans.setCharAt(n - i - 1, '1');
                        b -= 2;
                    }
                }
            }
            if (n % 2 == 1 && ans.charAt(n / 2) == '?') {
                if (a > 0) ans.setCharAt(n / 2, '0');
                else ans.setCharAt(n / 2, '1');
            }
            for (int i = 0; i < n; i++) {
                if (ans.charAt(i) == '?') {
                    pw.println(-1);
                    continue test;
                }
            }
            count1 = (int) ans.chars().filter(ch -> ch == '1').count();
            count0 = (int) ans.chars().filter(ch -> ch == '0').count();
            if (bc != count1 || ac != count0) {
                pw.println(-1);
                continue test;
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
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
        }
        else if (array instanceof Collection<?>) {
            for (Object o : (Collection<?>) array) {
                pw.print(o + " ");
            }
            pw.println();
        }
        else
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