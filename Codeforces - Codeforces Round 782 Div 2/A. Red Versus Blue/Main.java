//  A. Red Versus Blue

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
            int red = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            StringBuilder s = new StringBuilder();
            int length_of_red = red / (blue + 1);
            int extra_red = red % (blue + 1);
            for (int i = 1; i <= blue + 1 ; i++) {
                s.append("R".repeat(Math.max(0, length_of_red)));
                if (extra_red > 0) {
                    s.append('R');
                    extra_red--;
                }
                if (i != blue + 1)
                    s.append('B');
            }
            pw.println(s);

        }
        pw.flush();
        pw.close();
        br.close();
    }
}