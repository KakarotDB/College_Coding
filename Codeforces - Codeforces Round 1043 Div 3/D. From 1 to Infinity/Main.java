//  D. From 1 to Infinity

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        long [] p10 = new long[17];
        p10[0] = 1;
        for (int i = 1; i < 17; i++) {
            p10[i] = p10[i - 1] * 10;
        }
        while (t-- > 0) {
            long k = Long.parseLong(br.readLine());
            
        }
        pw.flush();
        pw.close();
        br.close();
    }
}