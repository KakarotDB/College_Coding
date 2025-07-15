//  B. Erase First or Second Letter

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
            StringBuilder s = new StringBuilder(br.readLine());
            int[] frequency = new int[26];
            int count = 0;
            ArrayList<Integer> distinct = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int index = (int) s.charAt(i) - 'a';
                frequency[index]++;
                if (frequency[index] == 1)
                    count++;
                distinct.add(count);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans+=distinct.get(i);
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}