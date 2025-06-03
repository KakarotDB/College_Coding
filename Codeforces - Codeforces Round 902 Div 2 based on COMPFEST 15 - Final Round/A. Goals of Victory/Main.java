//  A. Goals of Victory

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int[] efficiency = new int[n-1];
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum+= efficiency[i] = sc.nextInt();
            }
            System.out.println(-sum);

        }
    }
}