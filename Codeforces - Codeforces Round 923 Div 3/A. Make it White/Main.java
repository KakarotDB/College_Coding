//  A. Make it White

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder out = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int first = s.indexOf('B');
            int last = s.lastIndexOf('B');
            out.append(last - first + 1).append("\n");
        }
        pw.println(out);
        pw.flush();
        pw.close();
        br.close();
    }
}