//  B. Indivisible

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
            if (n % 2 != 0 && n != 1)
                pw.println(-1);
            else {
                List<Integer> list = new ArrayList<>();
                int i = 1;
                if(n == 1) {
                    pw.println(1);
                    continue;
                }

                while(i < n) {
                    list.add(i + 1);
                    list.add(i);
                    i+=2;
                }
                for (Integer integer : list) {
                    pw.print(integer + " ");
                }
                pw.println();
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}