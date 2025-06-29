//  Two Knights

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            long total_combinations = (((long) i * i) * ((long) i * i - 1) / 2);
            int attacking_knights = 4 * (i - 1) * (i - 2);
            pw.println(total_combinations - attacking_knights);
        }


        pw.flush();
        pw.close();
        br.close();
    }
}