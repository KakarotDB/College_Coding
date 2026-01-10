//  B. JoJo's Incredible Adventures

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
            String s = br.readLine();
            long k = 0;
            if (s.length() == 1 && s.charAt(0) == '1') {
                pw.println(1);
                continue;
            }
            s += s;
//            pw.println(s);

            long current = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    current++;
                    k = max(current, k);
                }
                else
                    current = 0;
            }
            long n = s.length() / 2;

            if (k > n) {
                pw.println((long) n * n);
            }
            else {
                pw.println(((k + 1) / 2) * ((k + 2) / 2));
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}