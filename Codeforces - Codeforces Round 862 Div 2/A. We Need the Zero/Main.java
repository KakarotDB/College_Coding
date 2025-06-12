//  A. We Need the Zero

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            if (n%2 == 0)
            {
                int xors = 0;
                for (int i = 0; i < n; i++) {
                    xors^=array[i];
                }
                if (xors == 0)
                    System.out.println(3);
                else
                    System.out.println(-1);
            }
            else
            {
                int xors = 0;
                for (int i = 0; i < n; i++) {
                    xors^=array[i];
                }
                System.out.println(xors);
            }
        }

    }
}