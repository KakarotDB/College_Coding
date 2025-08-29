//  B. Villagers

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
            long[] g = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                g[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(g);
            long cost = 0;
            for (int i = 0; i < n; i++) {
                if (n % 2 == 0) {
                    if (i % 2 != 0) cost += g[i];
                }
                else {
                    if (i % 2 == 0) cost += g[i];
                }
            }
            pw.println(cost);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}