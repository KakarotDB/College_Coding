//  A. Only One Digit

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
            String x = br.readLine();
            pw.println((x.chars().map(c -> c - '0').min().getAsInt()));
        }
        pw.flush();
        pw.close();
        br.close();
    }
}