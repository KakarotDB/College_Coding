//  A. Painting With Two Colors

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
            long n = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
//            pw.println(t);
            if (n % 2 != 0) {
                if (a <= b) {
                    if (b % 2 != 0)
                        pw.println("YES");
                    else
                        pw.println("NO");
                }
                else {
                    if (a % 2 != 0 && b % 2 != 0)
                        pw.println("YES");
                    else
                        pw.println("NO");
                }
            }
            else {
                if (a <= b) {
                    if (b % 2 == 0)
                        pw.println("YES");
                    else
                        pw.println("NO");
                }
                else {
                    if (a % 2 == 0 && b % 2 == 0)
                        pw.println("YES");
                    else
                        pw.println("NO");
                }
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}