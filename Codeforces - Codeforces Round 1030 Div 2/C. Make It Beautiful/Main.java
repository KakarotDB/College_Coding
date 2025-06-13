//  C. Make It Beautiful

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = Long.parseLong(st.nextToken());
            }
            long answer = 0;
            for (int i = 0; i < 63; i++) {
                PriorityQueue<Long> pq = new PriorityQueue<>();
                long num  = (long) 1<<i;
                for (int j = 0; j < n; j++) {
                    long element = array[j];
                    if ((num & element) > 0)
                        answer++;
                    else
                    {
                        pq.add(num);
                    }

                }
                while (!pq.isEmpty() && k>=pq.peek())
                {
                    long costToSetBit = pq.poll();
                    answer++;
                    k-=costToSetBit;
                }

            }
            System.out.println(answer);
        }
    }
}