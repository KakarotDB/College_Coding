//  D. Retaliation

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t-->0)
        {
            int n = Integer.parseInt(bufferedReader.readLine());
            long[] array = new long[n];
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            long op2_numerator = 2L * array[0]-array[1];
            long denominator = (long)n + 1;
            if (op2_numerator < 0 || op2_numerator % denominator != 0) {
                System.out.println("NO");
                continue;
            }
            long op2 = op2_numerator/denominator;
            long op1 = array[0] - op2*n;
            if (op1 < 0) {
                System.out.println("NO");
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                long exp = op1 * (i+1L) + op2*(n-i);
                if (array[i] != exp)
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");

        }

    }
}