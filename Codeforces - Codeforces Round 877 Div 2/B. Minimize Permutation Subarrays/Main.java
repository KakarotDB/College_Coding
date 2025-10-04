//  B. Minimize Permutation Subarrays

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
            int n = Integer.parseInt(br.readLine());
            List<Integer> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            int indexOf1 = a.indexOf(1);
            int indexOf2 = a.indexOf(2);
            int indexOfn = a.indexOf(n);
            if (indexOfn > max(indexOf1, indexOf2)) {
                pw.println((indexOfn + 1) + " " + (max(indexOf1, indexOf2) + 1));
            } else if (indexOfn < min(indexOf1, indexOf2)) {
                pw.println((indexOfn + 1) + " " + (min(indexOf1, indexOf2) + 1));
            }
            else
                pw.println("1 1");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}