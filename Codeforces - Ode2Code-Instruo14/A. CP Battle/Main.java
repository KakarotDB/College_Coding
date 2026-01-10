//  A. CP Battle

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");

        String s = br.readLine();
        long countA = s.chars().filter(ch -> ch == 'B').count();
        long countB = s.chars().filter(ch -> ch == 'A').count();
        if (abs(countA - countB) == 1)
            pw.println("YES");
        else
            pw.println("NO");

        pw.flush();
        pw.close();
        br.close();
    }
}