//  B. All the Vowels Please

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int k = Integer.parseInt(br.readLine());
        String vowel = "aeiou";
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i*i <= k; i++) {
            if (k % i == 0 && i >= 5 && k >=5){
                factors.add(i);
                factors.add(k / i);
            }
        }
        if (factors.size() < 2)
            pw.println(-1);
        else {
            int n = factors.getFirst();
            int m = factors.get(1);
            String vowels = "aeiou";
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans.append(vowels.charAt((i + j) % 5));
                }
            }
            pw.println(ans.toString());
        }

        pw.flush();
        pw.close();
        br.close();
    }
}