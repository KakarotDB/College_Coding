//  B. Comparison String

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int count_lesser = 0, max_count_lesser = 0;
            int count_greater = 0, max_count_greater = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '<') {
                    count_lesser++;
                    max_count_lesser = max(max_count_lesser, count_lesser);
                }
                else
                    count_lesser=0;
                if (s.charAt(i) == '>')
                {
                    count_greater++;
                    max_count_greater = max(max_count_greater, count_greater);
                }
                else
                    count_greater = 0;
            }
            if (max_count_greater >= max_count_lesser)
                System.out.println(max_count_greater+1);
            else
                System.out.println(max_count_lesser+1);

        }

    }
}