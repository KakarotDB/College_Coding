//  A. Halloumi Boxes

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
            int k =sc.nextInt();
            sc.nextLine();
            int[] boxes = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (isSorted(boxes))
            {
                System.out.println("YES");
                continue;
            }
            if (k>=2)
            {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }

    }
    public static boolean isSorted(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1])
                return false;
        }
        return true;
    }
}