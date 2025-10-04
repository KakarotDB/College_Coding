//  B. Not Quite a Palindromic String

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.function.DoubleToIntFunction;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            long count_0 = s.chars().filter(ch -> ch == '0').count();
            long count_1 = s.chars().filter(ch -> ch == '1').count();
            long kMin = abs(count_0 - count_1) / 2;
            long kMax = count_1 / 2 + count_0 / 2;
            if (k >= kMin && k <= kMax && (k - kMin) % 2 == 0)
                out.append("YES\n");
            else
                out.append("NO\n");
        }
        pw.print(out);
        pw.flush();
        pw.close();
        br.close();

    }
}