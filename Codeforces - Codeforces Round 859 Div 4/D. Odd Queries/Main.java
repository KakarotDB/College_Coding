//  D. Odd Queries

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] array = new long[n];
            long[] prefix_sum = new long[n+1];
            long old_sum = 0;
            for (int i = 0; i < n; i++) {
                old_sum+=array[i] = Long.parseLong(st.nextToken());
            }
            for (int i = 1 ; i <= n; i++)
            {
                prefix_sum[i] = prefix_sum[i-1] +array[i-1];
            }
            while (q-- > 0)
            {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                long sum_to_remove = prefix_sum[r] - prefix_sum[l-1];
                long sum_to_add = (r-l+1) * k;
                long new_sum = old_sum - sum_to_remove + sum_to_add;
                if (new_sum % 2 == 1)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }
}