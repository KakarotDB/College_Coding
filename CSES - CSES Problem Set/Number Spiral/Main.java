//  Number Spiral

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
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            if (y > x) {
                if (y % 2 == 1) {
                    pw.println((y-1)*(y-1) + x);
                } else {
                    pw.println(y * y - (x - 1));
                }
            } else {
                if (x % 2 == 0)
                    pw.println((x - 1) * (x - 1) + y);
                else
                    pw.println(x * x - (y-1));
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}