//  B. Siga ta Kymata

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
        test:
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            String x = br.readLine();
            StringBuilder s = new StringBuilder("0".repeat(n));
            int idxMin = a.indexOf(1);
            int idxMax = a.indexOf(n);
            if (x.charAt(0) == '1' || x.charAt(n - 1) == '1' || x.charAt(idxMin) == '1' || x.charAt(idxMax) == '1') {
                pw.println(-1);
                continue;
            }
            else {
                pw.println(5);
                idxMin++;
                idxMax++; 
                pw.println(1 + " " + idxMax);
                pw.println(1 + " " + idxMin);
                pw.println(idxMin + " " + n);
                pw.println(idxMax + " " + n);
                pw.println(min(idxMin, idxMax) + " " + max(idxMin, idxMax));
            }

        }
        pw.flush();
        pw.close();
        br.close();
    }

}