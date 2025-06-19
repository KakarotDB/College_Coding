//  B. Make It Increasing

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
            long ans = 0;
            for (int i = n - 1; i >= 1; i--) {
                while (a[i] <= a[i - 1]) {
                    ans++;
                    a[i - 1] /= 2;
                    if (a[i - 1] == 0)
                        break;
                }
                if (a[i] == 0 && a[i - 1] == 0){
                    ans = -1;
                    break;
                }
            }
            pw.println(ans);

        }
        pw.flush();
        pw.close();
        br.close();

    }

    public static boolean isSorted(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1])
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