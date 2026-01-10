//  B. Your Name

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
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken(" ");
            String s2 = st.nextToken(" ");
//            pw.println(s1 + " " + s2);
            int[] map1 = new int[26];
            int[] map2 = new int[26];
            for (int i = 0; i < n; i++) {
                map1[s1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < n; i++) {
                map2[s2.charAt(i) - 'a']++;
            }
            boolean check = true;
            for (int i = 0; i < 26; i++) {
                if (map1[i] != map2[i]) {
                    check = false;
                    break;
                }
            }

            if (check)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}