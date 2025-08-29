//  A. Three Decks

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
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if ((a + b + c) % 3 != 0)
                pw.println("NO");
            else {
                long x = (a + b + c) / 3;
                if (b <= x)
                    pw.println("YES");
                else
                    pw.println("NO");
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}