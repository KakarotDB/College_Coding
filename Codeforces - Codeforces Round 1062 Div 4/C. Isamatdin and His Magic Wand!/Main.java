//  C. Isamatdin and His Magic Wand!

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
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((a[i] & 1) == 1)
                    odd.add(a[i]);
                else
                    even.add(a[i]);
            }

            if (odd.isEmpty() || even.isEmpty()) {
                for (int i = 0; i < n; i++) {
                    pw.print(a[i] + " ");
                }
                pw.println();
                continue;
            }

            Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                pw.print(a[i] + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}