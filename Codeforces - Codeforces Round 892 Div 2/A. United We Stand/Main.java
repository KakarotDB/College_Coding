//  A. United We Stand

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
            long[] array_a = new long[n];
            for (int i = 0; i < n; i++) {
                array_a[i] = sc.nextLong();
            }
            ArrayList<Long> array_B = new ArrayList<>();
            ArrayList<Long> array_C = new ArrayList<>();
            if (n == 1)
                System.out.println("-1");
            else if(all_same(array_a))
                System.out.println("-1");
            else
            {
                long max = Arrays.stream(array_a).max().getAsLong();
                for (int i = 0; i < n; i++) {
                    if (array_a[i] != max)
                        array_B.add(array_a[i]);
                    else
                        array_C.add(array_a[i]);
                }
                System.out.println(array_B.toArray().length + " "+ array_C.toArray().length);
                for (int i = 0; i < array_B.size(); i++) {
                    System.out.print(array_B.get(i)+ " ");
                }
                System.out.println();
                for (int i = 0; i < array_C.size(); i++) {
                    System.out.print(array_C.get(i) + " ");
                }
                System.out.println();
            }

        }

    }
    public static boolean all_same(long[] array)
    {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]!= array[i+1])
                return false;
        }
        return true;
    }
}