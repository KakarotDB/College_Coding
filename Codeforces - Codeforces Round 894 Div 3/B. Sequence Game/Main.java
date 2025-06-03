//  B. Sequence Game

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int[] sequence_b = new int[n];
            for (int i = 0; i < n; i++) {
                sequence_b[i] = sc.nextInt();
            }
            int m = 1;
            int[] sequence_a = new int[2 * n];
            sequence_a[0] = sequence_b[0];
            for (int i = 0; i < n - 1; i++) {
                if (sequence_b[i + 1] >= sequence_b[i]) {
                    sequence_a[m] = sequence_b[i + 1];
                    m++;
                } else {
                    sequence_a[m++] = sequence_b[i + 1];
                    sequence_a[m++] = sequence_b[i + 1];
                }
            }
            System.out.println(m);
            for (int i = 0; i < m; i++) {
                System.out.print(sequence_a[i] + (i == m - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}