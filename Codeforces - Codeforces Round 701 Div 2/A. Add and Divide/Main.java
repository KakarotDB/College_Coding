//  A. Add and Divide

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
           long a = Long.parseLong(st.nextToken());
           long b = Long.parseLong(st.nextToken());
           long ans = Integer.MAX_VALUE;
            for (int addition = 0; addition < 32; addition++) {
                long operations = addition;
                long new_b = b + addition;
                if (new_b == 1)
                    continue;
                long copy_a = a;
                while (copy_a > 0) {
                    copy_a/=new_b;
                    operations++;
                }
                ans = min(ans, operations);
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}