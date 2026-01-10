//  D. Yet Another Array Problem

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    static final int[] PRIMES_TO_CHECK = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        testCaseLoop:
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long count1s = Arrays.stream(a).filter(ch -> ch == 1).count();
            if (count1s >= 1) {
                pw.println(2);
                continue;
            }

            for (int i : PRIMES_TO_CHECK) {
                long current = i;

                boolean check = true;

                for (int j = 0; j < n; j++) {
                    if (a[j] % i != 0) {
                        check = false;
                        break;
                    }
                }
                if (!check) {
                    pw.println(current);
                    continue testCaseLoop;
                }
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}