//  A. In the Dream

import com.sun.jdi.IntegerType;

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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int secondHalfR = c - a;
            int secondhalfK = d - b;
            if (isHalfPossible(a, b) && isHalfPossible(secondHalfR, secondhalfK))
                pw.println("YES");
            else
                pw.println("NO");

        }
        pw.flush();
        pw.close();
        br.close();

    }
    public static boolean isHalfPossible(int x, int y) {
        if (x > 2 * (y + 1))
            return false;
        if (y > 2 * (x + 1))
            return false;
        return true;
    }
}