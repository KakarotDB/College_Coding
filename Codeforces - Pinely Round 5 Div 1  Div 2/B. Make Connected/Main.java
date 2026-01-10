//  B. Make Connected

import com.sun.source.tree.Tree;

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

            char[][] grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = s.charAt(j);
                }
            }

            TreeSet<Integer> sum = new TreeSet<>();
            TreeSet<Integer> diff = new TreeSet<>();
            TreeSet<Integer> x = new TreeSet<>();
            TreeSet<Integer> y = new TreeSet<>();
            int count3 = 0;
            boolean cont3 = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '#') {
                        sum.add(i + j);
                        diff.add(i - j);
                        x.add(i);
                        y.add(j);
                    }

                }
            }

            if (x.size() < 2 && y.size() < 2) {
                pw.println("YES");
                continue;
            }
            boolean check = false;

            check = (x.last() - x.first() <= 1) && (y.last() - y.first() <= 1);
            check |= sum.last() - sum.first() <= 1;
            check |= diff.last() - diff.first() <= 1;
            if (check)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}