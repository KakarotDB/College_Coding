//  A. Shashliks

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
            long k = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            if (x > y) {
                long temp = y;
                y = x;
                x = temp; //swapping x, y

                temp = b;
                b = a;
                a = temp; //swapping a,b
            }
            long diffa = k - a;
            long ans = 0;
            if (diffa >= 0) {
                ans = diffa / x + 1;
                k -= ans * x;
            }
            long diffb = k - b;
            if (diffb >= 0){
                ans += diffb/y + 1;
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}