//  A. Everybody Likes Good Arrays!

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while(t-->0)
        {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] array = new int[n];
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i = 0; i < n-1; i++) {
                if (sameParity(array[i], array[i+1]))
                    count++;
            }
            System.out.println(count);

        }

    }
    public static boolean sameParity(int a, int b)
    {
        return (a % 2 == 0 && b % 2 == 0) || (a % 2 == 1 && b % 2 == 1);
    }
}