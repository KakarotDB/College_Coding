//  A. Unit Array

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
            int count_negatives = 0, count_positives = 0;
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
                if (array[i] > 0)
                    count_positives++;
                else
                    count_negatives++;
            }
            int operations = 0;
            while (count_positives < count_negatives || count_negatives % 2 == 1)
            {
                count_positives++;
                count_negatives--;
                operations++;
            }
            if (count_negatives %2 == 1)
                System.out.println(operations+1);
            else
                System.out.println(operations);

        }

    }
}