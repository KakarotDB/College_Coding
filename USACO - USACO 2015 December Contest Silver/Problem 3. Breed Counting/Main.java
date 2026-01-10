//  Problem 3. Breed Counting

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] cow1 = new int[n + 1];
        int[] cow2= new int[n + 1];
        int[] cow3 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int cowID = Integer.parseInt(br.readLine());
            cow1[i] += cow1[i - 1];
            cow2[i] += cow2[i - 1];
            cow3[i] += cow3[i - 1];

            if (cowID == 1) cow1[i]++;
            else if (cowID == 2) cow2[i]++;
            else if (cowID == 3) cow3[i]++;
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int cows1 = cow1[end] - cow1[start -1];
            int cows2 = cow2[end] - cow2[start - 1];
            int cows3 = cow3[end] - cow3[start - 1];
            pw.println(cows1 + " " + cows2 + " " + cows3);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}