//  B. Triangles on a Rectangle

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
            long w = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long[] x_0 = new long[k];
            for (int i = 0; i < k; i++) {
                x_0[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            long[] x_h = new long[k];
            for (int i = 0; i < k; i++) {
                x_h[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            long[] y_0 = new long[k];
            for (int i = 0; i < k; i++) {
                y_0[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            long[] y_w = new long[k];
            for (int i = 0; i < k; i++) {
                y_w[i] = Long.parseLong(st.nextToken());
            }
            long max_top_base = abs(x_0[0] - x_0[x_0.length - 1]);
            long max_bottom_base = abs(x_h[0] - x_h[x_h.length - 1]);
            long max_right_base = abs(y_0[0] - y_0[y_0.length - 1]);
            long max_left_base = abs(y_w[0] - y_w[y_w.length - 1]);
            long top_area = max_top_base * h;
            long bottom_area = max_bottom_base * h;
            long left_area = max_left_base * w;
            long right_area = max_right_base * w;
            pw.println(max(top_area, max(bottom_area, max(left_area, right_area))));

        }
        pw.flush();
        pw.close();
        br.close();
    }

}