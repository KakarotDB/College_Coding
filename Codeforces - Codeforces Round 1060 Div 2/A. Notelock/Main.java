//  A. Notelock

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
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();

            int last = -k;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    if (last < i - k + 1) {
                        count++;
                    }
                     last = i;
                }
            }
            pw.println(count);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}