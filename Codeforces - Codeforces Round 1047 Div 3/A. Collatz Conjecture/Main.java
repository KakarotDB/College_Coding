//  A. Collatz Conjecture

import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            pw.println(( x * (int)pow(2, k )));
        }
        pw.flush();
        pw.close();
        br.close();
        
    }
}