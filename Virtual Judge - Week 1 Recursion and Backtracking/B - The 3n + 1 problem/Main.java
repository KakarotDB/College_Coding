//  B - The 3n + 1 problem

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());
            int max_length = 0;
            int current_length = 0;
            for (int k = i; k <= j; k++) {
                current_length = CycleSize(k, 0);
                max_length = max(current_length, max_length);
            }
            pw.println(i + " " + j + " " + max_length);
        }

        pw.flush();
        pw.close();
        br.close();

    }

    public static int CycleSize(int n, int length) {
        if (n == 1)
            return length + 1;
        if (n % 2 == 0)
            return CycleSize(n / 2, length + 1);
        return CycleSize(3 * n + 1, length + 1);
    }
}