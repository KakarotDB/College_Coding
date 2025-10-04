//  C. MEX rose

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
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            int ans = 0;
            Map<Integer, Integer> fmap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                fmap.put(a[i], fmap.getOrDefault(a[i], 0) + 1);
            }

            int missingCount = 0;
            for (int i = 0; i < k; i++) {
                if (!fmap.containsKey(i)) missingCount++;
            }

            int countK = fmap.getOrDefault(k, 0);
            if (countK > missingCount)
                missingCount += (countK - missingCount);
            pw.println(missingCount);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}