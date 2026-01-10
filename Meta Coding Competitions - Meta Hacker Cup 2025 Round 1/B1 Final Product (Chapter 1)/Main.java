//  B1: Final Product (Chapter 1)

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
        int c = 1;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            pw.print("Case #" + c + ": ");
            for (int i = 0; i < 2 * n - 1; i++) {
                pw.print(1 + " ");
            }
            pw.print(b);
            pw.println();
            c++;
        }
        pw.flush();
        pw.close();
        br.close();
    }
}