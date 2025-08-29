//  C. Leftmost Below

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
            long[] b = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean ans = true;
            long smol = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
                if (b[i] >= 2 * smol) ans = false;
                smol = min(smol, b[i]);
            }
            pw.println(ans ? "YES" : "NO");

        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static boolean isDescending(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1])
                return false;
        }
        return true;
    }
}