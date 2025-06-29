//  B. Roof Construction

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
            n--; 
            int msb = 31 - Integer.numberOfLeadingZeros(n);
//            pw.println(msb);
            ArrayList<Integer> ans = new ArrayList<>();
            int num = (int) pow(2, msb) - 1;
            while (num >= 0) {
                ans.add(num);
                num--;
            }
            num = (int) pow(2, msb);
            while (num <= n) {
                ans.add(num);
                num++;
            }
            for (Integer an : ans) {
                pw.print(an + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}