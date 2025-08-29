//  C. I Will Definitely Make It

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
            ;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Long> h = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                h.add(Long.parseLong(st.nextToken()));
            }
            long initial_position = h.get(k - 1);
            Collections.sort(h);
            int index = h.indexOf(initial_position);
            boolean check = true;
            for (int i = index; i < n - 1; i++) {
                if (h.get(i + 1) - h.get(i) > initial_position) {
                    check = false;
                    break;
                }
            }
            if (check)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}