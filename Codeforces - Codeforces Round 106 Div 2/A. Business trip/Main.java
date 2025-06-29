//  A. Business trip

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int k = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        int ans = 0;
        int sum = 0;
        int i = a.length - 1;
        while (sum < k && i >= 0) {
            sum += a[i];
            i--;
            ans++;
        }
        if (sum < k)
            pw.println(-1);
        else
            pw.println(ans);
        pw.flush();
        pw.close();
        br.close();
    }
}