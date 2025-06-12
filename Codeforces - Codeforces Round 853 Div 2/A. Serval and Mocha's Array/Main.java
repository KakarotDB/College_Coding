//  A. Serval and Mocha's Array

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            boolean flag = false;
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (gcd(array[i], array[j] ) <= 2)
                        flag = true;
                }
            }
            if (flag)
                System.out.println("Yes");
            else
                System.out.println("No");

        }

    }
    public static int gcd(int a, int b) {
        if (a==0 && b==0)
            return 0;
        if (a==0)
            return b;
        if (b==0)
            return a;

        if (a<0)
            a = -a;
        if (b<0)
            b = -b;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}