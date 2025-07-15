//  C. Move Brackets

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
            int n = Integer.parseInt(br.readLine());
//            String s = br.readLine();
            StringBuilder s = new StringBuilder(br.readLine());
            int sum = 0;
            int operations = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')
                    sum++;
                else
                    sum--;
                if (sum < 0) {
                    sum = 0;
                    operations++;
                }
            }
            pw.println(operations);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}