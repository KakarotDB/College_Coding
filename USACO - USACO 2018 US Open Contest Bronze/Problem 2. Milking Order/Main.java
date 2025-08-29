//  Problem 2. Milking Order

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] hierarchy = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            hierarchy[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[] order = new int[n];
        Arrays.fill(order, -1);
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken()) - 1;
            int pos = Integer.parseInt(st.nextToken()) - 1;
            order[pos] = cow;
            if (cow == 0) {
                pw.println(pos + 1);
                pw.close();
                System.exit(0);
            }
        }
        for (int i = 0; i < n; i++) {
            if (order[i] == -1) {
                order[i] = 0;
                if (check(order, hierarchy)) {
                    pw.println(i + 1);
                    break;
                }
                order[i] = -1;
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static boolean check(int[] order, int[] hierarchy) {
        order = order.clone();
        int[] cowToPos = new int[order.length];
        Arrays.fill(cowToPos, -1);
        for (int i = 0; i < order.length; i++) {
            if (order[i] != -1) cowToPos[order[i]] = i;
        }
        int hIdx = 0;
        for (int i = 0; i < order.length && hIdx < hierarchy.length; i++) {
            if (cowToPos[hierarchy[hIdx]] != -1) {
                if (i > cowToPos[hierarchy[hIdx]])
                    return false;
                i = cowToPos[hierarchy[hIdx]];
                hIdx++;
            }
            else {
                while (i < order.length && order[i] != -1) i++;
                if (i == order.length) return false;
                order[i] = hierarchy[hIdx];
                cowToPos[hierarchy[hIdx]] = i;
                hIdx++;
            }
        }
        return true;
    }
}