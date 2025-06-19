//  B. Sum of Medians

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long[] a = new long[n * k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n * k; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long ans = 0;
            int pointer = n * k;
            while (k-- > 0){
                pointer -= (n / 2 + 1);
                ans+=a[pointer];
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}