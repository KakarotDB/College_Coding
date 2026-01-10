//  A. Round Trip

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
            long r0 = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            String s = br.readLine();
            long count = 0;

            if (r0 < x) {
                pw.println(n);
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1'){
                    count++;
                    r0 = r0 - d;
                }
                else {
                    if (r0 < x) {
                        count++;
                        r0 = r0 -d;
                    }
                }
            }
            pw.println(count);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}