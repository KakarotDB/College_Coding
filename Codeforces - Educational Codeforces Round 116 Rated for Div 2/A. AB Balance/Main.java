//  A. AB Balance

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
            StringBuilder s = new StringBuilder(br.readLine());
            int count = 0;
            if (s.charAt(0) == s.charAt(s.length()-1))
                pw.println(s);
            else {
                s.replace(s.length()-1, s.length(), String.valueOf(s.charAt(0)));
                pw.println(s);
            }




        }
        pw.flush();
        pw.close();
        br.close();

    }
}