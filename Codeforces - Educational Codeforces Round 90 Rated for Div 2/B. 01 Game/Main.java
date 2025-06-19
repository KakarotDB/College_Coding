//  B. 01 Game

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
            String s = br.readLine();
            int n = s.length();
            int count1s =(int) s.chars().filter( ch -> ch == '1').count();
            int count0s = (int) s.chars().filter(ch -> ch == '0').count();
            int turns = min(count0s, count1s);
            if (turns % 2 == 1)
                pw.println("DA");
            else
                pw.println("NET");

        }
        pw.flush();
        pw.close();
        br.close();

    }
}