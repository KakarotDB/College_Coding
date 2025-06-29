//  D. Distinct Split

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
            StringBuilder sb = new StringBuilder();
            int[] prefix_Distinct = new int[n + 1];
            int[] suffix_Distinct = new int[n + 1];
            HashSet<Character> st = new HashSet<>();
            for(int i = 1; i <= n; i++){
                st.add(s.charAt(i-1));
                prefix_Distinct[i] = st.size();
            }
            st.clear();
            for(int i = n ; i >= 1; i--){
                st.add(s.charAt(i-1));
                suffix_Distinct[i] = st.size();
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = max(ans, prefix_Distinct[i] + suffix_Distinct[i+1]);
            }
            pw.println(ans);



        }
        pw.flush();
        pw.close();
        br.close();
    }
}