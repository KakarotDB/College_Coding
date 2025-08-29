//  C. Even Larger

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
            List<Long> a = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Long.parseLong(st.nextToken()));
            }
            if (n % 2 == 0)
                a.add(0L);
            long ops = 0;
            for (int i = 1; i < a.size() - 1; i+=2) {
                if (a.get(i) < a.get(i - 1) + a.get(i + 1)) {
                    long no_ops = abs(a.get(i + 1) + a.get(i - 1) - a.get(i));
                    ops += abs(a.get(i + 1) + a.get(i - 1) - a.get(i));
                    a.set(i + 1, a.get(i + 1) - no_ops);
                    if (a.get(i + 1) < 0) a.set(i + 1, 0L);
                }
            }
            pw.println(ops);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}