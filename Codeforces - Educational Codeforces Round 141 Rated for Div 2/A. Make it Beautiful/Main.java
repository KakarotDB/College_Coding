//  A. Make it Beautiful

import java.util.*;
import java.lang.*;

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
            int count_distinct = (int) Arrays.stream(array).distinct().count();
            if (count_distinct == 1)
                System.out.println("NO");
            else
            {
                int max = (int) Arrays.stream(array).max().getAsInt();
                int index_of_max = 0;
                for (int i = 0; i < n; i++) {
                    if (array[i] == max) {
                        index_of_max = i;
                        break;
                    }
                }
                int temp = array[0];
                array[0] = array[index_of_max];
                array[index_of_max] = temp;
                System.out.println("YES");
                for (int i = 0; i < n; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
            }

        }

    }
}