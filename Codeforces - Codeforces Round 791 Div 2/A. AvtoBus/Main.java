//  A. AvtoBus

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
            long n = Long.parseLong(br.readLine());
            if (n % 2 == 1 || n < 4)
                pw.println(-1);
            else {
                pw.println((n + 5) / 6 + " " + n / 4);
            }
        }
        pw.flush();
        pw.close();
        br.close();

    }
}