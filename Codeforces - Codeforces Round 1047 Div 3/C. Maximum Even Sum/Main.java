//  C. Maximum Even Sum

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (b % 2 != 0) {
                if (a % 2 != 0)
                    pw.println(a * b + 1L);
                else
                    pw.println(-1);
            } else if (a % 2 != 0) {
                if (b % 4 == 2)
                    pw.println(-1);
                else
                    pw.println(a * b / 2L + 2L);
            }
            else {
                pw.println(a * b / 2L + 2L);
            }


        }
        pw.flush();
        pw.close();
        br.close();

    }
}