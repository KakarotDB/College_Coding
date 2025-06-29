//  B. Square Pool

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
            long n = Long.parseLong(st.nextToken()), s = Long.parseLong(st.nextToken());
            long count = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                long tx = dx == 1 ? s - x : x;
                long ty = dy == 1 ? s - y : y;
                if (tx == ty)
                    count++;
            }
            pw.println(count);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}