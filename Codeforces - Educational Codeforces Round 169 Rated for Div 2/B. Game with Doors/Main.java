//  B. Game with Doors

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
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int L_intersection = max(l, L);
            int R_intersection = min(r, R);
            if (R_intersection < L_intersection)
                pw.println(1);
            else {
                int ans = R_intersection - L_intersection;
                if (l != L)
                    ans += 1;
                if (r != R)
                    ans +=1;
                pw.println(ans);
            }
        }
        pw.flush();
        pw.close();
        br.close();

    }
}