//  C. XOR LCM

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
            long c = Long.parseLong(br.readLine());
            long setHighest = 63 - Long.numberOfLeadingZeros(c);
            pw.println(c + " " + (c << setHighest + 1));
        }
        pw.flush();
        pw.close();
        br.close();
    }
}