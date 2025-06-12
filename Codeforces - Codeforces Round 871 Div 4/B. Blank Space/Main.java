//  B. Blank Space

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
            int[] binary = new int[n];
            int count_of_zeros = 0;
            int max_blank_space = 0;
            for (int i = 0; i < n; i++) {
                binary[i] = sc.nextInt();
                if (binary[i] == 0)
                    count_of_zeros++;
                else
                    count_of_zeros = 0;
                max_blank_space = Math.max(count_of_zeros, max_blank_space);
            }
            System.out.println(max_blank_space);



        }

    }
}