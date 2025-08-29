//  A. LRC and VIP

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
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int distinct = (int) Arrays.stream(a).distinct().count();
            if (distinct == 1)
                pw.println("No");
            else {
                pw.println("Yes");
                ArrayList<Integer> b = new ArrayList<>();
                int max = (int) Arrays.stream(a).max().getAsInt();
                for (int i = 0; i < n; i++) {
                    if (a[i] == max)
                        b.add(1);
                    else
                        b.add(2);
                }
                for (int i = 0; i < b.size(); i++) {
                    pw.print(b.get(i) + " ");
                }
                pw.println();
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}