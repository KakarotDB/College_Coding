//  B. Swap and Delete

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
            String s = br.readLine();
            int c1 = (int) s.chars().filter(c -> c == '1').count();
            int c0 = (int) s.chars().filter(c -> c == '0').count();
            int t_size = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0' && c1 > 0) {
                    c1--;
                    t_size++;
                } else if (s.charAt(i) == '1' && c0 > 0) {
                    c0--;
                    t_size++;
                }
                else
                    break;
            }
            pw.println(s.length()-t_size);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}