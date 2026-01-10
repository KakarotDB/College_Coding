//  B. Skibidus and Ohio

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
        testCase:
        while (t-- > 0) {
            String s = br.readLine();
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == s.charAt(i)) {
                    pw.println(1);
                    continue testCase;
                }
            }
            pw.println(s.length());
        }
        pw.flush();
        pw.close();
        br.close();
    }
}