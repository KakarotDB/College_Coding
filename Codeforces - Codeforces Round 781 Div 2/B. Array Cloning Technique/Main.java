//  B. Array Cloning Technique

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
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            int max_frequency = 0;
            Map<Long, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                frequencyMap.put(a[i], frequencyMap.getOrDefault(a[i], 0) + 1);
                int current_frequency = frequencyMap.get(a[i]);
                max_frequency = max(current_frequency, max_frequency);
            }
            int ans = 0;
            while (max_frequency < n) {
                ans++;
                if (max_frequency * 2 <= n) {
                    ans += max_frequency;
                    max_frequency *= 2;
                } else {
                    ans += (n - max_frequency);
                    max_frequency = n;
                }

            }
            pw.println(ans);


        }
        pw.flush();
        pw.close();
        br.close();

    }

    public static boolean isAllElementsSame(long[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] != prices[i + 1])
                return false;
        }
        return true;
    }
}