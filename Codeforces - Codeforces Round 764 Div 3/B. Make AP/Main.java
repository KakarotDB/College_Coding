//  B. Make AP

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            boolean answer = false;
            if ((2 * b - c) / a > 0 && (2 * b - c) % a == 0)
                answer = true;
            if ((2 * b - a) / c > 0 && (2 * b - a) % c == 0)
                answer = true;
            if ((a + c) / (2 * b) > 0 && (a + c) % (2 * b) == 0)
                answer = true;
            if (answer)
                pw.println("YES");
            else
                pw.println("NO");

        }
        pw.flush();
        pw.close();
        br.close();

    }
}