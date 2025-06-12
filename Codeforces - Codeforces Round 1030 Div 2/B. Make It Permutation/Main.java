//  B. Make It Permutation

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            pw.println(2*n-1);
            for(int i = 1; i <= n; i++)
                pw.println(i + " " + 1 + " " + i);
            for(int i = 1; i <= n - 1; i++)
                pw.println(i + " " + (i+1) + " " + n);

        }
        pw.flush();
        pw.close();
        br.close();

    }
}