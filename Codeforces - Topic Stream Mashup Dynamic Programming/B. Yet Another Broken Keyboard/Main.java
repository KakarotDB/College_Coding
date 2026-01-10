//  B. Yet Another Broken Keyboard

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine(); //string for which all possible substrings need to be printed
        List<Character> letters = new ArrayList<>(); //letters still available on the keyboard
        st = new StringTokenizer(br.readLine());
        int[] present = new int[26];
        for (int i = 0; i < k; i++) {
            letters.add(st.nextToken().charAt(0));
            present[letters.get(i) - 'a'] = 1;
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (present[s.charAt(i) - 'a'] == 1)
                a[i] = 1;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1)
                f[i + 1] = f[i] + 1;
            else
                f[i + 1] = 0;
            ans += f[i + 1];
        }
        pw.println(ans);
        pw.flush();
        pw.close();
        br.close();
    }
}