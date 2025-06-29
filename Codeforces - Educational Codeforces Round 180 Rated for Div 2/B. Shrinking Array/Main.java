//  B. Shrinking Array

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
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            if (isSorted(a) || isDescending(a)) {
                long min_diff = Integer.MAX_VALUE;
                for (int i = 1; i < n; i++) {
                    long current_diff = abs(a[i] - a[i - 1]);
                    min_diff = min(current_diff, min_diff);
                }
                if (min_diff <= 1)
                    pw.println("0");
                else
                    pw.println("-1");
            }
            else {
                long min_diff = Integer.MAX_VALUE;
                for (int i = 1; i < n; i++) {
                    long current_diff = abs(a[i] - a[i - 1]);
                    min_diff = min(current_diff, min_diff);
                }
                if(min_diff <= 1)
                    pw.println(0);
                else
                    pw.println(1);

            }

        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static boolean isSorted(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public static boolean isDescending(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1])
                return false;
        }
        return true;
    }
}