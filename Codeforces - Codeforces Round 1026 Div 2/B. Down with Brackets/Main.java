//  B. Down with Brackets

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
            int n = s.length();
            s.deleteCharAt(n -1);
            s.deleteCharAt(0);
            int bal = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')
                    bal++;
                else bal--;
                if (bal < 0)
                {
                    pw.println("YES");
                    break;
                }
            }
            if (bal < 0)
                continue;
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}