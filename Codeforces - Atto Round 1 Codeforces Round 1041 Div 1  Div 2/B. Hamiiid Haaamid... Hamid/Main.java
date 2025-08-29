//  B. Hamiiid, Haaamid... Hamid?

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
            int x = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            if (x == 1 || x == n){
                pw.println(1);
                continue;
            }
            x--;
            int inf = Integer.MAX_VALUE;
            int lf = -inf;
            int rg = inf;
            for (int i = x - 1; i >= 0; i--) {
                if (s.charAt(i) == '#'){
                    lf = i;
                    break;
                }
            }
            for (int i = x + 1; i < n; i++) {
                if (s.charAt(i) == '#'){
                    rg = i;
                    break;
                }
            }
            if (lf == -inf && rg == inf) {
                pw.println(1);
                continue;
            }
            pw.println(max(min(x + 1, n - rg + 1), min(lf + 2, n -x)));
        }
        pw.flush();
        pw.close();
        br.close();
    }
}