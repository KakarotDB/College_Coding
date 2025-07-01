//  B. MEXor Mixup

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
            int xor = 0;
            if ((a - 1) % 4 == 0)
                xor = a - 1;
            else if ((a - 1) % 4 == 1)
                xor = 1;
            else if ((a - 1) % 4 == 2)
                xor = a;
            else if ((a - 1) % 4 == 3)
                xor = 0;
            if (xor == b)
                pw.println(a);
            else if ((xor ^ b) != a)
                pw.println(a + 1);
            else
                pw.println(a + 2);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}