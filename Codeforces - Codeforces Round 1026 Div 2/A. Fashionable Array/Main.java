//  A. Fashionable Array

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
            ArrayList<Integer> a = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(a);
            int start = 0, end = n - 1;
            while (a.get(end) % 2 != a.getFirst() % 2) end--;
            while (a.get(start) % 2 != a.get(n - 1) % 2) start++;
            pw.println(min(start, n - 1 - end));
        }
        pw.flush();
        pw.close();
        br.close();
    }
}