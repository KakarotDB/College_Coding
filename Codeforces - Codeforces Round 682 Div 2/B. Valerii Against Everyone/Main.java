//  B. Valerii Against Everyone

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
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }
            int distinct =(int) Arrays.stream(b).distinct().count();
            if (distinct == n)
                pw.println("NO");
            else
                pw.println("YES");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}