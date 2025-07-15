//  B. Fair Numbers

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
            long n = Long.parseLong(br.readLine());
            while (!isFair(n))
                n++;
            pw.println(n);
        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static boolean isFair(long n) {
        long num = n;
        while (num > 0) {
            long digit = num % 10;
            if (digit != 0 && n % digit != 0)
                return false;
            num /= 10;
        }
        return true;
    }
}