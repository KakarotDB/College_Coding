//  A. Doremy's Paint 3

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
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int distinct = (int)Arrays.stream(array).distinct().count();
            if (distinct>2)
                System.out.println("NO");
            else if (n == 2) {
                System.out.println("YES");

            }
            else if (distinct == 2)
            {
                int count0 = 0;
                for (int i = 0; i < n; i++) {
                    if (array[i] == array[0])
                        count0++;
                }
                int count1 = n-count0;
                if (n%2 == 0)
                {
                    if (count0 == n/2 && count1 ==n/2)
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }
                else
                {
                    if (count0 == n/2 || count1 == n/2)
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }
            }
            else if(distinct == 1)
                System.out.println("YES");


        }

    }
}