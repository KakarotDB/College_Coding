//  B. Catching the Krug

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
            long n = Long.parseLong(st.nextToken());
            long rk = Long.parseLong(st.nextToken());
            long ck = Long.parseLong(st.nextToken());
            long rd = Long.parseLong(st.nextToken());
            long cd = Long.parseLong(st.nextToken());

            long dx = abs(rk - rd);
            long dy = abs(ck - cd);

            long x = 0;
            long y = 0;
            if (rd < rk)
                x = n - rk;
            else if (rd > rk)
                x = rk;

            if (cd < ck)
                y = n - ck;
            else if (cd > ck)
                y = ck;
            pw.println(max(dx + x, dy + y));
        }
        pw.flush();
        pw.close();
        br.close();
    }
}