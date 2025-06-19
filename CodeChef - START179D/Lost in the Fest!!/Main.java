//  Lost in the Fest!!

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] H = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                H[i] = Integer.parseInt(st.nextToken());
            }
            int height = H[n - 1];
            int j = -1;
            for (int i = 0; i < n; i++) {
                if (H[i] >= height) {
                    j = i;
                    break;
                }
            }
            pw.println(j == -1 ? 0 : (n - 1 - j));
        }
        pw.flush();
        pw.close();
        br.close();

    }
}