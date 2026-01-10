//  A: Warm Up

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
        int casE = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            boolean check = true;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b.add(Integer.parseInt(st.nextToken()));
                if (b.get(i) < a.get(i)) {
                    check = false;
                    break;
                }
            }
            Set<Integer> setA = new HashSet<>(a);
            for (int i = 0; i < n; i++) {
                if (!setA.contains(b.get(i))) {
                    check = false;
                    break;
                }
            }

            if (!check) {
                pw.println("Case #" + casE + ": -1");
                casE++;
                continue;
            }
            

            casE++;
        }
        pw.flush();
        pw.close();
        br.close();
    }
}