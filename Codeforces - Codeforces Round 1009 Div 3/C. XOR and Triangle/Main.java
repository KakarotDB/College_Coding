//  C. XOR and Triangle

import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            long x = Long.parseLong(br.readLine());
            if ((x & (x - 1)) == 0 || ((x + 1) & x) == 0)
                pw.println(-1);
            else {
                long p = 1L << (63 - Long.numberOfLeadingZeros(x));
                pw.println(p - 1);
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}