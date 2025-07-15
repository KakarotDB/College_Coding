//  D. Binary String Battle

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            StringBuilder s = new StringBuilder(br.readLine());
            int count_1 = (int) s.chars().filter(ch -> ch == '1').count();
            if (count_1 >= k + 1 && n >= 2 * k)
                pw.println("Bob");
            else
                pw.println("Alice");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}