//  A. Silent Classroom

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        int[] fmap = new int[26];
        while (t-- > 0) {
            String i = br.readLine();
            fmap[i.charAt(0) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < fmap.length; i++) {
            if (fmap[i] > 0) {
                int k1 = fmap[i] / 2;
                int k2 = fmap[i] - k1;
                ans += (k1 * (k1 - 1)) / 2 + (k2 * (k2 - 1)) / 2;
            }
        }
        pw.println(ans);
        pw.flush();
        pw.close();
        br.close();
    }
}