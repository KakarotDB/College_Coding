//  B. No Casino in the Mountains

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
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int counter = 0;
            int hikes = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) counter++;
                else counter = 0;
                if (counter == k) {
                    hikes++;
                    counter = 0;
                    i++;
                }
            }
            pw.println(hikes);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}