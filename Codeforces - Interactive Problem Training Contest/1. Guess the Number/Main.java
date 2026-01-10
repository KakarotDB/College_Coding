//  1. Guess the Number

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
//        int t = Integer.parseInt(br.readLine());
        int l = 1, r = 1000000;
        while (l != r) {
            int mid = (l + r + 1) >> 1;
            pw.println(mid);
            pw.flush();

            String response = br.readLine();

            if (response.equals("<")) {
                r = mid - 1;
            }
            else
                l = mid;
        }
        pw.println("! " + l);
        pw.flush();
        pw.close();
        br.close();
    }
}