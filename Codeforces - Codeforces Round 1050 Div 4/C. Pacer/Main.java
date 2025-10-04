//  C. Pacer

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long totalPoints = 0;
            long currentSide = 0;
            long lastTime = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                long reqTime = Long.parseLong(st.nextToken());
                long reqSide = Long.parseLong(st.nextToken());
                long tdiff = reqTime - lastTime;
                long sideDiff = abs(reqSide - currentSide);
                if (tdiff % 2 == sideDiff % 2) {
                    totalPoints += tdiff;
                }
                else {
                    totalPoints += tdiff - 1;
                }
                currentSide = reqSide;
                lastTime = reqTime;
            }
            totalPoints += (m - lastTime);
            pw.println(totalPoints);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}