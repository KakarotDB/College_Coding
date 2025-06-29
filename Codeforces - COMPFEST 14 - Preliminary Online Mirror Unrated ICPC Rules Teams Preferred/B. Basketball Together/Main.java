//  B. Basketball Together

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long[] powers = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            powers[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(powers);
        int ans = 0;
        int team_size = 1;
        int left_pointer = -1, right_pointer = n - 1;
        while (left_pointer < right_pointer) {
            if (powers[right_pointer] * team_size <= d) {
                left_pointer++;
                team_size++;
            }
            else {
                ans++;
                team_size = 1;
                right_pointer--;
            }
        }
        pw.println(ans);

        pw.flush();
        pw.close();
        br.close();
    }
}