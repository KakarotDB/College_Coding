//  A. Buying Torches

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
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long sticks = (k * (1 + y) - 1 + x - 2) / (x - 1);
            long total_trades = sticks + k;
            pw.println(total_trades);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}