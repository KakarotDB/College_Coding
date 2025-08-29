//  D. Stay or Mirror

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
            ArrayList<Integer> p = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p.add(Integer.parseInt(st.nextToken()));
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                int index = p.indexOf(i);
                ans += min(index, p.size() - index - 1);
                p.remove(index);
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}