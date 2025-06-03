//  A. Ambitious Kid

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = (long)Math.min(min, Math.abs(array[i]));
        }
//        if (min<0)
//            System.out.println(-min);
//        else
//            System.out.println(min);
        System.out.println(min);

    }
}