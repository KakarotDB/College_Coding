//  A. Vadim's Collection

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
            int[] freq = new int[10];
            for(char ch : s.toCharArray()) {
                freq[ch - '0']++;
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 1; i <= 10; i++) {
                for (int j = 10 - i; j < 10; j++) {
                    if (freq[j] > 0) {
                        ans.append(j);
                        freq[j]--;
                        break;
                    }
                }
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}