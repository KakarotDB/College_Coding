//  A. Case of the Zeros and Ones

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int c1 = (int) s.chars().filter(ch -> ch == '1').count();
        int c0 = (int) s.chars().filter(ch -> ch == '0').count();
        int ans = abs(c0-c1);
        pw.println(ans);
        pw.flush();
        pw.close();
        br.close();
    }
}