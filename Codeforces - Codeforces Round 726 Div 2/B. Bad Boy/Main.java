//  B. Bad Boy

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long i = Long.parseLong(st.nextToken());
            long j = Long.parseLong(st.nextToken());
            pw.println(n+ " " + m + " " + "1 1");
        }
        pw.flush();
        pw.close();
        br.close();

    }
}