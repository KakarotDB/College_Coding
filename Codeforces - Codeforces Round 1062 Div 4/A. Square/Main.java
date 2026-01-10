//  A. Square?

import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (a == b && b == c && c == d)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}