//  B. Good Start

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
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());
            
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());

            long diff_x = abs(x2 - x1);
            long diff_y = abs(y2 - y1);

            if((diff_x != 0 && diff_x % a == 0) || (diff_y != 0 && diff_y % b == 0))
                pw.println("Yes");
            else
                pw.println("No");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}