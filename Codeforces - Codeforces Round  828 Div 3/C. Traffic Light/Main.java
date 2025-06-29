//  C. Traffic Light

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
            int n = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            String s = br.readLine();
//            System.out.println("s = " + s);
            s = s + s;
            int ans = Integer.MIN_VALUE;
            int last = -1;
            n *= 2;
            for(int i = n - 1; i >= 0; i--){
                if (s.charAt(i) == 'g')
                    last = i;
                if (s.charAt(i) == c)
                    ans = max(ans, last - i);
            }
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}