//  Associative Array

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        HashMap<Long, Long> a = new HashMap<>();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long ts = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            if (ts == 0) {
                long v = Long.parseLong(st.nextToken());
                a.put(k, v);
            } else if (ts == 1) {
                pw.println(a.getOrDefault(k, 0L));
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}