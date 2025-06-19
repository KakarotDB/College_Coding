//  A. Soft Drinking

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int nl  = Integer.parseInt(st.nextToken());
        int np = Integer.parseInt(st.nextToken());
        int drinks = (k * l) / nl;
        int limes = c * d;
        int salt = p / np;
        pw.print(min(drinks, min(salt, limes)) / n);
        pw.flush();
        pw.close();
        br.close();
    }
}