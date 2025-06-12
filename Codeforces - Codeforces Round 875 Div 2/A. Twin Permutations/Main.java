//  A. Twin Permutations

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
            int[] permutation = new int[n];
            for (int i = 0; i < n; i++) {
                permutation[i] = sc.nextInt();
                System.out.print(n + 1 - permutation[i] + " ");
            }
            System.out.println();

        }

    }
}