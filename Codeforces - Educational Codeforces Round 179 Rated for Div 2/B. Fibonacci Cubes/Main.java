//  B. Fibonacci Cubes

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
            int m = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                int length = fibonacci(n);
                int width = fibonacci(n);
                int height = fibonacci(n) + fibonacci(n - 1);
                if (length <= l && width <= w && height <= h)
                    pw.print(1);
                else if(length <= w && width <= h && height <= l)
                    pw.print(1);
                else if(length <= h && width <= l && height <= w)
                    pw.print(1);
                else
                    pw.print(0);
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
    public static int fibonacci(int n) {
        if (n == 1) return n;
        if (n == 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static long fibonacci_With_Memoization(int n, long[] memo) {
        long result = 0;
        if (memo[n] != 0)
            return memo[n];
        if (n == 1 || n == 2)
            result = 1;
        else
            result = fibonacci_With_Memoization(n - 1, memo) + fibonacci_With_Memoization(n - 2, memo);

        memo[n] = result;
        return result;
    }
}