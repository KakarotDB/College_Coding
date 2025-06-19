//  B. Above the Clouds

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
            String s = br.readLine();
            int[] charCounts = new int[26];
            for (char charCount : s.toCharArray()) {
                charCounts[charCount -'a']++;
            }
            boolean possible = false;
            for (int i = 1; i < n - 1; i++)
            {
                char charB = s.charAt(i);
                if (charCounts[charB - 'a'] >= 2){
                    possible = true;
                    break;
                }
            }
            if (possible)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();

    }
}