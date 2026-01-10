//  Nutrition Cost

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
            int c = Integer.parseInt(st.nextToken());
            int[] vitamins = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                vitamins[i] = Integer.parseInt(st.nextToken());
            }
            int[] costs = new int[n];
            int y = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                y+=costs[i] = Integer.parseInt(st.nextToken());
            }
            int x = (int) Arrays.stream(vitamins).distinct().count();
            
        }
        pw.flush();
        pw.close();
        br.close();

    }
}
