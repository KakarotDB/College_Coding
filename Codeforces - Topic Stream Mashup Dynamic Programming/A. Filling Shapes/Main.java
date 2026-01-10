//  A. Filling Shapes

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int n = Integer.parseInt(br.readLine());
        if (n % 2 != 0)
            pw.println(0);
        else {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = 2 * dp[i - 2];
            }
            pw.println(dp[n]);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}