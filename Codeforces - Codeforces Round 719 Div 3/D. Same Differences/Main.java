//  D. Same Differences

import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(a[i] - i);
            }
            Map<Long, Long> fmap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                fmap.put(list.get(i), fmap.getOrDefault(list.get(i), 0L) + 1);
            }
            long ans = 0;
            for (Map.Entry<Long, Long> longLongEntry : fmap.entrySet()) {
                long freq = longLongEntry.getValue();
                if (freq == 1) {
                    continue;
                }
                ans += (freq * (freq - 1)) / 2;
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}