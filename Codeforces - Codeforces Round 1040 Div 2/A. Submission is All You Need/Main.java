//  A. Submission is All You Need

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
            int n = Integer.parseInt(br.readLine());
            int[] s = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            int count_0 = 0;
            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
                sum += s[i];
                if (s[i] == 0) count_0++;
            }
            pw.println(sum + count_0);

        }
        pw.flush();
        pw.close();
        br.close();
    }
}