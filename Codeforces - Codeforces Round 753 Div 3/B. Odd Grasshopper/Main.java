//  B. Odd Grasshopper

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
//            int x0 = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x0 = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long final_pos;
            if (n % 4 == 0)
                final_pos = 0;
            else if (n % 4 == 1) {
                final_pos = -n;
            } else if (n % 4 == 2)
                final_pos = 1;
            else
                final_pos = n + 1;
            if (x0 % 2 == 0)
                pw.println(x0 +final_pos);
            else
                pw.println(x0 - final_pos);

        }
        pw.flush();
        pw.close();
        br.close();

    }
}