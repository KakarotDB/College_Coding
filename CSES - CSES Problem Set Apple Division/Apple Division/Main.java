//  Apple Division

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int n;
    static long[] apples;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        apples = new long[n];
        for (int i = 0; i < n; i++) {
            apples[i] = sc.nextLong();
        }
        System.out.println(recurseApples(0, 0, 0));
    }
    public static long recurseApples(int index, long sum1, long sum2)
    {
        if (index == n)
            return Math.abs(sum1-sum2);
        return
                Math.min(recurseApples(index+1, sum1+apples[index], sum2),
                        recurseApples(index+1, sum1, sum2+apples[index]));
    }
}