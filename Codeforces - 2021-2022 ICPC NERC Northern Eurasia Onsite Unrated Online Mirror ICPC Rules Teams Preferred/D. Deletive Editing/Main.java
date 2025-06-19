//  D. Deletive Editing

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String target = st.nextToken();
            StringBuilder ans = new StringBuilder();
            int[] frequency_in_target = new int[26];
            for (int i = 0; i < target.length(); i++) {
                frequency_in_target[target.charAt(i)-'A']++;
            }
            for (int i = s.length() - 1; i >= 0 ; i--){
                if (frequency_in_target[s.charAt(i) - 'A'] > 0) {
                    ans.append(s.charAt(i));
                    frequency_in_target[s.charAt(i) - 'A']--;
                }

            }
            pw.println(target.equals(ans.reverse().toString())?"YES":"NO");
            
        }
        pw.flush();
        pw.close();
        br.close();

    }

}