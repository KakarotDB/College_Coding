//  A. How Much Does Daytona Cost?

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] array = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
                if (array[i] == k)
                    count++;
            }
            if (count>=1)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}