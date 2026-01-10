//  C. Loyalty

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
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(a);
            long[] list = new long[n];

            long bonus = 0;
            long currentRemainder = 0;

            int low = 0;
            int high = n - 1;

            for (int i = 0; i < n; i++) {
                long pL = a[low];
                long pH =a[high];

                if (currentRemainder + pH >= x) {
                    bonus += pH;
                    list[i] = pH;
                    currentRemainder = (currentRemainder + pH) % x;
                    high--;
                }
                else {
                    list[i] = pL;
                    currentRemainder = currentRemainder + pL;
                    low++;
                }
            }
            pw.println(bonus);
            for (long l : list) {
                pw.print(l + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}