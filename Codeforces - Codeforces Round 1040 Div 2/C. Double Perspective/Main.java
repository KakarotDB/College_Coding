//  C. Double Perspective

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
            Map<Integer, int[]> map = new TreeMap<>();
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int ai = Integer.parseInt(st.nextToken());
                int bi = Integer.parseInt(st.nextToken());
                if (!map.containsKey(ai)) map.put(ai, new int[] {bi, i});
                else if (map.get(ai)[0] < bi) map.put(ai, new int[] {bi, i});
            }
            pw.println(map.size());
            for (int[] value : map.values()) {
                pw.print(value[1] + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();

    }
}