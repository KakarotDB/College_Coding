//  A. Desorting

import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n =sc.nextInt();
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextLong();
            }
            if (!isSorted(array))
                System.out.println("0");
            else
            {
                long minAdjacentDifference = Long.MAX_VALUE;
                for (int i = 0; i < n-1; i++) {
                    minAdjacentDifference = Math.min(minAdjacentDifference, array[i+1] - array[i]);
                }
                System.out.println(minAdjacentDifference/2+1);
            }

        }

    }
    public static boolean isSorted(long[] array){
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1])
                return false;
        }
        return true;
    }
}