//  B. Transfusion

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
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            ArrayList<Long> even = new ArrayList<>();
            List<Long> odd = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0)
                    even.add(a[i]);
                else
                    odd.add(a[i]);
            }
            long sumOdd = 0;
            long sumEven = 0;
            for (Long value : even) {
                sumEven += value;
            }
            for (Long aLong : odd) {
                sumOdd += aLong;
            }
            if (sumOdd / odd.size() == sumEven / even.size() && sumOdd % odd.size() == 0 && sumEven % even.size() == 0)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}