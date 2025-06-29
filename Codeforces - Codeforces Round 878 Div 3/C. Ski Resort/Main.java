//  C. Ski Resort

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
            long q = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                if (a[i] > q)
                    a[i] = 0;
                else 
                    a[i] = 1;
            }
//            System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
            int count = 0;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 1){
                    count++;
                }
                else {
                    if (count >= k) {
                        ans += (long) (count - k + 1) * (count - k + 2) / 2;
                    }
                    count = 0;
                }
            }
            if (count >= k) {
                ans += (long) (count - k + 1) * (count - k + 2) / 2;
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}